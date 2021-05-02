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
    public Drones(DroneType type) { setType(type); }
    public Drones(DroneType type, int qtty) { 
        setType(type);
        setQtty(qtty);
    }

    /* ---------
     *  Drone Types
    --------- */
    public enum DroneType {
        PROBED( 9, 0.2, 100000, "Probe Drones"),
        ADVPRB(12, 0.2, 160000, "Advanced Probe Drones"),
        CARGOD( 7, 0.1,  70000, "Cargo Drones"),
        MINING( 9, 0.2, 200000, "Mining Drones"),
        REPAIR( 9, 1  , 200000, "Repair Drones");
        
        private final int tl;
        private final double weight;
        private final double cost;
        private final String name;
        
        private DroneType(int tl, double wt, double ct, String nm) {
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
    
    private DroneType type;
    public DroneType getType() { return this.type; }
    public void setType(DroneType type) { this.type = type; }

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
        sb.append(this.getClass().getSimpleName()).append("{").append(getQtty());
        if (isOptiOn()) {
            sb.append(", Type=").append(getName());
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
