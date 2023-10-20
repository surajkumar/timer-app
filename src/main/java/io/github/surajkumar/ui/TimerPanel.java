package io.github.surajkumar.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TimerPanel extends JPanel {
    private final int fontSize;
    private final Color textColor;
    private String time;

    public TimerPanel(int fontSize, Color textColor) {
        this.fontSize = fontSize;
        this.textColor = textColor;
        this.time = "";
        this.setOpaque(false);
        setDoubleBuffered(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(textColor);
        g2.setFont(new Font("Arial", Font.BOLD, fontSize));
        g2.drawString(time, 0, fontSize);
        g2.dispose();
    }

    public void setTime(String time) {
        this.time = time;
    }
}
