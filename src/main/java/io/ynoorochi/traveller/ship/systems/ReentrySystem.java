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
public class ReentrySystem extends Items {
    /* ---------
     *  Constructor
    --------- */
    public ReentrySystem(ReentryType type) { setType(type); }
    public ReentrySystem(ReentryType type, int qtty) { 
        setType(type);
        setQtty(qtty);
    }
    
    /* ---------
     *  Drone Types
    --------- */
    public enum ReentryType {
        CAP08( 8, 0.5,  20000, "Re-entry Capsule (TL08)"),
        CAP10(10, 0.5,  50000, "Re-entry Capsule (TL10)"),
        CAP14(14, 0.5, 100000, "Re-entry Capsule (TL14)"),
        POD(   9, 1  , 150000, "Re-entry Pod");
        
        private final int tl;
        private final double weight;
        private final double cost;
        private final String name;
        
        private ReentryType(int tl, double wt, double ct, String nm) {
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
    
    private ReentryType type;
    public ReentryType getType() { return this.type; }
    public void setType(ReentryType type) { this.type = type; }

    /* ---------
     *  Number of items
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
