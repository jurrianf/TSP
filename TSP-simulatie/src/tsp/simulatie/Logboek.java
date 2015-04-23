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
public class Logboek {
    private ArrayList<Record> records =new ArrayList<>();

    public Logboek() {
        XmlParser p = new XmlParser();
        records = p.getRecords();
    }
    
    public ArrayList<Record> getRecords() {
        return records;
    }

    public void addRecord(Record record)
    {
        records.add(record);
    }

    @Override
    public String toString() {
        
        return "Logboek{" + "records=" + records.toString() + '}';
    }
    
    
    
    
    
    
}
