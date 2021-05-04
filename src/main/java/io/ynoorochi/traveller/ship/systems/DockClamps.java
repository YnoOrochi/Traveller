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
public class DockClamps extends Items {
    /* ---------
     *  Constructor
    --------- */
    public DockClamps(ClampType type) { setType(type); }
    public DockClamps(ClampType type, int qtty) { 
        setType(type);
        setQtty(qtty);
    }
    
    /* ---------
     *  Drone Types
    --------- */
    public enum ClampType {
        I(  7,  1,  500000, "Docking Clamps (30t)"),
        II( 7,  5, 1000000, "Docking Clamps (99t)"),
        III(7, 10, 2000000, "Docking Clamps (300t)"),
        IV( 7, 20, 4000000, "Docking Clamps (2000t)"),
        V(  7, 50, 8000000, "Docking Clamps (any)");
        
        private final int tl;
        private final double weight;
        private final double cost;
        private final String name;
        
        private ClampType(int tl, double wt, double ct, String nm) {
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
    
    private ClampType type;
    public ClampType getType() { return this.type; }
    public void setType(ClampType type) { this.type = type; }

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
    public double getWeight() { return getQtty() * type.getWeight(); }
    
    /* ---------
     *  Option Specific Cost
    --------- */
    @Override
    public double getCost() { return getQtty() * type.getCost(); }

    /* ---------
    *  Name
    --------- */
    @Override
    public String getName() { return type.getName(); }

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append("{").append(getQtty());
        if (isOptiOn()) {
            sb.append(", TL=").append(getTL());
            sb.append(", Cost=").append(getCost());
            sb.append(", Weight=").append(getWeight());
            sb.append(", Power=").append(getPower());
            if (isHardened()) sb.append(", Hardened");
        }
        sb.append('}');
        return sb.toString();
    }
}
