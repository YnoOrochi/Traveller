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
public class GrapArms extends Items {
    /* ---------
     *  Constructor
    --------- */
    public GrapArms(GrapArmType type) { setType(type); }
    public GrapArms(GrapArmType type, int qtty) { 
        setType(type);
        setQtty(qtty);
    }
    
    /* ---------
     *  Grapping Arms Types
    --------- */
    public enum GrapArmType {
        NORML( 7, 2, 1000000, "Grappling Arms"),
        HEAVY( 8, 6, 3000000, "Heavy Grappling Arms");
        
        private final int tl;
        private final double weight;
        private final double cost;
        private final String name;
        
        private GrapArmType(int tl, double wt, double ct, String nm) {
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
    
    private GrapArmType type;
    public GrapArmType getType() { return this.type; }
    public void setType(GrapArmType type) { this.type = type; }

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
