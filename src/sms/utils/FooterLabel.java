/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sms.utils;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Ainzle
 */
public class FooterLabel extends JLabel {

    public FooterLabel(String text, Font font, int x, int y, int width, int height) {
        super(text);
        setFont(font);
        setForeground(Color.GRAY);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(x, y, width, height);
    }
} 

