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
public class TowCable extends Items {
    /* ---------
     *  Constructor
    --------- */
    public TowCable(int hullSize) { 
        setHullSize(hullSize); 
        setOptiOn(true);
    }
    
    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getTL() { return 7; }

    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getBaseWeight() { return 0.01 * getHullSize(); }
    
    /* ---------
     *  Option Specific Cost
    --------- */
    @Override
    public double getBaseCost() { return 5000 * getWeight(); }

    /* ---------
     *  Option Name
    --------- */
    @Override
    public String getName() { return "Tow Cable"; }
}
