/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tsp.simulatie;

import java.awt.Color;
import java.awt.Dimension;
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

     public Grid(int rows, int cols, int cellWidth, int Lineborder) {
        myLabels = new JLabel[rows][cols];

        MouseListener myListener = new MouseListener(this);
        Dimension labelPrefSize = new Dimension(cellWidth, cellWidth);
        setLayout(new GridLayout(rows, cols, Lineborder, Lineborder));
        setBackground(Color.BLACK);
        
        generateVakken(rows);
        
        for (int row = 0; row < myLabels.length; row++) {
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
        }
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
