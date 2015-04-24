/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

    private static void createAndShowGui() {
        int rows = 20;
        int cols = 40;
        int cellWidth = 20;
        int Lineborder = 3;

        ColorGrid mainPanel = new ColorGrid(rows, cols, cellWidth, Lineborder);

        JFrame frame = new JFrame("Color Grid Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}
