package me.shini9000.utils;

import javax.swing.*;
import java.awt.*;

public class GradientGlowLabel extends JLabel {

    private Color glowColor;
    private int glowSize;
    private Color gradientStart;
    private Color gradientEnd;

    public GradientGlowLabel(String text, Color gradientStart, Color gradientEnd, Color glowColor, int glowSize) {
        super(text);
        this.gradientStart = gradientStart;
        this.gradientEnd = gradientEnd;
        this.glowColor = glowColor;
        this.glowSize = glowSize;

        setFont(new Font("Serif", Font.BOLD, 48));
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        FontMetrics fm = g2.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(getText())) / 2;
        int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();

        // --- 1. Draw glow behind text ---
        g2.setColor(glowColor);
        for (int i = 1; i <= glowSize; i++) {
            g2.drawString(getText(), x - i, y);
            g2.drawString(getText(), x + i, y);
            g2.drawString(getText(), x, y - i);
            g2.drawString(getText(), x, y + i);
        }

        // --- 2. Draw gradient text on top ---
        GradientPaint gradient = new GradientPaint(
                0, 0, gradientStart,
                getWidth(), getHeight(), gradientEnd
        );

        g2.setPaint(gradient);
        g2.drawString(getText(), x, y);

        g2.dispose();
    }
}