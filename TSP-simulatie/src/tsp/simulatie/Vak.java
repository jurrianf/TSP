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
    private Locatie locatie;
    private int vakVolgorde;
    static private int Groote = 50;

    public Vak(int x, int y) {
        this.locatie = new Locatie(x, y);
        this.isGeselecteerd = false;
    }

    public boolean getIsGeselecteerd() {
        return isGeselecteerd;
    }

    public void isGeselecteerd() {
        this.isGeselecteerd = !this.isGeselecteerd;
    }

    public Locatie getLocatie() {
        return locatie;
    }
    
    public int getX()
    {
        return locatie.getX();
    }
    
    public int getY()
    {
        return locatie.getY();
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

