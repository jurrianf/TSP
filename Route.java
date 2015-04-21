/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kbs;

import java.util.ArrayList;

/**
 *
 * @author Jurrian
 */
public class Route {

    private ArrayList<Vakken> volgorde = new ArrayList<>();

    private int afstand;

    public int berekenAfstand(ArrayList<Vakken> volgorde) {
        int berekening = 0;
        berekening = berekening + Vakken.getGroote();
        afstand = berekening;
        return afstand;
    }

}
