package net.toadless.richypresence.listeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;

public class FocusListener implements java.awt.event.FocusListener
{
    private final JTextField textField;
    private final String text;

    public FocusListener(JTextField textField, String text)
    {
        this.textField = textField;
        this.text = text;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (textField.getText().equals(text)) {
            textField.setText("");
            textField.setForeground(Color.BLACK);
        }
    }
    @Override
    public void focusLost(FocusEvent e) {
        if (textField.getText().isEmpty()) {
            textField.setForeground(Color.GRAY);
            textField.setText(text);
        }
    }
}
