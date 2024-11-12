package org.example.ui.theme;

import java.awt.Font;
import javax.swing.JLabel;

public class TwoLabel extends JLabel {
    public TwoLabel(String text) {
        super(text);
        setFont();
    }

    private void setFont() {
        this.setFont(new Font("Times New Roman", Font.BOLD, 15));
    }
}