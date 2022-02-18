package net.toadless.richypresence.util;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ListenerUtils
{
    public static void showPopup(String message)
    {
        Image image = new BufferedImage(
                1, 1, BufferedImage.TYPE_INT_ARGB);

        JOptionPane.showMessageDialog(
                null,
                message,
                "RichyPresence",
                JOptionPane.OK_OPTION,
                new ImageIcon(image)
        );
    }
}
