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
    private ArrayList<Vak> route = new ArrayList<>();

    public ArrayList<Vak> setlijst(Vak a) {

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

    public ArrayList<Vak> getlijst(Vak a) {
        return lijst;
    }

    public ArrayList<Vak> setroute() {
        int x = 0;
        int y = 0;
        while (lijst.size() >= 1) {
            for (int i = 0; i < lijst.size(); i++) {
                //delta berekening
                /*int afstand = 0;
                 if ((afstand > delta)  {
                 OR(afstand == 0)
                 }

                 )
                 {
                 afstand = delta;
                 return delta;
                 }
                 route.add(lijst.get(i));
                 lijst.remove(i);*/
            }
        }
        return route;
    }
}
