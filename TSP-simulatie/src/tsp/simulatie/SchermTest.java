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

    private Order order;
    private Grid mainPanel;

    public Grid getMainPanel() {
        return mainPanel;
    }
    
    
    
    public SchermTest() {

        int rows = 50;
        int cols = 25;
        int cellWidth = 0;
        int Lineborder = 1;

        mainPanel = new Grid(rows, cols, cellWidth, Lineborder);

        JFrame frame = new JFrame("Color Grid Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setSize(836, 696);
        
        MouseListener myListener = new MouseListener(this, mainPanel);
        frame.addMouseListener(myListener);
        
        
        
        

        //MouseListener myListener = new MouseListener();
        //addMouseListener(myListener);
    }
     
    Algoritme greedy;
    
    public void makeOrder(Grid grid){
        order = new Order();
        Vak[][] vakken;
        
        vakken = grid.getAlleVakken();
        
        for (int row = 0; row < vakken.length; row++) {
            for (int col = 0; col < vakken[row].length; col++) {
                if(vakken[row][col].getIsGeselecteerd())
                {
                    order.addVak(vakken[row][col]);
                }
            }
        }
        
        //greedy = new GreedyHeuristic(order, rows);
    }
}
    
    

