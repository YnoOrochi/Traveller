/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.fuel;

/**
 *
 * @author PR3J
 */
public class Drop extends FuelItems {
    /* ---------
     *  Constructor
    --------- */
    public Drop() { setSize(0); }
    public Drop(int size) { setSize(size); }
    
    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    protected double getBaseWeight() { return getSize(); }
    
    /* ---------
     *  Option Specific Cost
    --------- */
    @Override
    protected double getBaseCost() { return 500000 * getSize(); }
}
