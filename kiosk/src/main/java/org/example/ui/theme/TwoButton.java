package org.example.ui.theme;

import java.awt.BasicStroke;
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
import javax.swing.JButton;

public class TwoButton extends JButton {
    private Color back = new Color(0, 0, 0);
    private Color fore = new Color(220, 220, 220);
    private int paddingWidth = 2, paddingHeight = 1;

    public TwoButton(String text) {
        setText(text);

        Dimension dimension = getPreferredSize();
        int width = (int) dimension.getWidth() + paddingWidth * 2;
        int height = (int) dimension.getHeight() + paddingHeight * 2;
        setPreferredSize(new Dimension(width, height));

        setOpaque(false);
        setBorder(null);
        setBackground(null);
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
                setBackground(null);
                setForeground(back);
                revalidate();
                repaint();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graph = (Graphics2D) g;
        graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Dimension dimension = getPreferredSize();
        int width = (int) dimension.getWidth() - 1;
        int height = (int) dimension.getHeight() - 1;

        if(getBackground() != null) {
            graph.setColor(getBackground());
            graph.fillRoundRect(1, 1, (int) (width - 1 / 3.5), (int) (height - 1 / 2.8), 15, 15);
        }

        graph.setColor(getForeground());
        graph.setStroke(new BasicStroke(1));
        graph.drawRoundRect(0, 0, width, height, 15, 15);

        graph.setColor(getForeground());
        graph.setFont(new Font("Times New Roman", 3, 18));

        FontMetrics fontMetrics = graph.getFontMetrics();
        Rectangle rectangle = fontMetrics.getStringBounds(getText(), graph).getBounds();

        graph.drawString(getText(), (width - rectangle.width) / 2, (height - rectangle.height) / 2 + fontMetrics.getAscent());
    }
}