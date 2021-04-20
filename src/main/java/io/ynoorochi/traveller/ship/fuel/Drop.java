/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.fuel;

import io.ynoorochi.traveller.ship.Items;

/**
 *
 * @author PR3J
 */
public class Drop extends Items {
    
    /* ---------
    *  Tank Size (ton)
    --------- */
    public double getSize() {
        return getAttribute();
    }
    
    public void setSize(double size) {
        setAttribute(size);
    }

    /* ---------
    *  is Option on?
    --------- */
    @Override
    public boolean isOptiOn() {
        return getSize() > 0;
    }

    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getWeight() {
        return getSize();
    }
    
    /* ---------
     *  Option Specific Cost
    --------- */
    @Override
    public double getCost() {
        return 500000 * getSize();
    }
}
