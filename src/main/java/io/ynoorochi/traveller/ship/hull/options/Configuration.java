/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.hull.options;

import io.ynoorochi.traveller.ship.hull.Definitions;
import io.ynoorochi.traveller.ship.hull.Definitions.HullConfiguration;
import static io.ynoorochi.traveller.ship.hull.Definitions.HullConfiguration.*;
import io.ynoorochi.traveller.ship.hull.Definitions.Streamlined;

/**
 *
 * @author PR3J
 */
public class Configuration extends Options {
    
    /* ---------
    *  Hull Size
    --------- */
    public int getHullSize() {
        return Options.hullSize;
    }
    
    public int setHullSize(int size) {
        return Options.hullSize = Math.max(size, MIN_HULL);
    }

    /* ---------
    *  Specific Methods
    --------- */
    private HullConfiguration config = STRD;

    public HullConfiguration getConfig() {
        return config;
    }

    public void setConfig(HullConfiguration config) {
        this.config = config;
    }
    
    /* Streamlined ? */
    public Streamlined isStreamlined() {
        return this.config.getStrLined();
    }

    /* Hull Points Modifier */
    @Override
    public double getHPModf() {
        return this.config.getHPModf();
    }
    
    /* ---------
    *  is not standard?
    --------- */
    @Override
    public boolean isOptiOn() {
        return this.config != STRD;
    }
    
    /* ---------
    *  Option Specific Cost Modifier
    --------- */
    @Override
    public double getOptCostModf() {
        return this.config.getCostModf();
    }

    /* ---------
    *  Define the basic cost of hull
    --------- */
    public int getHullCost() {
        return this.config.getHullCost();
    }
    
    /* ---------
    *  Tonnage Used by Option
    --------- */
    @Override
    public double getOptUsedTon() {
        return (1 - this.config.getUseable()) * Options.hullSize;
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Option(HullConf=").append(config.getConfig());
        sb.append(", ").append(isStreamlined());
        sb.append(", HPModf=").append(getHPModf());
        sb.append(", CostModf=").append(getOptCostModf());
        sb.append(", HullCost=").append(getHullCost());
        sb.append(", UsedTon=").append(getOptUsedTon());
        sb.append('}');
        return sb.toString();
    }
}
