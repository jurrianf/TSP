/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tsp.simulatie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFrame;
import org.xml.sax.SAXException;

/**
 *
 * @author Johan
 */
public class TSPSimulatie {// de class met de main, initialiseert het scherm

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException,SAXException{
        // TODO code application logic here
        
        
        TspScherm scherm = new TspScherm();
        scherm.setVisible(true);
        scherm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        
    }
    
}
