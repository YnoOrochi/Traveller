/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.sensors;

import io.ynoorochi.traveller.ship.Items;

/**
 *
 * @author PR3J
 */
public class Sensors {
    /* ---------
     *  Attributes
    --------- */
    private Base base = new Base();
    private Countermeasures cmSuit = new Countermeasures();
    private DeepPenetration dpScan = new DeepPenetration();
    private DistArrays dArrays = new DistArrays();
    private LifeScanner lScan = new LifeScanner();
    private MailDistArray mdArray = new MailDistArray();
    
    /* ---------
     *  Item list
    --------- */
    private final Items[] sensors = {
        base, cmSuit, dpScan, dArrays, lScan, mdArray
    };
    
    public Items[] getItems() {
        return sensors;
    }

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sensors {\n");
        for (var opt : sensors) 
            sb.append("    ").append(opt.toString()).append("\n");
        sb.append("}");
        return sb.toString();
    }
    
}
