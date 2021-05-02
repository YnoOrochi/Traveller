/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.spaces;

import java.util.Arrays;

/**
 *
 * @author PR3J
 */
public class Spaces {
    /* ---------
     *  Array Manipulation
    --------- */
    private SpaceItems[] itemList = {};
    
    public void addItem(SpaceItems item) {
        itemList = Arrays.copyOf(itemList, itemList.length + 1);
        itemList[itemList.length - 1] = item;
    }
    
    public void delItem(SpaceItems item) {
        int pos = Arrays.binarySearch(itemList, item);
        if (pos >= 0) {
            if (itemList.length > pos + 1)
                for (int i=pos; i<itemList.length - 1; i++) {
                    itemList[i] = itemList[i+1];
                }
            itemList = Arrays.copyOf(itemList, itemList.length - 1);
        }
    }

    public SpaceItems[] getItems() { return itemList; }

    /* ---------
    *  Best Tech Level
    --------- */
    public int getTL() { 
        int tl = 0;
        for (var obj : getItems() ) {
            tl = Math.max(tl, obj.getTL());
        }
        return tl;
    }

    /* ---------
    *  Total Weight
    --------- */
    public double getWeight() { 
        double aux = 0;
        for (var obj : getItems() ) {
            aux += obj.getWeight();
        }
        return aux;
    }

    /* ---------
    *  Total Power
    --------- */
    public int getPower() { 
        int aux = 0;
        for (var obj : getItems() ) {
            aux += obj.getPower();
        }
        return aux;
    }

    /* ---------
    *  Total Life Support
    --------- */
    public int getLifeSupport() { 
        int aux = 0;
        for (var obj : getItems() ) {
            aux += obj.getLifeSupport();
        }
        return aux;
    }

    /* ---------
    *  Total Passengers
    --------- */
    public int getPassengers() { 
        int aux = 0;
        for (var obj : getItems() ) {
            aux += obj.getPassengers();
        }
        return aux;
    }

    /* ---------
    *  Total Cost
    --------- */
    public double getCost() { 
        double aux = 0;
        for (var obj : getItems() ) {
            aux += obj.getCost();
        }
        return aux;
    }

    /* ---------
    *  Option Get Name
    --------- */
    public String getName() {
        return this.getClass().getSimpleName();
    }
    
    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append("{");
        sb.append("TL=").append(getTL());
        sb.append(", Weight=").append(getWeight());
        sb.append(", Life Support=").append(getLifeSupport());
        sb.append(", Passengers=").append(getPassengers());
        sb.append(", Cost=").append(getCost());
        sb.append("}\n");
        for (var room : getItems()) 
            sb.append("    ").append(room.toString()).append("\n");
        return sb.toString();
    }
}
