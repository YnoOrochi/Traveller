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
public class FuelProcessor extends Items {
    /* ---------
     *  Constructor
    --------- */
    public FuelProcessor() { setSize(0); }
    public FuelProcessor(int size) { setSize(size); }

    /* ---------
    *  Processor Size 
    *       per 20 ton / day
    --------- */
    public double getSize() { return getDblAtt(); }
    public void setSize(double size) { if (size >= 0) setDblAtt(size); }

    /* ---------
     *  is Option on?
    --------- */
    @Override
    public boolean isOptiOn() { return getSize() > 0; }

    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getBaseWeight() { return getSize(); }
    
    /* ---------
     *  Option Specific Cost
    --------- */
    @Override
    public double getBaseCost() { return 50000 * getSize(); }

    /* ---------
    *  Option Get Name
    --------- */
    public String getName() { return "Fuel Processor (per 20t day)"; }
}
