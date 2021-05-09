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
    public SignalProcessing getType () { return this.type; }
    public void setType(SignalProcessing type) {
        this.type = type;
        super.setOptiOn(type != Basic);
    }

    /* ---------
    *  setOptiOn
    --------- */
    @Override
    public void setOptiOn(boolean opt) { setType(Basic); }

    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getTL() { return type.getTl(); }

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

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append("{").append(getType());
        if (isOptiOn()) {
            if (getTL() > 0) sb.append(", TL=").append(getTL());
            sb.append(", Weight=").append(getWeight());
            if (getPower() > 0) sb.append(", Power=").append(getPower());
            sb.append(", Cost=").append(getCost());
            if (isHardened()) sb.append(", Hardened");
            if (isArmoured()) sb.append(", Armoured Bulkheaded");
        }
        sb.append(", DM=").append(type.getDM());
        sb.append('}');
        return sb.toString();
    }
}
