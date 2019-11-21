/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class Lienzo extends JPanel{
    private BufferedImage imagen;
    
    public Lienzo(){
        settings();
    }
    
    private void settings(){
        imagen = null;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imagen,0,0,this);
    }
    public void setImage(BufferedImage imagen){
        this.imagen = imagen;
        this.setPreferredSize(new Dimension(imagen.getWidth(),imagen.getHeight()));
        repaint();
    }
    
}
