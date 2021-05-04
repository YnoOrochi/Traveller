/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.systems;

import io.ynoorochi.traveller.ship.Items;

/**
 *
 * @author PR3J
 */
public class BreachTube extends Items {
    /* ---------
     *  Constructor
    --------- */
    public BreachTube() { setOptiOn(true); }
    
    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getTL() { return 7; }

    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getWeight() { return 3; }
    
    /* ---------
     *  Option Specific Cost
    --------- */
    @Override
    public double getCost() { return 3000000; }

    /* ---------
     *  Option Name
    --------- */
    @Override
    public String getName() { return "Breaching Tube"; }

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append("{").append(isOptiOn());
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
