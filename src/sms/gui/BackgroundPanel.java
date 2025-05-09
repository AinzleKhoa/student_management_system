/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sms.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Ainzle
 */
public class BackgroundPanel extends JPanel {

    private Image backgroundFrame;
    private Image backgroundImage;
    private Image logoImage;

    public BackgroundPanel(String backgroundFramePath, String backgroundImagePath, String logoImagePath) {
        this.backgroundFrame = new ImageIcon(getClass().getResource(backgroundFramePath)).getImage();
        this.backgroundImage = new ImageIcon(getClass().getResource(backgroundImagePath)).getImage();
        this.logoImage = new ImageIcon(getClass().getResource(logoImagePath)).getImage();

        this.setPreferredSize(new Dimension(1600, 950));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        g.drawImage(backgroundFrame, 0, 0, getWidth(), getHeight(), this);
        g.drawImage(logoImage, 1350, 50, 245, 105, this);
    }
}
