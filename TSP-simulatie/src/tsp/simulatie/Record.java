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
public class Record {// een record houd allerlei releavante informatie per simlatie
    private int afstand;
    private String soortAlgoritme;
    private int aantalArtikelen;
    private int dimensies;
    private Order order;
    private Route route;

    public Record(int afstand, String soortAlgoritme, int aantalArtikelen, int dimensies, Order order, Route route) {
        this.afstand = afstand;
        this.soortAlgoritme = soortAlgoritme;
        this.aantalArtikelen = aantalArtikelen;
        this.dimensies = dimensies;
        this.order = order;
        this.route = route;
    }

    public Order getOrder() {
        return order;
    }

    public Route getRoute() {
        return route;
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

    public int getAantalArtikelen() {
        return aantalArtikelen;
    }

    public void setAantalArtikelen(int AantalArtikelen) {
        this.aantalArtikelen = AantalArtikelen;
    }

    public int getDimensies() {
        return dimensies;
    }

    public void setDimensies(int dimensies) {
        this.dimensies = dimensies;
    }

    @Override
    public String toString() {
        return "Record{" + "afstand=" + afstand + ", soortAlgoritme=" + soortAlgoritme + ", AantalArtikelen=" + aantalArtikelen + ", dimensies=" + dimensies + '}';
    }

}
