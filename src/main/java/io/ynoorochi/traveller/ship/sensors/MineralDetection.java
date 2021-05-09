/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.sensors;

import io.ynoorochi.traveller.ship.Items;

/**
 *
 * @author PR3J
 */
public class MineralDetection extends Items {
    /* ---------
    *  Tech Level  7 
    --------- */
    @Override
    public int getTL() { return (isOptiOn() ? 7 : 0); }

    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getBaseWeight() { return 0; }

    /* ---------
    *  Option Specific Cost 5000000
    *       does not allow hardening
    --------- */
    @Override
    public double getBaseCost() { return (isOptiOn() ? 5000000 : 0); }
}
