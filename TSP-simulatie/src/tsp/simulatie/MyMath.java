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
    
    public int delta(int a, int b)//bereken de delta van twee ints
    {
        if(a - b >= 0)
        {
            return a - b;
        }else
        {
            return b-a;
        }
    }
    
    public long fac(long a)//bereken de fakkulteit
    {
        if(a > 20)
        {
            return 0;
        }
        else if(a == 1 || a == 0)
        {
            return 1;
        }
        else
        {
            return a * fac(a-1);
        }
    }
    
}
