/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.hull.options;

import io.ynoorochi.traveller.ship.Items;

/**
 *
 * @author PR3J
 */
public class EAGrid extends Items {

    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getTL() { return isOptiOn() ? 8 : 0; }
    
    /* ---------
    *  Tonnage Used by Option
    --------- */
    @Override
    public double getBaseWeight() { return isOptiOn() ? 0.02 * getHullSize() : 0; }
    
    /* ---------
    *  Option Specific Cost
    --------- */
    @Override
    public double getBaseCost() { return isOptiOn() ? 40000 : 0; }
}
