/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kbs;

/**
 *
 * @author Jurrian
 */
public class Vakken {

    private boolean isGeselecteerd;
    private String locatie;
    private int vakVolgorde;
    private int Groote;

    public void vak(String locatie) {
        this.locatie = locatie;
    }

    public boolean isIsGeselecteerd() {
        return isGeselecteerd;
    }

    public void setIsGeselecteerd(boolean isGeselecteerd) {
        this.isGeselecteerd = isGeselecteerd;
    }

    public String getLocatie() {
        return locatie;
    }

    public int getGroote() {
        return Groote;
    }

    public void setGroote(int Groote) {
        this.Groote = Groote;

    }

    public void setVakVolgorde(int vakVolgorde) {
        this.vakVolgorde = vakVolgorde;
    }

}
