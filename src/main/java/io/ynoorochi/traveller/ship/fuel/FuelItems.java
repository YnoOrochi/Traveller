/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.fuel;

import io.ynoorochi.traveller.ship.Items;

/**
 *
 * @author PR3J
 */
public abstract class FuelItems extends Items {
    /* ---------
     *  Tank Size (ton)
    --------- */
    public int getSize() { return getIntAtt(); }
    public void setSize(int size) { setIntAtt(size); }

    /* ---------
     *  Metal Hydride Fuel
    --------- */
    private boolean mHydride = false;
    protected int getMHdTL() { return isMHd() ? 9 : 0; }
    protected double getMHdCost() { return isMHd() ? 200000 * getSize() : 0; }
    protected double getMHdWgtModf() { return isMHd() ? 1 : 0; }
    public void setMHd(boolean opt) { this.mHydride = opt; }
    public boolean isMHd() { return this.mHydride; }

    /* ---------
    *  is Option on?
    --------- */
    @Override
    public boolean isOptiOn() { return getSize() > 0; }

    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getTL() { return getMHdTL(); }

    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getWeight() { 
        return (1 + getArmouredWgtModf() + getMHdWgtModf()) * getBaseWeight(); 
    }
    
    /* ---------
     *  Option Cost
    --------- */
    @Override
    public double getCost() { 
        return getBaseCost() + getArmouredCost() + getMHdCost();
    }
    
    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append("{").append(isOptiOn());
        if (isOptiOn()) {
            sb.append(", TL=").append(getTL());
            sb.append(", Size=").append(getSize());
            sb.append(", Weight=").append(getWeight());
            sb.append(", Cost=").append(getCost());
            if (isArmoured()) sb.append(", Armoured Bulkheaded");
        }
        sb.append('}');
        return sb.toString();
    }
}
