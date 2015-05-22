/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp.simulatie;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Jurrian
 */
public class NearestNeighbor extends MyMath implements Algoritme {

    Order order;
    Route route;
    Vak routeVakken[][];
    Vak vak;
    int rows;
    boolean startArrayI;
    ArrayList<Vak> vakken;
    ArrayList<Vak> volgorder = new ArrayList<>();
    int afstand;

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
        int demensions = (order.getVakken().size());
        routeVakken = new Vak[demensions][demensions];
        berekenRoute(order);

        afstand = berekenAfstand(volgorder);

        volgorder.remove(0);
        
        route = new Route(volgorder, afstand);
    }

    private int berekenAfstand(ArrayList<Vak> volgorder) {//bereken de afstand van de route
        int afstandi = 0;

        for (int i = 1; i < volgorder.size(); i++) {
            afstandi += calcDelta(volgorder.get(i - 1).getX(), volgorder.get(i - 1).getY(), volgorder.get(i).getX(), volgorder.get(i).getY());

            // System.out.println("van vak: " + volgorder[i-1].getLocatie() + "naar vak: " + volgorder[i].getLocatie());
        }
        return afstandi;
    }

    @Override
    public void berekenRoute(Order order) {//begin met het berkenen van de 
        vakken = order.getVakken();
        vak = vakken.get(0);
        while (1 < vakken.size()) {
            calcLoop(0, vakken, vak);
            //System.out.println(vak);

        }

        volgorder.add(vakken.get(0));

    }

    private void calcLoop(int j, ArrayList<Vak> v, Vak curVak) {//in deze loop wordt telkens per vakje geken welke het digste bij zit
        int x;
        int y;
        int curX = curVak.getX();
        int curY = curVak.getY();
        int curXY = curX + curY;
        int delta = 0xFFFFFF;

        for (int i = j; i < v.size(); i++) {
            x = v.get(i).getX();
            y = v.get(i).getY();
            int tempDeltaX = super.delta(x, curX);
            int tempDeltaY = super.delta(y, curY);
            int tempDelta = tempDeltaX + tempDeltaY;
            if (tempDelta < delta) {
                delta = tempDelta;
                vak = v.get(i);
            }

        }
        for (int a = 0; a < vakken.size(); a++) {
            if (vakken.get(a).equals(curVak)) {
                volgorder.add(curVak);
                vakken.remove(vakken.get(a));
            }
        }

    }       //System.out.println("vakken vergeleken: i = " + i + " ,j = " + j);

    private Vak calcBottomLeftMost(Vak vak1, Vak vak2) {//bereken het vakje dat het dichste bij links onder zit
        int delta1 = calcDelta(vak1.getX(), vak1.getY(), 0, rows);
        int delta2 = calcDelta(vak2.getX(), vak2.getY(), 0, rows);
        if (delta1 <= delta2) {
            startArrayI = true;
            return vak1;
        } else {
            startArrayI = false;
            return vak2;
        }
    }

    private int calcDelta(int x1, int y1, int x2, int y2) {//bereken de delta tussen twee vakjes

        int deltaX = super.delta(x1, x2);
        int deltaY = super.delta(y1, y2);
        int tempDelta = deltaX + deltaY;
        return tempDelta;
    }
}
