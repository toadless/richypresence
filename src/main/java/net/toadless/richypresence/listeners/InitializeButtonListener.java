package net.toadless.richypresence.listeners;

import net.toadless.richypresence.RichyPresence;
import net.toadless.richypresence.util.ListenerUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitializeButtonListener implements ActionListener
{
    private final JButton button;
    private final RichyPresence richyPresence;

    public InitializeButtonListener(JButton button, RichyPresence richyPresence)
    {
        this.richyPresence = richyPresence;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (richyPresence.isInitialized())
        {
            ListenerUtils.showPopup("Cannot reinitialize the rich presence.");
            return;
        }

        richyPresence.getRichPresence().initialize();
    }
}
