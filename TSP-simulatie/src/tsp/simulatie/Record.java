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
public class Record {

    private int afstand;
    private String soortAlgoritme;
    private int aantalPakketen;
    private int dimensies;

    public Record(int afstand, String soortAlgoritme, int AantalPakketen, int dimensies) {
        this.afstand = afstand;
        this.soortAlgoritme = soortAlgoritme;
        this.aantalPakketen = AantalPakketen;
        this.dimensies = dimensies;
    }

    public int getAfstand() {
        return afstand;
    }

    public void setAfstand(int afstand) {
        this.afstand = afstand;
    }

    public String getSoortAlgoritme() {
        return soortAlgoritme;
    }

    public void setSoortAlgoritme(String soortAlgoritme) {
        this.soortAlgoritme = soortAlgoritme;
    }

    public int getAantalPakketen() {
        return aantalPakketen;
    }

    public void setAantalPakketen(int AantalPakketen) {
        this.aantalPakketen = AantalPakketen;
    }

    public int getDimensies() {
        return dimensies;
    }

    public void setDimensies(int dimensies) {
        this.dimensies = dimensies;
    }

    @Override
    public String toString() {
        return "Record{" + "Afstand=" + afstand + ", soortAlgoritme=" + soortAlgoritme + ", AantalPakketen=" + aantalPakketen + ", dimensies=" + dimensies + '}';
    }

}
