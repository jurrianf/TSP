package tsp.simulatie;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Johan
 */
// interface voor de algoritmes

public interface Algoritme {

    
    void Algoritme(Order order);
    
    Order getOrder();
    
    Route getRoute();
    
    void berekenRoute(Order order);
}
