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
public class RadShield extends Items {
    
    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getTL() { return isOptiOn() ? 7 : 0; }
    
    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getBaseWeight() { return 0; }

    /* ---------
    *  Option Cost
    --------- */
    @Override
    public double getBaseCost() { return isOptiOn() ? 25000 : 0; }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append("(").append(isOptiOn());
        if (getTL() != 0) sb.append(", TL=").append(getTL());
        if (getCost() != 0) sb.append(", Cost=").append(getCost());
        sb.append('}');
        return sb.toString();
    }
}
