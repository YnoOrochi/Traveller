/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.hull.options;

/**
 *
 * @author PR3J
 */
public abstract class Options {

    /* ---------
    *  Atributes
    --------- */
    protected final int MIN_HULL = 10;
    
    protected static int hullSize;
    protected boolean option = false;

    /* ---------
    *  Option setter
    *      returns the operation result
    *      false means: the option has some constraint that was not observed
    --------- */
    public boolean setOption(boolean opt) {
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
    public int getHullSize() {
        return this.hullSize;
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
    *  Tonnage Used by Option
    --------- */
    public double getWeight() {
        return 0;
    }

    /* ---------
    *  Option Specific Cost
    --------- */
    public int getCost() {
        return 0;
    }

    /* ---------
    *  Option Hull Cost Modifier
    --------- */
    public double getCostModf() {
        return 0;
    }

    /* ---------
    * Hull Points Modifier
    --------- */
    public double getHPModf() {
        return 0;
    }

    /* ---------
    *  basic toString
    --------- */
    @Override
    public String toString() {
        return "Options{" + "size=" + hullSize + ", option=" + option + '}';
    }

}
