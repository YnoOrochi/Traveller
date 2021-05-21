/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.systems;

import io.ynoorochi.traveller.ship.Items;
import io.ynoorochi.traveller.ship.hull.Definitions.HullConfiguration;

/**
 *
 * @author PR3J
 */
public class FuelScoop extends Items {

    public FuelScoop(HullConfiguration config) {
        setStreamlined(config);
        setOptiOn(true);
    }

    /* ---------
     *  is it streamlined?
    --------- */
    private boolean streamlined = false;
    public boolean isStreamlined() { return this.streamlined; }
    public void setStreamlined(HullConfiguration config) { 
        streamlined = config.equals(HullConfiguration.SLND);
    }

    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getBaseWeight() { return 0; }

    /* ---------
     *  Option Specific Cost
    --------- */
    @Override
    public double getBaseCost() { return !isStreamlined() ? 1000000 : 0; }

    /* ---------
    *  Option Get Name
    --------- */
    @Override
    public String getName() { return "Fuel Scoop"; }
}
