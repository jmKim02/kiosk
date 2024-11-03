package org.example.ui;

import javax.swing.*;
import java.awt.*;
import org.example.ui.theme.TwoButton;
import org.example.ui.dialog.NoticeDialog;

public class MainPanel {
    private JPanel mainPanel;
    private Timer timerNoticePanel;

    public MainPanel(KioskManager kioskManager) {
        mainPanel = new JPanel(new BorderLayout());

        JPanel noticePanel = new JPanel();
        String randomString = NoticeDialog.getRandomNotice();
        JLabel noticeLabel = new JLabel(randomString);
        noticeLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        noticePanel.add(noticeLabel);
        timerNoticePanel = new Timer(100, new NoticeDialog(noticeLabel));
        timerNoticePanel.start();
        mainPanel.add(noticePanel, BorderLayout.NORTH);

        JLabel imageLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("twosome.gif")));
        mainPanel.add(imageLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        TwoButton eatInButton = new TwoButton("Eat Here");
        TwoButton takeOutButton = new TwoButton("To Go");

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