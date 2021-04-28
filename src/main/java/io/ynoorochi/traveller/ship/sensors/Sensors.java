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
public class Sensors extends Items {

    /* ---------
     *  Attributes
    --------- */
    public Base base = new Base();
    public Countermeasures cmSuit = new Countermeasures();
    public DeepPenetration dpScan = new DeepPenetration();
    public DistArrays dArrays = new DistArrays(getHullSize());
    public ExtensionNet extNet = new ExtensionNet(getHullSize());
    public LifeScanner lScan = new LifeScanner();
    public MailDistArray mdArray = new MailDistArray();
    public MineralDetection mineral = new MineralDetection();
    public ShallowSuite shallow = new ShallowSuite();
    public SignalProcess signal = new SignalProcess();
    
    /* ---------
     *  Item list
    --------- */
    private final Items[] sensors = {
        base, cmSuit, dpScan, dArrays, extNet, lScan, mdArray, mineral, 
        shallow, signal 
    };
    
    public Items[] getItems() {
        return sensors;
    }

    /* ---------
     *  Constructor
    --------- */
    public Sensors(int hullSize) {
        setHullSize(hullSize);
    }

    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getTL() { 
        int tl = 0;
        for (var sensor : sensors ) {
            tl = Math.max(tl, sensor.getTL());
        }
        return tl;
    }

    /* ---------
    *  Power used
    --------- */
    @Override
    public double getPower() { 
        double aux = 0;
        for (var sensor : sensors ) {
            aux += sensor.getPower();
        }
        return aux;
    }

    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getWeight() { 
        double aux = 0;
        for (var sensor : sensors ) {
            aux += sensor.getWeight();
        }
        return aux;
    }

    /* ---------
     *  Option Specific Cost
    --------- */
    @Override
    public double getCost() { 
        double aux = 0;
        for (var sensor : sensors ) {
            aux += sensor.getCost();
        }
        return aux;
    }

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sensors {");
        sb.append("TL=").append(getTL());
        sb.append(", Cost=").append(getCost());
        sb.append(", Weight=").append(getWeight());
        sb.append(", Power=").append(getPower());
        sb.append("}\n");
        for (var opt : sensors) 
            sb.append("    ").append(opt.toString()).append("\n");
        return sb.toString();
    }
    
}
