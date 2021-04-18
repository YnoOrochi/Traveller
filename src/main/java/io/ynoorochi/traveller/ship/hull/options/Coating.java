/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.hull.options;

import io.ynoorochi.traveller.ship.hull.Definitions.CoatOptions;
import static io.ynoorochi.traveller.ship.hull.Definitions.CoatOptions.*;

/**
 *
 * @author PR3J
 */
public class Coating extends Options {

    /* ---------
    *  Coating Options
    --------- */
    private CoatOptions coat = NONE;

    public CoatOptions getCoat() {
        return coat;
    }

    public void setCoat(CoatOptions coat) {
        this.coat = coat;
    }

    /* ---------
    *  have special coating?
    --------- */
    @Override
    public boolean isOptiOn() {
        return this.coat != NONE;
    }
    
    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getTL() {
        return this.coat.getTl();
    }
    
    /* ---------
    *  Option Specific Cost
    --------- */
    @Override
    public int getCost() {
        return this.coat.getCost();
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Option(Coating=").append(this.coat.getType());
        if (getTL() != 0) sb.append(", TL=").append(getTL());
        if (getCost() != 0) sb.append(", Cost=").append(getCost());
        sb.append('}');
        return sb.toString();
    }
}
