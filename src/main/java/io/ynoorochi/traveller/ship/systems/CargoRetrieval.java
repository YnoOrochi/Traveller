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
public class CargoRetrieval extends Items {
    /* ---------
     *  Constructor
    --------- */
    public CargoRetrieval() { setOptiOn(true); }

    /* ---------
     *  Tech Level
    --------- */
    @Override
    public int getTL() { return 7; }

    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getWeight() { return 5; }

    /* ---------
     *  Option Specific Cost
    --------- */
    @Override
    public double getCost() { return 1000000; }

    /* ---------
     *  Option Name
    --------- */
    @Override
    public String getName() { return "Cargo Retrieval Net"; }

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
