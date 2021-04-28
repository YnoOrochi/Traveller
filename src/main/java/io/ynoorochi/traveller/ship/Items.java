/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship;

import io.ynoorochi.traveller.ship.Definitions.Hardened;
import static io.ynoorochi.traveller.ship.Definitions.Hardened.*;

/**
 *
 * @author PR3J
 */
public abstract class Items {
    /* ---------
    *  Option setter
    *      returns the operation result
    *      false means: the option has some constraint that was not observed
    --------- */
    private boolean option = false;

    public boolean setOptiOn(boolean opt) {
        this.option = opt;
        return true;
    }
    
    /* is Option on? */
    public boolean isOptiOn() {
        return this.option;
    }

    /* ---------
     *  Hardened Item
    --------- */
    protected Hardened hardened = NOTHARDENED;
    
    public double getHardened() {
        if (getPower() > 0) return this.hardened.getModf();
        else return NOTHARDENED.getModf();
    }
    
    public void setHardened(Hardened opt) {
        if (getPower() > 0) this.hardened = opt;
        else this.hardened = NOTHARDENED;
    }
    
    /* is Hardened? */
    public boolean isHardened() { return (this.hardened == HARDENED); }

    
    /* ---------
    *  Hull Size
    --------- */
    private int hullSize;
    public int getHullSize() { return this.hullSize; }
    public void setHullSize(int hullSize) { this.hullSize = hullSize; }

    /* ---------
    *  Tech Level
    --------- */
    public int getTL() {
        return 0;
    }

    /* ---------
    *  Power used
    --------- */
    public double getPower() {
        return 0;
    }

    /* ---------
     *  Tonnage Used by Option
    --------- */
    public double getWeight() {
        return 0;
    }
    
    /* ---------
     *  Option Specific Cost
    --------- */
    public double getCost() {
        return 0;
    }
    
    /* ---------
    *  Option Cost Modifier
    --------- */
    public double getCostModf() {
        return 0;
    }

    /* ---------
    *  Auxiliar double Attribute 
    *       Rating
    --------- */
    protected double rating = 0;
    protected double getAttribute() { return this.rating; }
    protected void setAttribute(double rating) { this.rating = rating; }

    /* ---------
    *  Auxiliar Attribute Modifier
    --------- */
    public double getAttModf() {
        return 0;
    }

    /* ---------
    * Auxiliar int Attribute
    *       Autonomy (Hours, Weeks, Jumps ...)
    --------- */
    protected int nAtt = 0;
    protected int getIntAtt() { return this.nAtt; }
    protected void setIntAtt(int att) { this.nAtt = att; }

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append("{").append(isOptiOn());
        if (isOptiOn()) {
            sb.append(", Weight=").append(getWeight());
            sb.append(", Cost=").append(getCost());
            if (isHardened()) sb.append(", Hardened");
        }
        sb.append('}');
        return sb.toString();
    }
}
