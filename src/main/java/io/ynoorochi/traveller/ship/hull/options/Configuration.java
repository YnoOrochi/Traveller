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
    *  Constructor
    --------- */
    public Configuration(int size) {
        this.setHullSize(size);
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

    /* ---------
    *  is not standard?
    --------- */
    @Override
    public boolean isOptiOn() {
        return this.config != STRD;
    }
    
    /* ---------
    *  Define the basic cost of hull
    --------- */
    @Override
    public int getCost() {
        return this.config.getCost();
    }
    
    /* ---------
    *  Option Specific Cost Modifier
    --------- */
    @Override
    public double getCostModf() {
        return this.config.getCostModf();
    }

    /* Hull Points Modifier */
    @Override
    public double getHPModf() {
        return this.config.getHPModf();
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
        sb.append(this.getClass().getSimpleName());
        sb.append("(").append(config.getConfig());
        sb.append("/").append(isStreamlined());
        sb.append(", HPModf=").append(getHPModf());
        sb.append(", Cost=").append(getCost());
        sb.append(", CostModf=").append(getCostModf());
        sb.append(", Weight=").append(getWeight());
        sb.append('}');
        return sb.toString();
    }
}
