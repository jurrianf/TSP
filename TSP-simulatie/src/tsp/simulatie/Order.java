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
public class Order {

    private ArrayList<Vak> vakken = new ArrayList<>();

    public ArrayList<Vak> getVakken() {
        return vakken;
    }

    public void addVak(Vak vak) {
        vakken.add(vak);
    }
}
