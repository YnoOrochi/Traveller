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
public class NonGHull extends Options {
    
    /* ---------
    *  Non-gravity Hull maximum hullSize is 500,000 tons
    --------- */
    private final int NONG_MAX = 500000;

    /* ---------
    *  Option setter
    --------- */
    @Override
    public boolean setOption(boolean opt) {
        if (opt && getHullSize() > NONG_MAX) return this.option = false;
        
        this.option = opt;
        return true;
    }
    
    /* ---------
    *  Option Hull Cost Modifier (modf -0.5)
    *      basic cost from Cr50000 to Cr25000 per ton 
    *      problem: PLNT basic cost is Cr4000 per ton, then I used 2000 ...
    --------- */
    @Override
    public double getCostModf() {
        if (isOptiOn()) return -0.5;
        else return 0;
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Option(NonGHull=").append(isOptiOn());
        sb.append(", MAXTon=").append(NONG_MAX);
        if (getCostModf() != 0) sb.append(", CostModf=").append(getCostModf());
        sb.append('}');
        return sb.toString();
    }
}