/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.sensors;

import io.ynoorochi.traveller.ship.Items;

/**
 *
 * @author PR3J
 */
public class DeepPenetration extends Items {
    
    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getWeight() {
        return getAttribute();
    }
    
    public void setWeight(double tonnage) {
        setAttribute(tonnage);
        super.setOptiOn(tonnage > 0);
    }

    /* ---------
    *  OptiOn
    --------- */
    @Override
    public boolean setOptiOn(boolean opt) {
        setAttribute(opt ? 1 : 0);
        return true;
    }

    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getTL() {
        if (isOptiOn()) return 13;
        else return 0;
    }
    /* ---------
    *  Power used
    --------- */
    @Override
    public double getPower() {
        if (isOptiOn()) return 1;
        else return 0;
    }

    /* ---------
     *  Option Specific Cost
    --------- */
    @Override
    public double getCost() {
        return getHardened() * 1000000 * getWeight();
    }

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append("{").append(isOptiOn());
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
