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
public class AtmosphereKit extends Items {
    /* ---------
     *  Constructor
    --------- */
    public AtmosphereKit(AtmoKitType type) { setType(type); }
    
    /* ---------
     *  Airlock Types
    --------- */
    public enum AtmoKitType {
        DM1(11, 1, 1500000, "Atmosphere Maneuver Kit (DM +1)"),
        DM2(11, 1, 1750000, "Atmosphere Maneuver Kit (DM +2)");
        
        private final int tl;
        private final double weight;
        private final double cost;
        private final String name;
        
        private AtmoKitType(int tl, double wt, double ct, String nm) {
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
    
    private AtmoKitType type;
    public AtmoKitType getType() { return this.type; }
    public void setType(AtmoKitType type) { 
        this.type = type; 
        setOptiOn(true);
    }

    /* ---------
     *  Tech Level
    --------- */
    @Override
    public int getTL() { return type.getTL(); }

    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getBaseWeight() { return type.getWeight(); }
    
    /* ---------
     *  Option Specific Cost
    --------- */
    @Override
    public double getBaseCost() { return type.getCost(); }

    /* ---------
    *  Name
    --------- */
    @Override
    public String getName() { return type.getName(); }
}
