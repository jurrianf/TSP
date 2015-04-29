/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tsp.simulatie;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 *
 * @author Johan
 */
public class MouseListener extends MouseAdapter{
    
    Grid grid;
    
    public MouseListener(Grid grid) {
        this.grid = grid;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        /*if (e.getButton() == MouseEvent.BUTTON1) {
            int x=e.getX();
            int y=e.getY();
            System.out.println("XY(" + x + ", " + y + ")");
        }*/
        
        if (e.getButton() == MouseEvent.BUTTON1) {
            grid.labelPressed((JLabel) e.getSource());
        }
    }
}
