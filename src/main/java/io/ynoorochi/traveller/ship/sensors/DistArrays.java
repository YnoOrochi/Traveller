/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.sensors;

import io.ynoorochi.traveller.ship.Items;
import io.ynoorochi.traveller.ship.sensors.Definitions.DistributedArrays;
import static io.ynoorochi.traveller.ship.sensors.Definitions.DistributedArrays.*;

/**
 *
 * @author PR3J
 */
public class DistArrays extends Items {

    /* ---------
    *  Constructor
    --------- */
    public DistArrays(int hullSize) {
        setHullSize(hullSize);
    }

    /* ---------
    *  type
    --------- */
    private DistributedArrays type = NONE;
    
    public DistributedArrays getType () {
        return this.type;
    }
    
    public void setType(DistributedArrays type) {
        if (getHullSize() >= 5000) this.type = type;
        else this.type = NONE;
        super.setOptiOn(this.type != NONE);
    }

    /* ---------
    *  setOptiOn
    --------- */
    @Override
    public boolean setOptiOn(boolean opt) {
        setType(NONE);
        return !opt;
    }

    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getTL() {
        return type.getTl();
    }
    /* ---------
    *  Power used
    --------- */
    @Override
    public double getPower() {
        return type.getPower();
    }

    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getWeight() {
        return type.getWeight();
    }

    /* ---------
     *  Option Specific Cost
    --------- */
    @Override
    public double getCost() {
        return (1 + getHardened()) * type.getCost();
    }

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append("{").append(getType().getName());
        if (isOptiOn()) {
            sb.append(", TL=").append(getTL());
            sb.append(", Cost=").append(getCost());
            sb.append(", Weight=").append(getWeight());
            sb.append(", Power=").append(getPower());
            if (isHardened()) sb.append(", Hardened");
        }
        sb.append('}');
        return sb.toString();
    }
}