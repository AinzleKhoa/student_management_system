/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sms.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Ainzle
 */
public class TextBoxPanel extends JPanel {

    private Image textBoxImage;
    private String text;
    private Font font;

    public TextBoxPanel(String textBoxImagePath, String text, Font font) {
        this.textBoxImage = new ImageIcon(getClass().getResource(textBoxImagePath)).getImage();
        this.text = text;
        this.font = font;
        this.setPreferredSize(new Dimension(280, 220));
    }

    public void updateText(String newText) {
        this.text = newText;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(textBoxImage, 0, 0, getWidth(), getHeight(), this);
        g.setFont(font);
        g.drawString(text, 40, 145);
    }
}
