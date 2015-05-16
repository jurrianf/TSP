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
    TspScherm scherm;
    boolean schermBool = false;
    
    public MouseListener(Grid grid) {
        this.grid = grid;
    }
    
    public MouseListener(TspScherm scherm) {
        this.scherm = scherm;
        schermBool = true;
        
    }
    
   /* public MouseListener(SchermTest scherm, Grid grid) {
        this.scherm = scherm;
        this.grid = grid;
    }*/
    
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == grid)
        {
            if (e.getButton() == MouseEvent.BUTTON1) {
                int x=e.getX();
                int y=e.getY();
                System.out.println("XY(" + x + ", " + y + ")");
                grid.berekenVak(x, y);
                
            }
        }
        if(schermBool)
        {
            if (e.getButton() == MouseEvent.BUTTON1) {
                scherm.vakje();
                System.out.println("je moeder");
            }
        }
    
        
    }
}
