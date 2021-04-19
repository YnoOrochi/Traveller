/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.hull.options;

import io.ynoorochi.traveller.ship.Items;
import static io.ynoorochi.traveller.ship.hull.Definitions.HullType;
import static io.ynoorochi.traveller.ship.hull.Definitions.HullType.*;

/**
 *
 * @author PR3J
 */
public class Type extends Items {

    /* ---------
    *  Type Equipment
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
    public double getAttModf() {
        return this.type.getHPModf();
    }
    
    /* ---------
    *  Option Specific Cost Modifier
    --------- */
    @Override
    public double getCostModf() {
        return this.type.getCostModf();
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append("(").append(type.getType());
        sb.append(", HPModf=").append(getAttModf());
        sb.append(", CostModf=").append(getCostModf());
        sb.append('}');
        return sb.toString();
    }
}
