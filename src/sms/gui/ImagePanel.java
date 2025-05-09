/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sms.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Ainzle
 */
public class ImagePanel extends JPanel implements MouseListener, MouseMotionListener {

    private Image originalImage;
    private Image hoverImage;
    private Image currentImage;
    private Image iconImage;
    private String text;
    private Font font;
    private boolean insideImageBounds;
    private TextBoxPanel textBoxPanel;
    private ActionListener actionListener;

    public ImagePanel(String imagePath, String hoverImagePath, String iconImagePath, String text, Font font, TextBoxPanel textBoxPanel, ActionListener actionListener) {
        this.originalImage = new ImageIcon(getClass().getResource(imagePath)).getImage();
        this.hoverImage = new ImageIcon(getClass().getResource(hoverImagePath)).getImage();
        this.currentImage = originalImage;
        this.iconImage = new ImageIcon(getClass().getResource(iconImagePath)).getImage();
        this.text = text;
        this.font = font;
        this.textBoxPanel = textBoxPanel;
        this.actionListener = actionListener;
        addMouseListener(this);
        addMouseMotionListener(this);

        this.setPreferredSize(new Dimension(450, 350));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int locationX_icon = 265;
        int locationY_icon = 200;
        int locationX_text = 125;
        int locationY_text = 165;

        g.drawImage(currentImage, 0, 0, 450, 400, this);
        g.drawImage(iconImage, locationX_icon, locationY_icon, 60, 60, this);
        g.setFont(font);
        g.drawString(text, locationX_text, locationY_text);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        boolean isInside = mouseX >= 50 && mouseX <= 380 && mouseY >= 100 && mouseY <= 320;

        if (isInside && actionListener != null) {
            actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        insideImageBounds = true;
        currentImage = hoverImage;
        textBoxPanel.updateText("You want to use the " + text + " function?");
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        insideImageBounds = false;
        currentImage = originalImage;
        textBoxPanel.updateText("Hello there! What are you planning to do today?");
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        boolean isInside = mouseX >= 50 && mouseX <= 380 && mouseY >= 100 && mouseY <= 320;
        if (isInside && !insideImageBounds) {
            mouseEntered(e);
        } else if (!isInside && insideImageBounds) {
            mouseExited(e);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

}