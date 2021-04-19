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
public class HamsterCase extends Options {

    /* ---------
    *  Option setter
    --------- */
    public boolean setOption(int size) {
        if (size > 0) {
            this.hmsSize = size;
            return this.setOptiOn(true);
        } else {
            this.hmsSize = 0;
            this.setOptiOn(false);
            return false;
        }
    }
    
    /* ---------
    *  get Hamster Case Size
    --------- */
    private int hmsSize = 0;
    public int getHmsSize() {
        return this.hmsSize;
    }

    /* ---------
    *  Tonnage Used by Option
    *       uses 0.1 ton for every ton of outer hull.
    --------- */
    @Override
    public double getWeight() {
        if (isOptiOn()) return 0.1 * getHmsSize();
        else return 0;
    }
    
    /* ---------
    *  Option Hull Cost Modifier
    *       For each full percent of the total hull which is made part of
    *       the spun hull, the cost of the hull must be increased by +2% 
    --------- */
    @Override
    public double getCostModf() {
        if (isOptiOn()) return 2 * (int) (getHmsSize() / getHullSize());
        else return 0;
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append("(").append(isOptiOn());
        if (getHmsSize() != 0) sb.append(", Size=").append(getHmsSize());
        if (getWeight() != 0) sb.append(", Weight=").append(getWeight());
        if (getCostModf() != 0) sb.append(", CostModf=").append(getCostModf());
        sb.append('}');
        return sb.toString();
    }
}
