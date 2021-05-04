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
public class Airlocks extends Items {
    /* ---------
     *  Constructor
    --------- */
    public Airlocks(AirlockType type) { setType(type); }
    public Airlocks(AirlockType type, int qtty) { 
        setType(type);
        setQtty(qtty);
    }
    
    /* ---------
     *  Airlock Types
    --------- */
    public enum AirlockType {
        ADDLCK( 7, 2,  200000, "Additional Airlocks"),
        TRAP07( 7, 0,  100000, "Booby-Trapped Airlocks (Basic)"),
        TRAP08( 8, 0,  300000, "Booby-Trapped Airlocks (TL08)"),
        TRAP10(10, 0,  500000, "Booby-Trapped Airlocks (TL10)"),
        TRAP12(12, 0, 1000000, "Booby-Trapped Airlocks (TL12)");
        
        private final int tl;
        private final double weight;
        private final double cost;
        private final String name;
        
        private AirlockType(int tl, double wt, double ct, String nm) {
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
    
    private AirlockType type;
    public AirlockType getType() { return this.type; }
    public void setType(AirlockType type) { this.type = type; }

    /* ---------
     *  Number of airlocks
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
