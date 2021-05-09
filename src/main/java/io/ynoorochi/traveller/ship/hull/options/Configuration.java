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
    public Configuration(int size) { this.setHullSize(size); }
    public Configuration(int size, HullConfiguration cfg) { 
        this.setHullSize(size); 
        setConfig(config);
    }

    /* ---------
    *  Specific Methods
    --------- */
    private HullConfiguration config = STRD;
    public HullConfiguration getConfig() { return config; }
    public void setConfig(HullConfiguration config) { this.config = config; }
    
    /* Streamlined ? */
    public Streamlined isStreamlined() { return this.config.getStrLined(); }

    /* ---------
    *  is not standard?
    --------- */
    @Override
    public boolean isOptiOn() { return this.config != STRD; }
    
    /* ---------
    *  Define the basic cost of hull
    --------- */
    @Override
    public double getCost() { return this.config.getCost(); }
    
    /* ---------
    *  Option Specific Cost Modifier
    --------- */
    @Override
    public double getCostModf() { return this.config.getCostModf(); }

    /* Hull Points Modifier */
    @Override
    public double getAttModf() { return this.config.getHPModf(); }
    
    /* ---------
    *  Tonnage Used by Option
    --------- */
    @Override
    public double getBaseWeight() { return (1 - this.config.getUseable()) * getHullSize(); }

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
        sb.append(this.getClass().getSimpleName());
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
