package com.swing;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EditComboBox {
  public static void main(String args[]) {
    String labels[] = { "AB", "acB", "adeC", "D","E", "F", "G", "H","I", "J" };
    JFrame frame = new JFrame("Editable JComboBox");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contentPane = frame.getContentPane();

    final TypeAheadDynamicComboBox comboBox = new TypeAheadDynamicComboBox();
    //nameField.addActionListener(this);

    //final JComboBox comboBox = new JComboBox(labels);
    comboBox.setMaximumRowCount(5);
    comboBox.setEditable(true);
    contentPane.add(comboBox, BorderLayout.NORTH);

    Collection l = new ArrayList();
    l.add("HNTB Corporation");
    l.add("PBS&J, Inc.");
    comboBox.setModel(new DefaultComboBoxModel(new Vector()));
    
    
    final JTextArea textArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(textArea);
    contentPane.add(scrollPane, BorderLayout.CENTER);

    ActionListener actionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        textArea.append("Selected: " + comboBox.getSelectedItem());
        textArea.append(", Position: " + comboBox.getSelectedIndex());
        textArea.append(System.getProperty("line.separator"));
      }
    };
    comboBox.addActionListener(actionListener);

    frame.setSize(300, 200);
    frame.setVisible(true);
  }

}

