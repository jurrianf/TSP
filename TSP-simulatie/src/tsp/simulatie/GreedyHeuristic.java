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
public class GreedyHeuristic extends MyMath implements Algoritme{
    
    Order order;
    Route route;
    Vak routeVakken[][];

    public GreedyHeuristic(Order order) {
        this.order = order;
        berekenRoute(order);
        int demensions = (order.getVakken().size()-1);
        routeVakken = new Vak[demensions][demensions];
    }
    
    
    
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

    @Override
    public void berekenRoute(Order order) {
        ArrayList<Vak> vakken = order.getVakken();
        
        
        for(int i = 0; i < vakken.size(); i++)
        {
            startLoop(vakken);
        }
        
    }
    
    private void startLoop(ArrayList<Vak> v)
    {
        for(int i = 0; i < v.size(); i++)
        {
            calcLoop(i, v, v.get(i));
        }
    }
    
    private void calcLoop(int j, ArrayList<Vak> v, Vak curVak)
    {
        int x;
        int y;
        int curX = curVak.getX();
        int curY= curVak.getY();
        int xy;
        int curXY = curX+curY;
        int delta = 0xFFFFFF;
        Vak vak;
        
        for(int i = j; i < v.size(); i++)
        {
            if(i != j)
            {
                x = v.get(i).getX();
                y = v.get(i).getY();
                xy= x+y;
                int tempDelta = super.delta(xy, curXY);
                if(tempDelta < delta)
                {
                    delta = tempDelta;
                    vak = v.get(i);
                    //System.out.println(vak.toString() + "   delta: " + delta + " |i = " + i + " ,j = " + j);
                }
                
                System.out.println("vakken vergeleken: i = " + i + " ,j = " + j);
            }
        }
        
    }
    
}
