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
public class ToadPanel extends JPanel {

    private Image toadImage;

    public ToadPanel(String toadImagePath) {
        this.toadImage = new ImageIcon(getClass().getResource(toadImagePath)).getImage();
        this.setPreferredSize(new Dimension(280, 220));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(toadImage, 0, 0, getWidth(), getHeight(), this);
    }
}
