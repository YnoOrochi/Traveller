/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.hull.options;

import io.ynoorochi.traveller.ship.hull.Definitions.*;
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
    public boolean setHullSize(int size) {
        Options.hullSize = Math.max(size, MIN_HULL);
        return (getHullSize() == size);
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
    public double getCostModf() {
        return this.config.getCostModf();
    }

    /* ---------
    *  Define the basic cost of hull
    --------- */
    public int getHullCost() {
        return this.config.getCost();
    }
    
    /* ---------
    *  Tonnage Used by Option
    --------- */
    @Override
    public double getWeight() {
        return (1 - this.config.getUseable()) * getHullSize();
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Option(HullConf=").append(config.getConfig());
        sb.append("/").append(isStreamlined());
        sb.append(", HPModf=").append(getHPModf());
        sb.append(", CostModf=").append(getCostModf());
        sb.append(", HullCost=").append(getHullCost());
        sb.append(", UsedTon=").append(getWeight());
        sb.append('}');
        return sb.toString();
    }
}
