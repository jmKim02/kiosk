package org.example.ui.theme;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class TwoPanel extends JPanel {
    private Color fore = new Color(200, 200, 200);
    private Color back = new Color(150, 140, 130);

    public TwoPanel() {
        setBackground(fore);
        setForeground(back);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(back);
                setForeground(fore);
                revalidate();
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(fore);
                setForeground(back);
                revalidate();
                repaint();
            }
        });
    }
}