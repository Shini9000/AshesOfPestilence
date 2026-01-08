package me.shini9000.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GradientLabel extends JLabel {

    private Color start;
    private Color end;

    public GradientLabel(String text, Color start, Color end) {
        super(text);
        this.start = start;
        this.end = end;
        setFont(new Font("Serif", Font.BOLD, 40));
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        int width = getWidth();
        int height = getHeight();

        GradientPaint gradient = new GradientPaint(
                0, 0, start,
                width, height, end
        );

        g2.setPaint(gradient);

        FontMetrics fm = g2.getFontMetrics();
        int x = (width - fm.stringWidth(getText())) / 2;
        int y = ((height - fm.getHeight()) / 2) + fm.getAscent();

        g2.drawString(getText(), x, y);
        g2.dispose();
    }
}