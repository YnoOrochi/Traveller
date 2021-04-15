/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.hull.options;

import static io.ynoorochi.traveller.hull.Definitions.HullType;
import static io.ynoorochi.traveller.hull.Definitions.HullType.STRD;

/**
 *
 * @author PR3J
 */
public class Type extends Options {
    
    /* ---------
    *  Type Options
    --------- */
    private HullType type = STRD;

    public HullType getType() {
        return type;
    }

    public void setType(HullType type) {
        this.type = type;
    }
    
    /* ---------
    *  is not standard?
    --------- */
    @Override
    public boolean isOptiOn() {
        return this.type != STRD;
    }
    
    /* ---------
    *  Hull Points Modifier
    --------- */
    @Override
    public double getHPModf() {
        return this.type.getHPModf();
    }
    
    /* ---------
    *  Option Specific Cost Modifier
    --------- */
    @Override
    public double getOptCostModf() {
        return this.type.getCostModf();
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Option(HullType=").append(type.getType());
        sb.append(", HPModf=").append(getHPModf());
        sb.append(", CostModf=").append(getOptCostModf());
        sb.append('}');
        return sb.toString();
    }
}
