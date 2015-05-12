/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tsp.simulatie;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Johan
 */
public class Grid extends JPanel{
    private JLabel[][] myLabels;
    private Color myColor;
    private int size;
    private Vak[][] alleVakken;

    @Override
    public void paintComponent(Graphics g)
    {
        int pointX = 0;
        int pointY = 0;
	// teken de achtergrond
	super.paintComponent(g);
        // maak de achtergrond wit
	setBackground(Color.WHITE);
	// tekenen.. 
        g.setColor(Color.black);
        for (int row = 0; row < alleVakken.length; row++) {
            for (int col = 0; col < alleVakken[row].length; col++)
                {
                    if(col%2 == 0 && row%2 == 1)
                    {
                        g.setColor(Color.black);
                    }else if(col%2 == 1 && row%2 == 0)
                    {
                        g.setColor(Color.black);
                    }else
                    {
                        g.setColor(Color.cyan);
                    }
                    //System.out.println("x: " + pointX);
                   // alleVakken[row][col]
                    g.fillRect(pointX, pointY, pointX + 720/alleVakken.length-1, pointY + 720/alleVakken.length-1);
                    pointX += 720/alleVakken.length;
                    
                    //System.out.println("x1: " + pointX + " |y1: " + pointY + " |x2: " + (pointX + 720/alleVakken.length) + " |y2: " + (pointY + 720/alleVakken.length) + " |size: " + 720/alleVakken.length);
                }
           // System.out.println("y " + pointY);
            pointY += 720/alleVakken.length;
            pointX = 0;
        }
    }
    
     public Grid(int rows, int cols, int cellWidth, int Lineborder) {
        //myLabels = new JLabel[rows][cols];

        MouseListener myListener = new MouseListener(this);
        Dimension labelPrefSize = new Dimension(cellWidth, cellWidth);
        //setLayout(new GridLayout(rows, cols, Lineborder, Lineborder));
        setBackground(Color.BLACK);
        
        generateVakken(rows);
        
        /*for (int row = 0; row < myLabels.length; row++) {
            for (int col = 0; col < myLabels[row].length; col++) {
                JLabel myLabel = new JLabel();
                myLabel = new JLabel();
                myLabel.setOpaque(true);
                myColor = Color.BLUE;
                myLabel.setBackground(myColor);
                myLabel.addMouseListener(myListener);
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


    public void labelPressed(JLabel label) {
        boolean bool;
        for (int row = 0; row < myLabels.length; row++) {
            for (int col = 0; col < myLabels[row].length; col++) {
                if (label == myLabels[row][col]) {
                    bool = alleVakken[row][col].getIsGeselecteerd();
                    label.setText(alleVakken[row][col].getLocatie().toString());
                    if(!bool)
                    {
                        myColor = Color.GREEN;
                    }else if(bool)
                    {
                        myColor = Color.BLUE;
                    }
                    alleVakken[row][col].isGeselecteerd();
                    myLabels[row][col].setBackground(myColor);
                    System.out.println(alleVakken[row][col].toString());
                }
            }
        }
    }
    
    public Vak[][] getAlleVakken() {
        return alleVakken;
    }
    
    
}
