/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.sensors;

import io.ynoorochi.traveller.ship.Items;

/**
 *
 * @author PR3J
 */
public class ShallowSuite extends Items {
    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getTL() { return (isOptiOn() ? 10 : 0); }

    /* ---------
    *  Power used
    --------- */
    @Override
    public double getPower() { return (isOptiOn() ? 1 : 0); }

    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getWeight() { return (isOptiOn() ? 10 : 0); }

    /* ---------
     *  Option Specific Cost
    --------- */
    @Override
    public double getCost() { return (isOptiOn() ? (1 + getHardened()) * 5000000 : 0); }

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append("{").append(isOptiOn());
        if (isOptiOn()) {
            sb.append(", TL=").append(getTL());
            sb.append(", Cost=").append(getCost());
            sb.append(", Weight=").append(getWeight());
            sb.append(", Power=").append(getPower());
            if (isHardened()) sb.append(", Hardened");
        }
        sb.append('}');
        return sb.toString();
    }
}
