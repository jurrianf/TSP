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
public class Route {//deze class houd een arraylist 
    
    private ArrayList<Vak> volgorde;

    private int afstand;

    public Route(ArrayList<Vak> volgorde,int afstand) {
        this.volgorde = volgorde;
        this.afstand = afstand;
    }

    public ArrayList<Vak> getVolgorde() {
        return volgorde;
    }

    public int getAfstand() {
        return afstand;
    }
}
