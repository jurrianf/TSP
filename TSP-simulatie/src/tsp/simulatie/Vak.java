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
public class Vak {
    private boolean isGeselecteerd;
    private int locatie;
    private int vakVolgorde;
    static private int Groote = 50;

    public Vak(int locatie) {
        this.locatie = locatie;
    }

    public boolean getIsGeselecteerd() {
        return isGeselecteerd;
    }

    public void setIsGeselecteerd(boolean isGeselecteerd) {
        this.isGeselecteerd = isGeselecteerd;
    }

    public int getLocatie() {
        return locatie;
    }

    static public int getGroote() {
        return Groote;
    }

    public void setVakVolgorde(int vakVolgorde) {
        this.vakVolgorde = vakVolgorde;
    }

    @Override
    public String toString() {
        return "Vak{" + "locatie=" + locatie + '}';
    }
    
    

}

