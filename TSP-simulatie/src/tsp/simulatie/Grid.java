/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tsp.simulatie;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FontMetrics;

/**
 *
 * @author Johan
 */
public class Grid extends JPanel{
    private JLabel[][] myLabels;
    private Color myColor;
    private int size;
    private Vak[][] alleVakken;
    ArrayList<Vak> vakken;
    int vakSize;
    boolean lijntjes = false;
    @Override
    public void paintComponent(Graphics g)
    {
        int pointX = 0;
        int pointY = 0;
	// teken de achtergrond
	super.paintComponent(g);
        // maak de achtergrond wit
	setBackground(Color.WHITE);
        Font font =new Font("Consolas", Font.PLAIN, 11);
        g.setFont(font);
        
	// tekenen.. 
        g.setColor(Color.black);
        for (int row = 0; row < alleVakken.length; row++) {
            for (int col = 0; col < alleVakken[row].length; col++)
                {
                    if(alleVakken[row][col].getIsGeselecteerd())
                    {
                        g.setColor(Color.green);
                    }else
                    {
                        g.setColor(Color.blue);
                    }
                   //System.out.println("x: " + pointX);
                   // alleVakken[row][col]
                    g.fillRect(pointX, pointY, pointX + vakSize, pointY + vakSize);
                    g.setColor(Color.black);
                    g.drawRect(pointX, pointY, pointX + vakSize, pointY + vakSize);
                    
                     
                    g.setColor(Color.white);
                    g.drawString(alleVakken[row][col].getLocatie(), pointX+1, pointY+vakSize-1); 
                    pointX += vakSize;
                    
                    //System.out.println("x1: " + pointX + " |y1: " + pointY + " |x2: " + (pointX + 720/alleVakken.length) + " |y2: " + (pointY + 720/alleVakken.length) + " |size: " + 720/alleVakken.length);
                }
           // System.out.println("y " + pointY);
            pointY += vakSize;
            pointX = 0;
        }
        
        if(lijntjes)
        {
            Vak[] lijnCords = new Vak[vakken.size()];
            g.setColor(Color.red);
            int i = 0;
            for(Vak v : vakken)
            {
                lijnCords[i] = v;
                i++;
            }
            
            for(int j = 1; j < lijnCords.length; j++)
            {
                if(j == 1)
                {
                   g.drawLine(0, 720, lijnCords[j-1].getX()*(vakSize)+(vakSize/2), lijnCords[j-1].getY()*(vakSize)+(vakSize/2));
                }
                
                g.drawLine(lijnCords[j-1].getX()*(vakSize)+(vakSize/2), lijnCords[j-1].getY()*(vakSize)+(vakSize/2), lijnCords[j].getX()*(vakSize)+(vakSize/2), lijnCords[j].getY()*(vakSize)+(vakSize/2));
            }
            
        }
    }
    
    public void drawLijnjes(ArrayList<Vak> vakken)
    {
        this.vakken = vakken;
        lijntjes = true;
        repaint();
    }
    
     public Grid(int rows, int cols, int cellWidth, int Lineborder) {
        //myLabels = new JLabel[rows][cols];
        
        MouseListener myListener = new MouseListener(this);
        Dimension labelPrefSize = new Dimension(cellWidth, cellWidth);
        //setLayout(new GridLayout(rows, cols, Lineborder, Lineborder));
        setBackground(Color.BLACK);
        
        generateVakken(rows);
        vakSize = 720/alleVakken.length;
        this.addMouseListener(myListener);
        /*for (int row = 0; row < myLabels.length; row++) {
            for (int col = 0; col < myLabels[row].length; col++) {
                JLabel myLabel = new JLabel();
                myLabel = new JLabel();
                myLabel.setOpaque(true);
                myColor = Color.BLUE;
                myLabel.setBackground(myColor);
                myLabel.
                myLabel.setPreferredSize(labelPrefSize);
                add(myLabel);
                myLabels[row][col] = myLabel;
            }
        }*/
    }
    
    private void generateVakken(int s)
    {
        alleVakken = new Vak[s][s];
        for (int row = 0; row < alleVakken.length; row++) {
            for (int col = 0; col < alleVakken[row].length; col++)
                {
                    Vak myVak = new Vak(col, row);
                    alleVakken[row][col] = myVak;
                }
        }
    }


    public void labelPressed(Vak v) {
        for (int row = 0; row < alleVakken.length; row++) {
            for (int col = 0; col < alleVakken[row].length; col++) {
                if (v == alleVakken[row][col]) {
                    
                    
                    alleVakken[row][col].isGeselecteerd();
                    System.out.println(alleVakken[row][col].toString());
                }
            }
        }
    }
    
    public void berekenVak(int x, int y)
    {
       if(x%vakSize != 0)
       {
           x -= x%vakSize;
       }
       if(y%vakSize != 0)
       {
           y -= y%vakSize;
       }
       
       int row = y/vakSize;
       int col = x/vakSize;
       
       Vak vk = alleVakken[row][col];
       
       labelPressed(vk);
       
       repaint();
       
    }
    
    public Vak[][] getAlleVakken() {
        return alleVakken;
    }
    
    
}
