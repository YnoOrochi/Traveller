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
public class Docks {
    /* ---------
     *  Docks
    --------- */
    private ShipSpaces[] docks = {};
    
    public void addDock(ShipSpaces dock) {
        this.docks = Arrays.copyOf(this.docks, this.docks.length + 1);
        this.docks[this.docks.length - 1] = dock;
    }
    
    public void delDock(ShipSpaces dock) {
        int pos = Arrays.binarySearch(this.docks, dock);
        if (pos >= 0) {
            if (this.docks.length > pos + 1)
                for (int i=pos; i<this.docks.length - 1; i++) {
                    this.docks[i] = this.docks[i+1];
                }
            this.docks = Arrays.copyOf(this.docks, this.docks.length - 1);
        }
    }

    public ShipSpaces[] getDocks() { return this.docks; }

    /* ---------
    *  Rooms best Tech Level
    --------- */
    public int getTL() { 
        int tl = 0;
        for (var obj : getDocks() ) {
            tl = Math.max(tl, obj.getTL());
        }
        return tl;
    }

    /* ---------
    *  Total Rooms Weight
    --------- */
    public double getWeight() { 
        double aux = 0;
        for (var obj : getDocks() ) {
            aux += obj.getWeight();
        }
        return aux;
    }

    /* ---------
    *  Total Rooms Power
    --------- */
    public int getPower() { 
        int aux = 0;
        for (var obj : getDocks() ) {
            aux += obj.getPower();
        }
        return aux;
    }

    /* ---------
    *  Total Rooms Life Support
    --------- */
    public int getLifeSupport() { 
        int aux = 0;
        for (var obj : getDocks() ) {
            aux += obj.getLifeSupport();
        }
        return aux;
    }

    /* ---------
    *  Total Rooms Cost
    --------- */
    public int getPassengers() { 
        int aux = 0;
        for (var obj : getDocks() ) {
            aux += obj.getPassengers();
        }
        return aux;
    }

    /* ---------
    *  Total Rooms Cost
    --------- */
    public double getCost() { 
        double aux = 0;
        for (var obj : getDocks() ) {
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
        sb.append(", Cost=").append(getCost());
        sb.append("}\n");
        for (var room : getDocks()) 
            sb.append("    ").append(room.toString()).append("\n");
        return sb.toString();
    }
}
