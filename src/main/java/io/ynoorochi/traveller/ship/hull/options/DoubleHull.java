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
public class DoubleHull extends Items {
    
    /* ---------
    *  Minimum Double Hull hullSize is 60 tons
    *  Maximun is 90% of ship hull
    --------- */
    private final int MIN = 60;
    private final double MAX = 0.9;

    /* ---------
    *  Option setter
    --------- */
    public boolean setOption(int size) {
        if (size >= MIN && size <= MAX * getHullSize()) {
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
    *       the spun hull, the cost of the hull must be increased by +1% 
    --------- */
    @Override
    public double getCostModf() {
        if (isOptiOn()) return 1 * (int) (getAttribute() / getHullSize());
        else return 0;
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append("(").append(isOptiOn());
        if (getAttribute() != 0) sb.append(", OuterHull=").append(getAttribute());
        if (getWeight() != 0) sb.append(", Weight=").append(getWeight());
        if (getCostModf() != 0) sb.append(", Cost=").append(getCostModf());
        sb.append('}');
        return sb.toString();
    }
}
