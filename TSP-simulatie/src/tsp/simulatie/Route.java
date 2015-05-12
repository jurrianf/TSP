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
public class Route {
    
    private ArrayList<Vak> volgorde;

    private int afstand;

    public Route(ArrayList<Vak> volgorde) {
        this.volgorde = volgorde;
    }

    public int berekenAfstand(ArrayList<Vak> volgorde) {
        int afstand;
        afstand = volgorde.size() * Vak.getGroote();
        
        return afstand;
    }
}
