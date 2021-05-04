/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.systems;

import io.ynoorochi.traveller.ship.Definitions.Hardened;
import io.ynoorochi.traveller.ship.Items;

/**
 *
 * @author PR3J
 */
public class CargoLoadBelt extends Items {
    /* ---------
     *  Constructor
    --------- */
    public CargoLoadBelt(LoadBeltType type) { setType(type); }
    
    /* ---------
     *  Types
    --------- */
    public enum LoadBeltType {
        TL07( 7, 1, 1,  3000, "Cargo Loading Belt (TL07)"),
        TL11(11, 1, 1, 10000, "Cargo Loading Belt (TL11)");
        
        private final int tl;
        private final double weight;
        private final int power;
        private final double cost;
        private final String name;
        
        private LoadBeltType(int tl, double wt, int pw, double ct, String nm) {
            this.tl = tl;
            this.weight = wt;
            this.power = pw;
            this.cost = ct;
            this.name = nm;
        }

        public int getTL() { return tl; }
        public double getWeight() { return weight; }
        public int getPower() { return power; }
        public double getCost() { return cost; }
        public String getName() { return name; }
    }
    
    private LoadBeltType type;
    public LoadBeltType getType() { return this.type; }
    public void setType(LoadBeltType type) {
        this.type = type;
        setOptiOn(true);
    }

    /* ---------
     *  Tech Level
    --------- */
    @Override
    public int getTL() { return type.getTL(); }

    /* ---------
     *  Option Power
    --------- */
    @Override
    public double getPower() { return type.getPower(); }
    
    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getWeight() { return type.getWeight(); }
    
    /* ---------
     *  Option Specific Cost
    --------- */
    @Override
    public double getCost() { return (1 + getHardened()) * type.getCost(); }

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
        sb.append(getName()).append("{").append(isOptiOn());
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
