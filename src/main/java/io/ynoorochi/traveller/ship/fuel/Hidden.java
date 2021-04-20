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
public class Hidden extends Items {
    /* ---------
    *  Set Hidden Tonnage
    --------- */
    @Override
    public double getWeight() {
        return getAttribute();
    }
    
    public void setWeight(double tonnage) {
        setAttribute(tonnage);
        setOptiOn(tonnage > 0);
    }

    /* ---------
     *  Fuel Tank Cost
    --------- */
    @Override
    public double getCost() {
        return 40000 * getAttribute();
    }
}
