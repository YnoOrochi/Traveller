/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveller.hull.options;

import traveller.hull.Definitions;
import static traveller.hull.Definitions.HullConfiguration.*;
import traveller.hull.Definitions.Streamlined;

/**
 *
 * @author PR3J
 */
public class Configuration extends Options {
    
    /* ---------
    *  Option constructor
    --------- */
    public Configuration(int size) {
        super(size);
    }
    
    /* ---------
    *  Type Options
    --------- */
    private Definitions.HullConfiguration config = STRD;

    public Definitions.HullConfiguration getConfig() {
        return config;
    }

    public void setConfig(Definitions.HullConfiguration config) {
        this.config = config;
    }

    /* ---------
    *  is not standard?
    --------- */
    @Override
    public boolean isOption() {
        return this.config != STRD;
    }
    
    /* ---------
    *  Streamlined ?
    --------- */
    public Streamlined isStreamlined() {
        return this.config.getStrLined();
    }

    /* ---------
    *  Hull Points Modifier
    --------- */
    public double getHPModf() {
        return this.config.getHPModf();
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
        return (1 - this.config.getUseable()) * optHullSize;
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
