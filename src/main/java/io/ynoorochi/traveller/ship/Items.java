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
     *  Attributes
    --------- */
    private boolean option = false;
    
    /* ---------
    *  Option setter
    *      returns the operation result
    *      false means: the option has some constraint that was not observed
    --------- */
    public boolean setOptiOn(boolean opt) {
        this.option = opt;
        return true;
    }
    
    /* ---------
    *  is Option on?
    --------- */
    public boolean isOptiOn() {
        return this.option;
    }

    /* ---------
    *  Hull Size
    --------- */
    private int hullSize;

    public int getHullSize() {
        return this.hullSize;
    }

    public void setHullSize(int hullSize) {
        this.hullSize = hullSize;
    }

    /* ---------
    *  Tech Level
    --------- */
    public int getTL() {
        return 0;
    }

    public int maxTL(int tl) {
        return Math.max(this.getTL(), tl);
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
    *  Auxiliar Attribute Rating
    --------- */
    protected double rating = 0;

    public double getAttribute() {
        return this.rating;
    }

    public void setAttribute(double rating) {
        this.rating = rating;
    }

    /* ---------
    *  Auxiliar Attribute Rating Modifier
    --------- */
    public double getAttModf() {
        return 0;
    }

    /* ---------
    *  Autonomy (Hours, Weeks, Jumps ...)
    --------- */
    protected int time = 0;

    public int getAutonomy() {
        return this.time;
    }

    public void setAutonomy(int time) {
        this.time = time;
    }

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append("(").append(isOptiOn());
        if (isOptiOn()) sb.append(", Weight=").append(getWeight());
        if (isOptiOn()) sb.append(", Cost=").append(getCost());
        sb.append('}');
        return sb.toString();
    }
}
