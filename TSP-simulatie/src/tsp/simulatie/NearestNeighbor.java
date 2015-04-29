/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp.simulatie;

import java.util.ArrayList;

/**
 *
 * @author Jurrian
 */
public class NearestNeighbor extends MyMath {

    private ArrayList<Vak> alleVakken = new ArrayList<Vak>();
    private ArrayList<Vak> lijst = new ArrayList<>();

    public ArrayList<Vak> getroute(Vak a) {

        for (int i = 0; i < alleVakken.size(); i++) {
            for (Vak check : alleVakken) {

                if (check.getIsGeselecteerd()) {
                    lijst.add(alleVakken.get(i));
                }
            }
        }
        System.out.println(lijst);
        return lijst;
    }

}
