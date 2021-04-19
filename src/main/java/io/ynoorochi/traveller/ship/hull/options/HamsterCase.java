/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.hull.options;

import io.ynoorochi.traveller.ship.Items;

/**
 *
 * @author PR3J
 */
public class HamsterCase extends Items {

    /* ---------
    *  Option setter
    --------- */
    public boolean setOption(int size) {
        if (size > 0) {
            setAttribute(size);
            return setOptiOn(true);
        } else {
            setAttribute(0);
            setOptiOn(false);
            return false;
        }
    }
    
    /* ---------
    *  Tonnage Used by Option
    *       uses 0.1 ton for every ton of outer hull.
    --------- */
    @Override
    public double getWeight() {
        if (isOptiOn()) return 0.1 * getAttribute();
        else return 0;
    }
    
    /* ---------
    *  Option Hull Cost Modifier
    *       For each full percent of the total hull which is made part of
    *       the spun hull, the cost of the hull must be increased by +2% 
    --------- */
    @Override
    public double getCostModf() {
        if (isOptiOn()) return 2 * (int) (getAttribute() / getHullSize());
        else return 0;
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append("(").append(isOptiOn());
        if (getAttribute() != 0) sb.append(", Size=").append(getAttribute());
        if (getWeight() != 0) sb.append(", Weight=").append(getWeight());
        if (getCostModf() != 0) sb.append(", CostModf=").append(getCostModf());
        sb.append('}');
        return sb.toString();
    }
}
