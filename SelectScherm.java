/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tsp.simulatie;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Johan
 */
public class SelectScherm extends JPanel 
{
public void paintComponent(Graphics g)
{
	// teken de achtergrond
	super.paintComponent(g);

	// maak de achtergrond wit
	setBackground(Color.WHITE);
	
	// tekenen
        g.setColor(Color.black);
        int vakGroote = Vak.getGroote();
        int size = Grid.getSize();
        int pointX = 0;
        int pointY = 0;
        
        for(int i = 0; i <= (size*size); i++)
        {
            if(i % size != 0)
            {
                pointX += (vakGroote);
            }else
            {
                pointY += vakGroote;
                pointX = 0;
            }
            System.out.println(i + ": x1: " + pointX + " |y1: " + pointY + " |x2: " + (pointX + vakGroote) + " |y2: " + (pointY + vakGroote) + " |size: " + vakGroote);
            g.drawRect(pointX, pointY, (pointX + (vakGroote+5)), (pointY + (vakGroote+5)));
        }
}

    
}
