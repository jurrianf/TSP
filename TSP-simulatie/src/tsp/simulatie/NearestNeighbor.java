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
public class NearestNeighbor extends MyMath implements Algoritme {

    /*   private ArrayList<Vak> alleVakken = new ArrayList<Vak>();
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
     delta berekening
     int afstand = 0;
     if ((afstand > delta)  {
     OR(afstand == 0)
     }

     )
     {
     afstand = delta;
     return delta;
     }
     route.add(lijst.get(i));
     lijst.remove(i);
     }
     }
     return route;
     } */
    Order order;
    Route route;
    Vak routeVakken[][];
    Vak vak;
    ArrayList<Vak> vakken;

    @Override
    public void Algoritme(Order order) {
        this.order = order;
    }

    @Override
    public Order getOrder() {
        return order;
    }

    @Override
    public Route getRoute() {
        return route;
    }

    public NearestNeighbor(Order order) {
        this.order = order;
        berekenRoute(order);
        int demensions = (order.getVakken().size());
        routeVakken = new Vak[demensions][demensions];
    }

    @Override
    public void berekenRoute(Order order) {
        vakken = order.getVakken();
        vak = vakken.get(0);
        while (1 < vakken.size()) {
            calcLoop(0, vakken, vak);
            System.out.println(vak);

        }

    }

    private void calcLoop(int j, ArrayList<Vak> v, Vak curVak) {
        int x;
        int y;
        int curX = curVak.getX();
        int curY = curVak.getY();
        int xy;
        int curXY = curX + curY;
        int delta = 0xFFFFFF;
        int index = 0;

        for (int i = j; i < v.size(); i++) {
            if (i != j) {
                x = v.get(i).getX();
                y = v.get(i).getY();
                xy = x + y;
                int tempDelta = super.delta(xy, curXY);
                if (tempDelta < delta) {
                    delta = tempDelta;
                    vak = v.get(i);
                    index = i;
                    System.out.println(vak.toString() + "   delta: " + delta + " |i = " + i + " ,j = " + j);
                }

                for (int a = 0; a < vakken.size(); a++) {
                    if (vakken.get(a).equals(curVak)) {
                        vakken.remove(vakken.get(a));
                        System.out.println("desu kawaii");
                    }
                }

                //System.out.println("vakken vergeleken: i = " + i + " ,j = " + j);
            }
        }
    }
}
