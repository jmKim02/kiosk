package org.example.ui.dialog;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JLabel;

public class NoticeDialog implements ActionListener {
    private static final String[] USER_NOTICES = {
            "OCTOBER HALLOWEEN SALE! 5% Discount on Desserts!",
            "NOVEMBER 11.11 SALE! 11% Discount on Tiramisu!",
            "BLACK FRIDAY SALE! 10% Discount on Beverages!",
            "NEW YEAR SALE! 3% Discount on Sandwiches!",
            "SUMMER HOLIDAY SALES WEEK! 7% Discount on Ice Coffees",
            "Thank you for visiting Twosome Place! Come Again!",
            "Special offers! Enjoy 20% off - all desserts with any coffee!",
            "10th Anniversary Day! Free coffee refills today!",
            "Flash Sale! All sandwiches are 5% off during Early Morning!"
    };

    private JLabel label;
    private Color crimson = new Color(140, 0, 0);
    private Color black  = new Color(0, 0, 0);
    private int count;

    public NoticeDialog(JLabel label){
        this.label = label;
    }

    public static String getRandomNotice() {
        Random random = new Random();
        int index = random.nextInt(USER_NOTICES.length);
        return USER_NOTICES[index];
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(count % 2 == 0)
            label.setForeground(crimson);
        else
            label.setForeground(black);
        count++;
    }
}