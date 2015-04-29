/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tsp.simulatie;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Johan
 */
public class SchermTest extends JFrame{

    public SchermTest() {

        int rows = 20;
        int cols = 20;
        int cellWidth = 20;
        int Lineborder = 1;

        Grid mainPanel = new Grid(rows, cols, cellWidth, Lineborder);

        JFrame frame = new JFrame("Color Grid Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        
        
        
        

        //MouseListener myListener = new MouseListener();
        //addMouseListener(myListener);
    }
     
    private void makeOrder(Grid grid){
        Order order = new Order();
        Vak[][] vakken;
        
        vakken = grid.getAlleVakken();
        
        for (int row = 0; row < vakken.length; row++) {
            for (int col = 0; col < vakken[row].length; col++) {
                order.addVak(vakken[row][col]);
            }
        }
    }
}
    
    

