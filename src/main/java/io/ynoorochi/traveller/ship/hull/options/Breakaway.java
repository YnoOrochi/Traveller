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
public class Breakaway extends Items {
    private final double WHT = 0.02;          // 2%
    
    /* ---------
    *  Option Specific Cost
    *       costs an additional MCr2 per ton consumed
    --------- */
    @Override
    public double getBaseCost() {
        if (isOptiOn()) return WHT * 2000000; // * hullSize 
        else return 0;
    }

    /* ---------
    *  Tonnage Used by Option
    *       consumes 2% of the combined hull tonnage.
    --------- */
    @Override
    public double getBaseWeight() {
        if (isOptiOn()) return WHT * getHullSize();
        else return 0;
    }
}
