/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tsp.simulatie;

/**
 *
 * @author Johan
 */
public abstract class MyMath {
    
    public int delta(int a, int b)
    {
        if(a - b >= 0)
        {
            return a - b;
        }else
        {
            return b-a;
        }
    }
    
}
