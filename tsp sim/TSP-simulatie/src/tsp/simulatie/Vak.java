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
    private String locatie;
    private int vakVolgorde;
    static private int Groote = 50;

    public Vak(String locatie) {
        this.locatie = locatie;
        this.isGeselecteerd = false;
    }

    public boolean getIsGeselecteerd() {
        return isGeselecteerd;
    }

    public void isGeselecteerd() {
        this.isGeselecteerd = !this.isGeselecteerd;
    }

    public String getLocatie() {
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

