/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.hull.options;

import io.ynoorochi.traveller.ship.Items;
import io.ynoorochi.traveller.ship.hull.Definitions.CoatOptions;
import static io.ynoorochi.traveller.ship.hull.Definitions.CoatOptions.*;

/**
 *
 * @author PR3J
 */
public class Coating extends Items {

    /* ---------
    *  Coating Equipment
    --------- */
    private CoatOptions coat = NONE;
    public CoatOptions getCoat() { return coat; }
    public void setCoat(CoatOptions coat) { this.coat = coat; }

    /* ---------
    *  have special coating?
    --------- */
    @Override
    public boolean isOptiOn() { return this.coat != NONE; }
    
    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getTL() { return this.coat.getTl(); }
    
    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getBaseWeight() { return 0; }

    /* ---------
    *  Option Cost
    --------- */
    @Override
    public double getBaseCost() { return this.coat.getCost(); }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append("(").append(this.coat.getType());
        if (getTL() != 0) sb.append(", TL=").append(getTL());
        if (getCost() != 0) sb.append(", Cost=").append(getCost());
        sb.append('}');
        return sb.toString();
    }
}
