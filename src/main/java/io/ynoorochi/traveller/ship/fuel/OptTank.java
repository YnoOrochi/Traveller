/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.fuel;

import io.ynoorochi.traveller.ship.Items;
import java.util.Arrays;

/**
 *
 * @author PR3J
 */
public class OptTank extends Items {
    /* ---------
     *  Constructor
    --------- */
    public OptTank() {
        addItem(new Hidden());
        addItem(new MHydride());
        addItem(new Collapsible());
        addItem(new Demountable());
        addItem(new Drop());
        addItem(new Processor());
        addItem(new Scoop());
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
    *  Tech Level
    --------- */
    @Override
    public int getTL() { 
        int tl = 0;
        for (var opt : getItems()) {
            tl = Math.max(tl, opt.getTL());
        }
        return tl;
    }

    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getWeight() { 
        double aux = 0;
        for (var opt : getItems()) {
            aux += opt.getWeight();
        }
        return aux;
    }

    /* ---------
     *  Option Specific Cost
    --------- */
    @Override
    public double getCost() { 
        double aux = 0;
        for (var opt : getItems()) {
            aux += opt.getCost();
        }
        return aux;
    }

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tank Options {");
        sb.append("TL=").append(getTL());
        sb.append(", Cost=").append(getCost());
        sb.append(", Weight=").append(getWeight());
        sb.append("}\n");
        for (var opt : getItems()) 
            sb.append("    ").append(opt.toString()).append("\n");
        return sb.toString();
    }
}
