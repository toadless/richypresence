package net.toadless.richypresence.util;

import net.toadless.richypresence.Main;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class IconUtils
{
    public static void setTaskbarIcon()
    {
        if (Objects.equals(System.getProperty("os.name"), "Mac OS X"))
        {
            //
            // setting the icon for macos
            //
            final Taskbar taskbar = Taskbar.getTaskbar();
            final ImageIcon icon = new ImageIcon(Main.class.getResource("/logo.png"));

            try
            {
                taskbar.setIconImage(icon.getImage());
            } catch (final UnsupportedOperationException e)
            {
                System.out.println("The os does not support: 'taskbar.setIconImage'");
            } catch (final SecurityException e)
            {
                System.out.println("There was a security exception for: 'taskbar.setIconImage'");
            }
        }
    }
}
