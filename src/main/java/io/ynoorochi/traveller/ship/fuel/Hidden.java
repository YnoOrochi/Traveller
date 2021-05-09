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
public class Hidden extends FuelItems {
    /* ---------
     *  Constructor
    --------- */
    public Hidden() { setSize(0); }
    public Hidden(int size) { setSize(size); }
    
    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    protected double getBaseWeight() { return 0; }
    
    /* ---------
     *  Fuel Tank Cost
    --------- */
    @Override
    protected double getBaseCost() { return 40000 * getSize(); }
}
