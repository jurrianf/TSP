/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tsp.simulatie;

import java.util.ArrayList;

/**
 *
 * @author Johan
 */
public class Grid {
    static private int size;
    private ArrayList<Vak> alleVakken = new ArrayList<>();

    public Grid(int size) {
        this.size = size;
        generateVakken(size);
        for(Vak v : alleVakken)
        {
            System.out.println(v.toString());
        }
    }
    
    private void generateVakken(int s)
    {
        for(int i = 0; i < (s*s); i++)
        {
            
            Vak vak = new Vak(i);
            alleVakken.add(vak);
        }
    }

    static public int getSize() {
        return size;
    }

    public ArrayList<Vak> getAlleVakken() {
        return alleVakken;
    }
    
    
}
