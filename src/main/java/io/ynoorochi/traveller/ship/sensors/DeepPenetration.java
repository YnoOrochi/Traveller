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
public class DeepPenetration extends Items {
    
    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getBaseWeight() { return getDblAtt(); }
    public void setSize(double tonnage) {
        setDblAtt(tonnage);
        super.setOptiOn(tonnage > 0);
    }

    /* ---------
    *  OptiOn
    --------- */
    @Override
    public void setOptiOn(boolean opt) { setSize(opt ? 1 : 0); }

    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getTL() { return isOptiOn()? 13 : 0; }

    /* ---------
    *  Power used
    --------- */
    @Override
    public double getPower() { return isOptiOn()? 1 : 0; }

    /* ---------
     *  Option Specific Cost
    --------- */
    @Override
    public double getBaseCost() { return 1000000 * getWeight(); }
}
