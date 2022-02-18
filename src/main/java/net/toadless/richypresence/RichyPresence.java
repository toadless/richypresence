package net.toadless.richypresence;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import net.toadless.richypresence.listeners.InitializeButtonListener;
import net.toadless.richypresence.listeners.UpdateButtonListener;
import net.toadless.richypresence.listeners.FocusListener;
import net.toadless.richypresence.util.IconUtils;

import javax.swing.*;
import java.awt.*;

public class RichyPresence extends JFrame
{
    private JPanel mainPanel;

    private int height = 65;
    private int width = 550;

    private JTextField stateTextField;
    private JTextField clientIdTextField;
    private JTextField largeImageKeyTextField;
    private JTextField smallImageKeyTextField;
    private JTextField detailsTextField;

    private Spacer spacer1;
    private Spacer spacer2;
    private Spacer spacer3;

    private JButton updateButton;
    private JButton initButton;

    private boolean initialized;

    private final RichPresence richPresence;

    private ImageIcon icon = new ImageIcon(RichyPresence.class.getResource("/logo.png"));

    public RichyPresence() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        super("RichyPresence");

        IconUtils.setTaskbarIcon();
        this.setIconImage(icon.getImage());

        this.mainPanel = new JPanel();
        this.mainPanel.setPreferredSize(new Dimension(width, height));
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        setupUI();

        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        this.richPresence = new RichPresence(this);
    }

    //
    // Layout generate by intellij
    //
    public void setupUI()
    {
        this.spacer1 = new Spacer();
        this.spacer2 = new Spacer();
        this.spacer3 = new Spacer();

        updateButton = new JButton();
        initButton = new JButton();

        stateTextField = new JTextField(Layout.STATE.getPlaceholder());
        clientIdTextField = new JTextField(Layout.CLIENT_ID.getPlaceholder());
        largeImageKeyTextField = new JTextField(Layout.LARGE_IMAGE_KEY.getPlaceholder());
        smallImageKeyTextField = new JTextField(Layout.SMALL_IMAGE_KEY.getPlaceholder());
        detailsTextField = new JTextField(Layout.DETAILS.getPlaceholder());

        updateButton.setText("Update");
        initButton.setText("Initialize");

        initButton.addActionListener(new InitializeButtonListener(initButton, this));
        updateButton.addActionListener(new UpdateButtonListener(updateButton, this));

        detailsTextField.addFocusListener(new FocusListener(detailsTextField, Layout.DETAILS.getPlaceholder()));
        smallImageKeyTextField.addFocusListener(new FocusListener(smallImageKeyTextField, Layout.SMALL_IMAGE_KEY.getPlaceholder()));
        largeImageKeyTextField.addFocusListener(new FocusListener(largeImageKeyTextField, Layout.LARGE_IMAGE_KEY.getPlaceholder()));
        clientIdTextField.addFocusListener(new FocusListener(clientIdTextField, Layout.CLIENT_ID.getPlaceholder()));
        stateTextField.addFocusListener(new FocusListener(stateTextField, Layout.STATE.getPlaceholder()));

        detailsTextField.setForeground(Color.GRAY);
        smallImageKeyTextField.setForeground(Color.GRAY);
        largeImageKeyTextField.setForeground(Color.GRAY);
        clientIdTextField.setForeground(Color.GRAY);
        stateTextField.setForeground(Color.GRAY);

        mainPanel.setLayout(new GridLayoutManager(3, 6, new Insets(0, 0, 0, 0), -1, -1));

        mainPanel.add(detailsTextField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        mainPanel.add(largeImageKeyTextField, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        mainPanel.add(clientIdTextField, new GridConstraints(0, 2, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        mainPanel.add(smallImageKeyTextField, new GridConstraints(1, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        mainPanel.add(stateTextField, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));

        mainPanel.add(initButton, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        mainPanel.add(updateButton, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        mainPanel.add(spacer1, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        mainPanel.add(spacer2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        mainPanel.add(spacer3, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
    }

    //
    // Getters
    //

    public boolean isInitialized()
    {
        return initialized;
    }

    public JTextField getStateTextField()
    {
        return stateTextField;
    }

    public JTextField getClientIdTextField()
    {
        return clientIdTextField;
    }

    public JTextField getLargeImageKeyTextField()
    {
        return largeImageKeyTextField;
    }

    public JTextField getSmallImageKeyTextField()
    {
        return smallImageKeyTextField;
    }

    public JTextField getDetailsTextField()
    {
        return detailsTextField;
    }

    public RichPresence getRichPresence()
    {
        return richPresence;
    }

    //
    // Setters
    //

    public void setInitialized(boolean initialized)
    {
        this.initialized = initialized;
    }
}