/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.sensors;

import io.ynoorochi.traveller.ship.Items;
import io.ynoorochi.traveller.ship.sensors.Definitions.CountermSuits;
import static io.ynoorochi.traveller.ship.sensors.Definitions.CountermSuits.*;

/**
 *
 * @author PR3J
 */
public class Countermeasures extends Items {
    /* ---------
    *  type
    --------- */
    private CountermSuits type = NONE;
    
    public CountermSuits getType () {
        return this.type;
    }
    
    public void setType(CountermSuits type) {
        this.type = type;
        setOptiOn(type != NONE);
    }

    /* ---------
    *  setOptiOn
    --------- */
    @Override
    public void setOptiOn(boolean opt) { setType(NONE); }

    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getTL() { return type.getTL(); }

    /* ---------
    *  Power used
    --------- */
    @Override
    public double getPower() { return type.getPower(); }

    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getBaseWeight() { return type.getWeight(); }

    /* ---------
     *  Option Specific Cost
    --------- */
    @Override
    public double getBaseCost() { return type.getCost(); }
}
