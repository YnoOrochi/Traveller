/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.sensors;

import io.ynoorochi.traveller.ship.Definitions.Hardened;
import io.ynoorochi.traveller.ship.Items;
import io.ynoorochi.traveller.ship.sensors.Definitions.SensorTypes;
import static io.ynoorochi.traveller.ship.sensors.Definitions.SensorTypes.*;

/**
 *
 * @author PR3J
 */
public class Base extends Items {
    /* ---------
    *  Constructor
    --------- */
    public Base() {
        setOptiOn(true);
    }
    
    /* ---------
    *  type
    --------- */
    private SensorTypes type = Basic;
    
    public SensorTypes getType () {
        return this.type;
    }
    
    public void setType(SensorTypes type) {
        this.type = type;
        super.setOptiOn(type != Basic);
    }

    /* ---------
    *  setOptiOn
    --------- */
    @Override
    public boolean setOptiOn(boolean opt) {
        setType(Basic);
        return true;
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
            sb.append(", TL=").append(getWeight());
            sb.append(", Cost=").append(getCost());
            sb.append(", Weight=").append(getWeight());
            sb.append(", Power=").append(getPower());
            if (isHardened()) sb.append(", Hardened");
        }
        sb.append(", DM=").append(type.getDmModf());
        sb.append(", Type=").append(type.getEquips());
        sb.append('}');
        return sb.toString();
    }
}
