package org.example.ui.theme;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class TwoCategoryLabel extends JLabel {
    private Color unClick = new Color(0, 0, 0);
    private Color onClick = new Color(140, 0, 0);
    private Color front = new Color(220, 220, 220);
    private int paddingWidth = 15, paddingHeight = 2;
    private int shadowEffect = 3;

    public TwoCategoryLabel(String text) {
        setText(text);

        Dimension dimension = getPreferredSize();
        int width = (int) dimension.getWidth() + paddingWidth * 3;
        int height = (int) dimension.getHeight() + paddingHeight * 2 + shadowEffect;

        setPreferredSize(new Dimension(width, height));
        setOpaque(false);
        setBorder(null);
        setBackground(unClick);
        setForeground(front);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(onClick);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(unClick);
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graph = (Graphics2D) g;
        graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Dimension dimension = getPreferredSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight() - shadowEffect;

        graph.setColor(onClick);
        graph.fillRoundRect(0, 5, width, height, 15, 15);

        graph.setColor(getBackground());
        graph.fillRoundRect(0, 0, width, height, 15, 15);

        graph.setColor(getForeground());
        graph.setFont(new Font("Times New Roman", 3, 18));

        FontMetrics fontMetrics = graph.getFontMetrics();
        Rectangle rectangle = fontMetrics.getStringBounds(getText(), graph).getBounds();

        graph.drawString(getText(), (width - rectangle.width) / 2, (height - rectangle.height + shadowEffect) / 2 + fontMetrics.getAscent());
    }
}