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
public class MouseListener extends MouseAdapter {

    Grid grid;
    TspScherm scherm;
    boolean schermBool = false;
    String vakje = "geselecteerd: ";

    public String vakje() {
        int rows;
        int cols;
        rows = TspScherm.rows;
        cols = TspScherm.cols;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid.alleVakken[row][col].getIsGeselecteerd()) {
                    vakje += grid.alleVakken[row][col].getLocatie() + ", ";
                }
            }
        }
        return vakje;
    }

    public MouseListener(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getButton() == MouseEvent.BUTTON1) {
            int x = e.getX();
            int y = e.getY();
            grid.berekenVak(x, y);
            vakje = "geselecteerd: ";
            vakje();
            TspScherm.jLabel1.removeAll();
            TspScherm.jLabel1.setText(vakje);

        }
    }
}
