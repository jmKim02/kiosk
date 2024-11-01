package org.example.ui;

import javax.swing.*;
import java.awt.*;

public class MainPanel {
    private JPanel mainPanel;

    public MainPanel(KioskManager kioskManager) {
        mainPanel = new JPanel(new BorderLayout());

        JLabel imageLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("twosome.gif")));
        mainPanel.add(imageLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton eatInButton = new JButton("Eat here");
        JButton takeOutButton = new JButton("To go");

        eatInButton.addActionListener(e -> kioskManager.showMenuPanel());
        takeOutButton.addActionListener(e -> kioskManager.showMenuPanel());

        buttonPanel.add(eatInButton);
        buttonPanel.add(takeOutButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return mainPanel;
    }
}
