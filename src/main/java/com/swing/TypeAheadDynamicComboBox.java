/**
 * 
 */
package com.swing;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicComboBoxEditor;

/**
 * Extends {@link JComboBox} to allow the user to type just the first few
 * characters of an item in the list.  The remaining text in the item will
 * show up in the selection box, but highlighted so that if the user keeps
 * typing, he/she will replace the new characters.
 * <br><br>
 * Example:<br>
 * <ul>
 *  <li>User types A</li>
 *  <li>Box displays A[labama] (brackets are selected text)</li>
 *  <li>User types r</li>
 *  <li>Box displays Ar[kansas]</li>
 *  <li>User types k</li>
 *  <li>Box displays Ark[ansas]</li>
 * </ul>
 * <br>
 * <b>Note:</b> To use TypeAheadComboBox inside a {@link javax.swing.JTable}, use
 *              the {@link gov.gdot.swing.tablemodels.editors.ComboCellEditor}
 *              instead of a DefaultCellEditor.
 * 
 * @author jcrowe
 */
public class TypeAheadDynamicComboBox extends BetterComboBox {

    protected boolean isSorted;
    private boolean allowNewValues;
    private Stringifier stringifier;

    /**
     * 
     */
    public TypeAheadDynamicComboBox() {
        super();
        init();
    }

    public TypeAheadDynamicComboBox(Stringifier stringifier) {
        this.stringifier = stringifier;
        this.setRenderer(new StringyListCellRenderer(stringifier));
        init();
    }
    
    public Stringifier getStringifier() {
        return stringifier;
    }

    /**
     * Initializes JComboBox parameters that will make the combo box
     * behave properly for type ahead.
     */
    private void init() {
        allowNewValues = false;
        TypeAheadEditor edit = new TypeAheadEditor(this);
        this.setEditable(true);
        this.setEditor(edit);
    }
    
    

    /**
     * Handles edits in the edit field of the combo box, in order to search
     * for items in the list.
     * 
     * @author jcrowe
     */
    public class TypeAheadEditor extends BasicComboBoxEditor implements DocumentListener, KeyListener, Runnable {

        JComboBox comboBox;
        int lastLength;
        Character keyTyped;
        private Object oldValue;
        
        public TypeAheadEditor(JComboBox comboBox) {
            //this.editor.addKeyListener(this);
            this.editor.getDocument().addDocumentListener(this);
            this.editor.addKeyListener(this);
            this.comboBox = comboBox;
            this.lastLength = 0;
            this.keyTyped = null;
        }
        

        public void setItem(Object anObject) {
        	System.out.println(stringifier);
            if (!String.class.isInstance(anObject) && stringifier != null && anObject != null) {
                editor.setText(stringifier.stringify(anObject));
                oldValue = anObject;    
            } else {
                super.setItem(anObject);
            }
        }

        public Object getItem() {
            if (stringifier == null) {
                return super.getItem();
            } else {
                Object newValue = editor.getText();
                
                if (oldValue != null && !(oldValue instanceof String))  {
                    // The original value is not a string. Should return the value in it's
                    // original type.
                    if (newValue.equals(stringifier.stringify(oldValue)))  {
                        return oldValue;
                    } 
                }
                return newValue;
            }
        }
        
        public void insertUpdate(DocumentEvent e) {
        }

        public void removeUpdate(DocumentEvent e) {
        }

        public void changedUpdate(DocumentEvent e) {
            // do nothing
        }

        public void keyPressed(KeyEvent e) {
            calculateValue();
        }

        public void keyReleased(KeyEvent e) {
            // do nothing
        }

        public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == KeyEvent.VK_TAB) {
                // MILES WUZ HEAR
                if (isPopupVisible()) {
                    hidePopup();
                }
            } else if (!(e.isActionKey() || 
                        e.getKeyChar() == KeyEvent.VK_END ||
                        e.getKeyChar() == KeyEvent.CHAR_UNDEFINED)) {
                keyTyped = new Character(e.getKeyChar());
            }
        }

        /**
         *  Invoke this object to update the selection.  See the {@link run} method.
         */
        public void calculateValue() {
            //run();
            SwingUtilities.invokeLater(this);
        }


        /**
         * Resolves what the user has typed with an item in the list.  Takes
         * the text in the box and matches it to the first item in the list 
         * that starts with that text.  Replaces the text with the full item, 
         * and selects the text that the user did not actually enter, so that
         * if the user continues to type something else, that text will disappear.
         */
        public void run() {
            String newValue = "";
            String oldValue = editor.getText();

            if (oldValue.length() == 0) {
                comboBox.setSelectedIndex(-1);
            } else if (keyTyped != null && oldValue != null && oldValue.length() > 0) {
                char key = keyTyped.charValue();

                if (key == KeyEvent.VK_DELETE) {
                    // don't let the user delete
                    Toolkit.getDefaultToolkit().beep();
                } else if (key == KeyEvent.VK_BACK_SPACE) {
                    // remove 1 character
                    oldValue = oldValue.substring(0, oldValue.length() - 1);
                }

                // delete the last key typed
                keyTyped = null;

                // match item
                newValue = findItemUnsorted(oldValue);
/*
                if (newValue == null && !allowNewValues) {
                    // Nothing matched
                    Toolkit.getDefaultToolkit().beep();
                    selectPreviousValue();
                } else {
 */
                    // set the new text and selection     
                    if (newValue == null) {
                        newValue = oldValue;
                    }
                    editor.setText(newValue);
                    editor.setSelectionEnd(newValue.length());
                    editor.setSelectionStart(oldValue.length());

                    if (newValue.length() == 0) {
                        comboBox.setSelectedIndex(-1);
                    }
/*
            	}
*/
            }
        }

        private void selectPreviousValue() {
            String oldValue = editor.getText();
            // This is the value before they typed the last character
            oldValue = oldValue.substring(0, oldValue.length() - 1);
            // Find what it matched
            editor.setText(findItemUnsorted(oldValue));
            // Select from where they're typing to the end of the text
            editor.setSelectionStart(oldValue.length());
            editor.setSelectionEnd(editor.getText().length());
        }

        private String findItemUnsorted(String text) {
            String newText = null;
            String temp = null;
            String upperText = text.toUpperCase();

            if (text.length() == 0) {
                return text;
            }
            
            //Update the List accordingly
            Collection list = new ArrayList();
    		Connection con = null;
    		PreparedStatement pstmt = null;
    		ResultSet rs = null;
    		
    		int mod = text.length()%2;
    		if(mod == 0){
        		try{
        			//con = DBUtil.getDBConnection("EDW");
        			con = DBUtil.getOrcaleServerConnection();
        			
        			//Check for Ledger Type
        			pstmt = con.prepareStatement("SELECT VENDOR_NAME FROM VW_CMIS_VENDOR_DETAILS WHERE VENDOR_NAME LIKE ?");
        			pstmt.setString(1, text.toUpperCase()+"%");
        			rs = pstmt.executeQuery();
        			
        			while(rs.next()){
        				list.add(rs.getString(1));
        			}
        		}catch(Exception e){
        			e.printStackTrace();
        		} finally {
        			try {
//        				DBUtil.closeDBConnection(con);
        				DBUtil.closeConnection(con);
        			} catch (Exception e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			}
        		}
                
                comboBox.setModel(new DefaultComboBoxModel(new Vector(list)));

                for (int i = 0; i < comboBox.getItemCount(); i++) {
                    
                    if (stringifier == null) {
                        temp = comboBox.getItemAt(i).toString();
                    } else {
                        temp = stringifier.stringify(comboBox.getItemAt(i));
                    }
                    
                    if (temp.toUpperCase().startsWith(upperText)) {
                        newText = temp;
                        setSelectedItem(comboBox.getItemAt(i));
                        break;
                    }
                }
    		}

            return newText;
        }
    }

    /**
     * @return Returns the isSorted.
     */
    public boolean isSorted() {
        return isSorted;
    }


    /**
     * @param isSorted The isSorted to set.
     */
    public void setSorted(boolean isSorted) {
        this.isSorted = isSorted;
    }

    public void setAllowNewValues(boolean b) {
        allowNewValues = b;
    }

    public boolean getAllowNewValues() {
        return allowNewValues;
    }

    public void setSelectedItem(Object anObject) {
        editor.setItem(anObject);
        super.setSelectedItem(anObject);
    }
}
