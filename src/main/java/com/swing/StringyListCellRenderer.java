package com.swing;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class StringyListCellRenderer extends DefaultListCellRenderer {
    private Stringifier stringifyer;

    public StringyListCellRenderer(Stringifier stringifyer) {
        this.stringifyer = stringifyer;
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)  {
        return super.getListCellRendererComponent(list, stringifyer.stringify(value), index, isSelected, cellHasFocus);
    }
}
