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
    ArrayList<Vak> vakken;
    ArrayList<Vak> volgorde = new ArrayList<>();
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
        
        
        
        System.out.println(volgorde.size());
        
        afstand = berekenAfstand(volgorde);
        
        route = new Route(volgorde, afstand);
        System.out.println(volgorde);
        
    }

    private int berekenAfstand(ArrayList<Vak> volgorder)
    {
        int afstandi = 0;
        
        for(int i = 1; i < volgorder.size(); i++)
        {
            afstandi += calcDelta(volgorder.get(i-1).getX(), volgorder.get(i-1).getY(), volgorder.get(i).getX(), volgorder.get(i).getY());
            
           // System.out.println("van vak: " + volgorder[i-1].getLocatie() + "naar vak: " + volgorder[i].getLocatie());
        }
        System.out.println(afstandi);
        return afstandi;
    }
    
    @Override
    public void berekenRoute(Order order) {
        vakken = order.getVakken();
        vak = vakken.get(0);
        while (1 < vakken.size()) {
            calcLoop(0, vakken, vak);
            //System.out.println(vak);

        }
        
        volgorde.add(vakken.get(0));
        System.out.println(volgorde);
        System.out.println(vakken);
        

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
                    //System.out.println(vak.toString() + "   delta: " + delta + " |i = " + i + " ,j = " + j);
                }

                for (int a = 0; a < vakken.size(); a++) {
                    if (vakken.get(a).equals(curVak)) {
                        volgorde.add(curVak);
                        vakken.remove(vakken.get(a));
                    }
                }

                //System.out.println("vakken vergeleken: i = " + i + " ,j = " + j);
            }
        }
    }
    
    private int calcDelta(int x1, int y1, int x2,int y2)
    {
        
        int deltaX = super.delta(x1, x2);
        int deltaY = super.delta(y1, y2);
        int tempDelta = deltaX + deltaY;
        return tempDelta;
    }
}
