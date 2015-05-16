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
    Vak routeVakkenI[];
    Vak routeVakkenJ[];
    int index = 0;
    int demensions;
    int delta;
    int rows;
    int afstand;
    boolean startArrayI;

    public GreedyHeuristic(Order order, int rows) {
        this.order = order;
        this.rows = rows;
        demensions = (order.getVakken().size()-1);
        routeVakkenI = new Vak[demensions];
        routeVakkenJ = new Vak[demensions];
        berekenRoute(order);
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
        ArrayList<Vak> volgorder = new ArrayList<>();
        
        for(int i = 0; i < demensions; i++)
        {
            
            delta = 0xFFFFFF;
            startLoop(vakken);
            index++;
        }
        
        for(int i = 0; i < index; i++)
        {
            System.out.println("lijn tussen: " + routeVakkenI[i] + " en " + routeVakkenJ[i] + " index:" + i);
        }
        
        volgorder.add(berkenStartPunt(routeVakkenI, routeVakkenJ));
        for(int i = 1; i < vakken.size(); i++)
        {
            volgorder.add(nextVak(volgorder.get(i-1)));
            
           
        }
        
        System.out.println(volgorder.size());
        
         System.out.println(volgorder);
        
        afstand = berekenAfstand(volgorder);
        
        route = new Route(volgorder, afstand);
        System.out.println(volgorder);
        
        
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
    
    private Vak nextVak(Vak curVak)
    {
        Vak vak = null;
        if(startArrayI)
        {
            for(int i = 0; i < demensions; i++)
            {
                if(curVak == routeVakkenI[i])
                {
                    vak =routeVakkenJ[i];
                }
            }
        }else
        {
            for(int i = 0; i < demensions; i++)
            {
                if(curVak == routeVakkenJ[i])
                {
                    vak = routeVakkenI[i];
                }
            }
        }
        
        return vak;
    }
    
    private void startLoop(ArrayList<Vak> v)
    {
        for(int i = 0; i < v.size(); i++)
        {
            calcLoopFrontToBack(i, v, v.get(i));
            if(index == demensions-1)
            {
                calcLoopBackToFront(i, v, v.get(i));
            }
        }
    }
    
    private void calcLoopFrontToBack(int j, ArrayList<Vak> v, Vak curVak)
    {
        int x;
        int y;
        int curX = curVak.getX();
        int curY= curVak.getY();
        int xy;
        int curXY = curX+curY;
        Vak vak;
        
        for(int i = j; i < v.size(); i++)
        {
            if(i != j && checkIfCompared(v.get(i), curVak))
            {
                x = v.get(i).getX();
                y = v.get(i).getY();
                xy= x+y;
                int tempDeltaX = super.delta(x, curX);
                int tempDeltaY = super.delta(y, curY);
                int tempDelta = tempDeltaX + tempDeltaY;
                if(tempDelta <= delta)
                {
                    delta = tempDelta;
                    routeVakkenI[index] = v.get(i);
                    routeVakkenJ[index] = curVak;
                    System.out.println("lijn gemaakt tussen " + routeVakkenI[index] + " en " + routeVakkenJ[index] + " met tempdelta: " + tempDelta + " en delta " + delta +" geplaatst op index: " + index);
                    //System.out.println(vak.toString() + "   delta: " + delta + " |i = " + i + " ,j = " + j);
                }
                
                System.out.println("vakken vergeleken: i = " + v.get(i) + " ,j = " + curVak);
            }
        }
        
        
    }
    
    private void calcLoopBackToFront(int j, ArrayList<Vak> v, Vak curVak)
    {
        int x;
        int y;
        int curX = curVak.getX();
        int curY= curVak.getY();
        int xy;
        int curXY = curX+curY;
        Vak vak;
        
        for(int i = demensions; i >= 0; i--)
        {
            if(i != j && checkIfCompared(v.get(i), curVak))
            {
                x = v.get(i).getX();
                y = v.get(i).getY();
                xy= x+y;
                int tempDeltaX = super.delta(x, curX);
                int tempDeltaY = super.delta(y, curY);
                int tempDelta = tempDeltaX + tempDeltaY;
                if(tempDelta <= delta)
                {
                    delta = tempDelta;
                    routeVakkenI[index] = v.get(i);
                    routeVakkenJ[index] = curVak;
                    System.out.println("lijn gemaakt tussen " + routeVakkenI[index] + " en " + routeVakkenJ[index] + " met tempdelta: " + tempDelta + " en delta " + delta +" geplaatst op index: " + index);
                    //System.out.println(vak.toString() + "   delta: " + delta + " |i = " + i + " ,j = " + j);
                }
                
                System.out.println("vakken vergeleken: i = " + v.get(i) + " ,j = " + curVak);
            }
        }
        
        
    }
    
    private boolean magComparen(Vak vakI, Vak vakJ)
    {
        boolean result = true;
        
        boolean var1;
        boolean var2;
        
        var1 = checkIfCompared(vakI, vakJ);
        var2 = checkIfNotDouble(vakI);
        
        if(!var1 || !var2)
        {
            result = false;         
        }
        
        return result;
    }
    
    private boolean checkIfCompared(Vak vakI, Vak vakJ)
    {
        boolean result = true;
        
        for(int i = 0; i < index; i++)
        {
            if(vakJ == routeVakkenJ[i])
            {
                result = false;
            }
            if(vakI == routeVakkenI[i])
            {
                result = false;
            }
            /*if(vakJ == routeVakkenI[i])
            {
                result = false;
            }*/
        }
        
        return result;
    }
    
    private boolean checkIfNotDouble(Vak vakI)
    {
        boolean result = true;
        boolean var3 = false;
        boolean var4 = false;
        for(int i = 0; i < index; i++)
        {          
           if(vakI == routeVakkenI[i])
            {
                var3 = true;
            }
            if(vakI == routeVakkenJ[i])
            {
                var4 = true;
            }
        }
        
        if(var3 && var4)
        {
            result = false;
        }
        
        return result;
    }
    
    private Vak berkenStartPunt(Vak[] vakkenI, Vak[] vakkenJ)
    {
       boolean vakGevonden = false;
       Vak vakEen = null;
       Vak vakTwee = null;
       for(int i = 0; i < vakkenI.length; i++)
       {
            for(int j = 0; j < vakkenJ.length; j++)
            {
                if(vakkenI[i] == vakkenJ[j])
                {
                    vakGevonden = false;
                    break;
                }else
                {
                    vakGevonden = true;
                }
                
                
            }
            if(vakGevonden)
            {
                vakEen = vakkenI[i];
                break;
            }
            
        }
       
       for(int j = 0; j < vakkenJ.length; j++)
       {
            for(int i = 0; i < vakkenI.length; i++)
            {
                if(vakkenJ[j] == vakkenI[i])
                {
                    vakGevonden = false;
                    break;
                }else
                {
                    vakGevonden = true;
                }
                
                
            }
            if(vakGevonden)
            {
                vakTwee = vakkenJ[j];
                break;
            }
            
        }
        
       return calcBottomLeftMost(vakEen, vakTwee);
       
    }
    
    
    private Vak calcBottomLeftMost(Vak vak1, Vak vak2)
    {
        int delta1 = calcDelta(vak1.getX(), vak1.getY(), 0, rows);
        int delta2 = calcDelta(vak2.getX(), vak2.getY(), 0, rows);
        if(delta1 <= delta2)
        {
            startArrayI = true;
            return vak1;
        }else
        {
            startArrayI = false;
            return vak2;
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
