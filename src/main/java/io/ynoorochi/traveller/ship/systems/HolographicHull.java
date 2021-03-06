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
public class HolographicHull extends Items {
    /* ---------
     *  Constructor
    --------- */
    public HolographicHull(int hullSize) { 
        setHullSize(hullSize); 
        setOptiOn(true);
    }
    
    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getTL() { return 10; }

    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getBaseWeight() { return 0; }

    /* ---------
    *  Power used
    --------- */
    @Override
    public double getPower() { return 100; }

    /* ---------
     *  Option Specific Cost
    --------- */
    @Override
    public double getBaseCost() { return 100000 * getHullSize(); }

    /* ---------
    *  Option Get Name
    --------- */
    @Override
    public String getName() { return "Holographic Hull"; }
}
