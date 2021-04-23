/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.sensors;

import io.ynoorochi.traveller.ship.Items;
import io.ynoorochi.traveller.ship.sensors.Definitions.SignalProcessing;
import static io.ynoorochi.traveller.ship.sensors.Definitions.SignalProcessing.*;

/**
 *
 * @author PR3J
 */
public class SignalProcess extends Items {
    /* ---------
    *  type
    --------- */
    private SignalProcessing type = Basic;
    
    public SignalProcessing getType () {
        return this.type;
    }
    
    public void setType(SignalProcessing type) {
        this.type = type;
        super.setOptiOn(type != Basic);
    }

    /* ---------
    *  setOptiOn
    --------- */
    @Override
    public boolean setOptiOn(boolean opt) {
        setType(Basic);
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
        sb.append(this.getClass().getSimpleName()).append("{").append(getType());
        if (isOptiOn()) {
            sb.append(", TL=").append(getTL());
            sb.append(", Cost=").append(getCost());
            sb.append(", Weight=").append(getWeight());
            sb.append(", Power=").append(getPower());
            if (isHardened()) sb.append(", Hardened");
        }
        sb.append(", DM=").append(type.getDM());
        sb.append('}');
        return sb.toString();
    }
}
