package com.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

/**
 * Provides lighweight keyboard navigation for JComboBox. In the default behavior
 * of JComboBox, as the user presses the up and down keys inside the drop-down,
 * ActionEvents are fired. This is undesirable behavior, especially if selecting 
 * items causes time-intensive processing. This fix stops ActionEvents from firing
 * unless the user selects an item and closes the drop-down.
 * 
 * <p>Please refer to <a href="http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4199622">Bug ID: 4199622</a>.</p>
 *
 * @author <a href="mailto:jessie@rowansoftware.net">Jessie Crowe</a>
 */
public class BetterComboBox extends JComboBox {

    public BetterComboBox(ComboBoxModel aModel) {
        super(aModel);
        setup();
    }

    public BetterComboBox(Object[] items) {
        super(items);
        setup();
    }

    public BetterComboBox(Vector items) {
        super(items);
        setup();
    }

    public BetterComboBox() {
        super();
        setup();
    }
    
    private void setup() {
        // tricks the combo into thinking it is in a JTable
        // behavior is correct when combo is in the table
        putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        // as a side effect, the drop-down won't close - this handles it
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hidePopup();
            }
        });
    }
}
