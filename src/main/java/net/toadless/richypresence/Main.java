package net.toadless.richypresence;

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            RichyPresence richyPresence = new RichyPresence();
            richyPresence.setVisible(true);
        } catch (UnsupportedLookAndFeelException exception)
        {
            System.exit(-1);
        } catch (ClassNotFoundException exception)
        {
            System.exit(-1);
        } catch (InstantiationException exception)
        {
            System.exit(-1);
        } catch (IllegalAccessException exception)
        {
            System.exit(-1);
        }
    }
}
