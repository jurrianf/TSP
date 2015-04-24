/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class MyMouseListener extends MouseAdapter {

    private ColorGrid colorGrid;

    public MyMouseListener(ColorGrid colorGrid) {
        this.colorGrid = colorGrid;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            colorGrid.labelPressed((JLabel) e.getSource());
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            MyColor[][] myColors = colorGrid.getMyColors();
            for (int row = 0; row < myColors.length; row++) {
                for (int col = 0; col < myColors[row].length; col++) {
                    System.out.print(myColors[row][col] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
