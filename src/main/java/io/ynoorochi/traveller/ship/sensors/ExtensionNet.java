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
public class ExtensionNet extends Items {

    /* ---------
    *  Constructor
    --------- */
    public ExtensionNet(int hullSize) {
        setHullSize(hullSize);
    }
    
    /* ---------
    *  Tech Level  10 
    --------- */
    @Override
    public int getTL() { return (isOptiOn() ? 10 : 0); }

    /* ---------
    *  Tonnage Used by Option
    *       size / 100 round down
    --------- */
    @Override
    public double getWeight() { return (isOptiOn() ? 0.01 * getHullSize() : 0); }
    
    /* ---------
    *  Option Specific Cost 5000000
    *       does not allow hardening
    --------- */
    @Override
    public double getCost() { return (isOptiOn() ? 1000000 * getWeight() : 0); }

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
        }
        sb.append('}');
        return sb.toString();
    }
}
