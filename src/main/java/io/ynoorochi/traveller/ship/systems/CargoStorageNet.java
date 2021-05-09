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
public class CargoStorageNet extends Items {
    /* ---------
     *  Constructor
    --------- */
    public CargoStorageNet(int qtty) { setQtty(qtty); }

    /* ---------
     *  Number of tonnage
    --------- */
    public int getQtty() { return getIntAtt(); }
    public void setQtty(int qtty) { setIntAtt(qtty); }

    /* ---------
     * is Option on?
    --------- */
    @Override
    public boolean isOptiOn() { return (getQtty() > 0); }

    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getTL() { return 8; }

    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getBaseWeight() { return getQtty(); }
    
    /* ---------
     *  Option Specific Cost
    --------- */
    @Override
    public double getBaseCost() { return 100000 * getQtty(); }

    /* ---------
     *  Option Name
    --------- */
    @Override
    public String getName() { return "Cargo Storage Net (per 100t)"; }
}
