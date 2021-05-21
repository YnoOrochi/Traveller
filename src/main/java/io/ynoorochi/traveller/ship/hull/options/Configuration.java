/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.hull.options;

import io.ynoorochi.traveller.ship.Items;
import io.ynoorochi.traveller.ship.hull.Definitions.*;
import static io.ynoorochi.traveller.ship.hull.Definitions.HullConfiguration.*;
import io.ynoorochi.traveller.ship.hull.Definitions.Streamlined;

/**
 *
 * @author PR3J
 */
public class Configuration extends Items {
    /* ---------
    *  Constructor
    --------- */
    public Configuration(int size) { this(size, HullConfiguration.STRD); }
    public Configuration(int size, HullConfiguration config) { 
        setHullSize(size);
        setConfig(config);
    }

    /* ---------
    *  Specific Methods
    --------- */
    private HullConfiguration config;
    public HullConfiguration getConfig() { return this.config; }
    public void setConfig(HullConfiguration cfg) { this.config = cfg; }
    
    /* Streamlined ? */
    public Streamlined isStreamlined() { return this.config.getStrLined(); }

    /* ---------
    *  is not standard?
    --------- */
    @Override
    public boolean isOptiOn() { return getConfig() != STRD; }
    
    /* ---------
    *  Define the basic cost of hull
    --------- */
    @Override
    public double getCost() { return getConfig().getCost(); }
    
    /* ---------
    *  Option Specific Cost Modifier
    --------- */
    @Override
    public double getCostModf() { return getConfig().getCostModf(); }

    /* Hull Points Modifier */
    @Override
    public double getAttModf() { return getConfig().getHPModf(); }
    
    /* ---------
    *  Tonnage Used by Option
    --------- */
    @Override
    public double getBaseWeight() { return (1 - getConfig().getUseable()) * getHullSize(); }

    /* ---------
    *  Option Cost
    --------- */
    @Override
    public double getBaseCost() { return 0; }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append("(").append(config.getConfig());
        sb.append("/").append(isStreamlined());
        sb.append(", HPModf=").append(getAttModf());
        sb.append(", Cost=").append(getCost());
        sb.append(", CostModf=").append(getCostModf());
        sb.append(", Weight=").append(getWeight());
        sb.append('}');
        return sb.toString();
    }
}
