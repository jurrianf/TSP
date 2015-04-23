/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tsp.simulatie;

import javax.swing.JFrame;

/**
 *
 * @author Johan
 */
public class SchermTest extends JFrame{

    public SchermTest() {
        JFrame scherm = new JFrame();
        scherm.setVisible(true);
        scherm.setSize(1280, 720);
        
        scherm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        SelectScherm tekenen = new SelectScherm();
        
        scherm.add(tekenen);
    }
    
    
}
