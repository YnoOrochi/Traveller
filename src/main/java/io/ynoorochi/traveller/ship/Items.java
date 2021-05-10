/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship;

/**
 *
 * @author PR3J
 */
public abstract class Items {
    /* ---------
    *  Option
    --------- */
    private boolean option = false;
    public boolean isOptiOn() { return this.option; }
    public void setOptiOn(boolean opt) { this.option = opt; }

    /* ---------
     *  Armored Bulkheaded Item
    --------- */
    protected boolean armoured = false;
    protected double getArmouredWgtModf() { return (isArmoured() ? 0.1 : 0 ); }
    protected double getArmouredCost() { return (isArmoured() ? 200000 * getBaseWeight() : 0); }
    public boolean isArmoured() { return this.armoured; }
    public void setArmoured(boolean opt) { this.armoured = opt; }

    /* ---------
     *  Hardened Item
    --------- */
    protected boolean hardened = false;
    protected double getHardenedCstModf() { return (isHardened() ? 0.5 : 0); }
    public boolean isHardened() { return this.hardened; }
    public void setHardened(boolean opt) { this.hardened = (getPower() > 0 ? opt : false); }

    /* ---------
    *  Hull Size
    --------- */
    private int hullSize;
    public int getHullSize() { return this.hullSize; }
    public void setHullSize(int hullSize) { this.hullSize = hullSize; }

    /* ---------
    *  Tech Level
    --------- */
    public int getTL() { return 0; }

    /* ---------
    *  Power used
    --------- */
    public double getPower() { return 0; }

    /* ---------
     *  Tonnage Used by Option
    --------- */
    protected abstract double getBaseWeight();
    public double getWeight() { return (1 + getArmouredWgtModf()) * getBaseWeight(); }
    
    /* ---------
    *  Item Cargo
    --------- */
    public double getCargo() { return 0; }

    /* ---------
     *  Option Cost
    --------- */
    protected abstract double getBaseCost();
    public double getCost() { 
        return (1 + getHardenedCstModf()) * getBaseCost() + getArmouredCost();
    }
    
    /* ---------
    *  Option Cost Modifier
    --------- */
    public double getCostModf() { return 0; }

    /* ---------
    *  Option Get Name
    --------- */
    public String getName() { return this.getClass().getSimpleName(); }
    
    /* ---------
    *  Auxiliar double Attribute 
    *       Rating
    --------- */
    protected double dblAtt = 0;
    protected double getDblAtt() { return this.dblAtt; }
    protected void setDblAtt(double rating) { this.dblAtt = rating; }

    /* ---------
    *  Auxiliar Attribute Modifier
    --------- */
    public double getAttModf() { return 0; }

    /* ---------
    * Auxiliar int Attribute
    *       Autonomy (Hours, Weeks, Jumps ...)
    --------- */
    protected int intAtt = 0;
    protected int getIntAtt() { return this.intAtt; }
    protected void setIntAtt(int att) { this.intAtt = att; }

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append("{").append(isOptiOn());
        if (isOptiOn()) {
            if (getTL() > 0) sb.append(", TL=").append(getTL());
            sb.append(", Weight=").append(getWeight());
            if (getCargo() > 0) sb.append(", Cargo=").append(getCargo());
            if (getPower() > 0) sb.append(", Power=").append(getPower());
            sb.append(", Cost=").append(getCost());
            if (isHardened()) sb.append(", Hardened");
            if (isArmoured()) sb.append(", Armoured Bulkheaded");
        }
        sb.append('}');
        return sb.toString();
    }
}
