/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.sensors;

import io.ynoorochi.traveller.ship.Items;
import java.util.Arrays;

/**
 *
 * @author PR3J
 */
public class Sensors extends Items {
    /* ---------
     *  Constructor
    --------- */
    public Sensors(int hullSize) {
        setHullSize(hullSize);
        addItem(new Base());
        
        otherItems();
    }

    /* ---------
     *  Array Manipulation
    --------- */
    private Items[] itemList = {};
    
    public void addItem(Items item) {
        itemList = Arrays.copyOf(itemList, itemList.length + 1);
        itemList[itemList.length - 1] = item;
    }
    
    public void delItem(Items item) {
        int pos = Arrays.binarySearch(itemList, item);
        if (pos >= 0) {
            if (itemList.length > pos + 1)
                for (int i=pos; i<itemList.length - 1; i++) {
                    itemList[i] = itemList[i+1];
                }
            itemList = Arrays.copyOf(itemList, itemList.length - 1);
        }
    }

    public Items[] getItems() { return itemList; }

    /* ---------
     *  Adiciona todos os sensores
    --------- */
    private void otherItems() {
        addItem(new Countermeasures());
        addItem(new DeepPenetration());
        addItem(new DistArrays(getHullSize()));
        addItem(new ExtensionNet(getHullSize()));
        addItem(new LifeScanner());
        addItem(new MailDistArray());
        addItem(new MineralDetection());
        addItem(new ShallowSuite());
        addItem(new SignalProcess());
    }
    
    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getTL() { 
        int tl = 0;
        for (var sensor : getItems() ) {
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
        for (var sensor : getItems() ) {
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
        for (var sensor : getItems() ) {
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
        for (var sensor : getItems() ) {
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
        for (var opt : getItems()) 
            sb.append("    ").append(opt.toString()).append("\n");
        return sb.toString();
    }
    
}
