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
    public void setOption(int size) {
        if (size > 0) {
            setDblAtt(size);
            setOptiOn(true);
        } else {
            setDblAtt(0);
            setOptiOn(false);
        }
    }
    
    /* ---------
    *  Tonnage Used by Option
    *       uses 0.1 ton for every ton of outer hull.
    --------- */
    @Override
    public double getBaseWeight() {
        if (isOptiOn()) return 0.1 * getDblAtt();
        else return 0;
    }
    
    /* ---------
    *  Option Cost
    --------- */
    @Override
    public double getBaseCost() { return 0; }

    /* ---------
    *  Option Hull Cost Modifier
    *       For each full percent of the total hull which is made part of
    *       the spun hull, the cost of the hull must be increased by +2% 
    --------- */
    @Override
    public double getCostModf() {
        if (isOptiOn()) return 2 * (int) (getDblAtt() / getHullSize());
        else return 0;
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append("(").append(isOptiOn());
        if (getDblAtt() != 0) sb.append(", Size=").append(getDblAtt());
        if (getWeight() != 0) sb.append(", Weight=").append(getWeight());
        if (getCostModf() != 0) sb.append(", CostModf=").append(getCostModf());
        sb.append('}');
        return sb.toString();
    }
}
