/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.systems;

import io.ynoorochi.traveller.ship.Items;

/**
 *
 * @author PR3J
 */
public class Drones extends Items {
    /* ---------
     *  Constructor
    --------- */
    public Drones(ItemTypes type) { setType(type); }
    public Drones(ItemTypes type, int qtty) { 
        setType(type);
        setQtty(qtty);
    }

    /* ---------
     *  Item Types
    --------- */
    public enum ItemTypes {
        PROBED( 9, 0.2, 100000, "Probe Drones"),
        ADVPRB(12, 0.2, 160000, "Advanced Probe Drones"),
        CARGOD( 7, 0.1,  70000, "Cargo Drones"),
        MINING( 9, 0.2, 200000, "Mining Drones"),
        REPAIR( 9, 1  , 200000, "Repair Drones");
        
        private final int tl;
        private final double weight;
        private final double cost;
        private final String name;
        
        private ItemTypes(int tl, double wt, double ct, String nm) {
            this.tl = tl;
            this.weight = wt;
            this.cost = ct;
            this.name = nm;
        }

        public int getTL() { return tl; }
        public double getWeight() { return weight; }
        public double getCost() { return cost; }
        public String getName() { return name; }
    }
    
    private ItemTypes type;
    public ItemTypes getType() { return this.type; }
    public void setType(ItemTypes type) { this.type = type; }

    /* ---------
     *  Number of drones
    --------- */
    public int getQtty() { return getIntAtt(); }
    public void setQtty(int qtty) { setIntAtt(qtty); }
    
    /* ---------
     * is Option on?
    --------- */
    @Override
    public boolean isOptiOn() { return (getQtty() > 0); }

    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getTL() { return type.getTL(); }

    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getBaseWeight() { return getQtty() * type.getWeight(); }
    
    /* ---------
     *  Option Specific Cost
    --------- */
    @Override
    public double getBaseCost() { return getQtty() * type.getCost(); }

    /* ---------
    *  Name
    --------- */
    @Override
    public String getName() { return type.getName(); }
}
