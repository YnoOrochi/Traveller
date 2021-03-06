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
public class LaunchTubes extends Items {
    /* ---------
     *  Constructor
    --------- */
    public LaunchTubes(int qtty, int weight) { 
        setQtty(qtty);
        setCraftSize(weight);
    }
    
    /* ---------
     *  Craft size allowed
    --------- */
    public double getCraftSize() { return getDblAtt(); }
    public void setCraftSize(double cSize) { setDblAtt(cSize); }
    
    /* ---------
     *  Number of tubes
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
    public int getTL() { return 9; }

    /* ---------
    *  Power used
    --------- */
    @Override
    public double getPower() { return getWeight(); }

    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getBaseWeight() { return 10 * getQtty() * getCraftSize(); }
    
    /* ---------
     *  Option Specific Cost
    --------- */
    @Override
    public double getBaseCost() { return getQtty() * 500000; }

    /* ---------
    *  Name
    --------- */
    @Override
    public String getName() { return "Launch Tubes"; }
}
