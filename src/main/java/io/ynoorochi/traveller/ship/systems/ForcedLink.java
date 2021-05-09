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
public class ForcedLink extends Items {
    /* ---------
     *  Constructor
    --------- */
    public ForcedLink(FLinkType type) { setType(type);
        setType(type);
    }
    
    /* ---------
     *  Drone Types
    --------- */
    public enum FLinkType {
        TL07( 7, 2,  50000, "Forced Linkage Apparatus (TL07)"),
        TL09( 9, 2,  75000, "Forced Linkage Apparatus (TL09)"),
        TL12(12, 1, 100000, "Forced Linkage Apparatus (TL12)"),
        TL15(15, 2, 500000, "Forced Linkage Apparatus (TL15)");
        
        private final int tl;
        private final double weight;
        private final double cost;
        private final String name;
        
        private FLinkType(int tl, double wt, double ct, String nm) {
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
    
    private FLinkType type;
    public FLinkType getType() { return this.type; }
    public void setType(FLinkType type) { 
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
