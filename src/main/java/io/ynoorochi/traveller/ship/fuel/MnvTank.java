/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.fuel;

import io.ynoorochi.traveller.ship.equip.Definitions.*;

/**
 *
 * @author PR3J
 */
public class MnvTank extends Options {
    /* ---------
    *  Constructor
    --------- */
    public MnvTank(MDriveTypes type, int thrust, int hours, int hullSize) {
        this.setHullSize(hullSize);
        this.setDrive(type);
        this.setRating(thrust);
        this.setTime(hours);

        setOptiOn(true);
    }
 
    /* ---------
    *  Maneuver Fuel
    *       Maneuver drive does not use fuel.
    *       Reaction drive: 2.5% of ship tonnage per Thrust per hour
    --------- */
    @Override
    public int getWeight() {
        if (getDrive() == MDriveTypes.Reaction)
            return (int) Math.ceil(0.025 * getHullSize() * getRating() * getTime());
        else return 0;
    }
    
    public int getWeight(MDriveTypes type, int thrust, int hours, int hullSize) {
        this.setDrive(type);
        this.setRating(thrust);
        this.setHullSize(hullSize);
        this.setTime(hours);
        
        return getWeight();
    }

    /* ---------
    *  Total Combat Thrust Points
    *       In combat, it is convenient to multiply the Thrust the
    *       ship is capable of by the number of time it can operate,
    *       and then multiply that again by 10 to obtain a Thrust
    *       Point Total (10 combat rounds per hour).
    --------- */
    public int getThrustPoints() {
        if (getDrive() == MDriveTypes.Reaction) 
            return 10 * getRating() * getTime();
        else return 0;
    }

    /* ---------
    *  Drive type
    --------- */
    private MDriveTypes type;

    public MDriveTypes getDrive() {
        return this.type;
    }

    public void setDrive(MDriveTypes type) {
        this.type = type;
    }

    /* ---------
    *  is Option on?
    --------- */
    @Override
    public boolean isOptiOn() {
        return getRating() > 0;
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MnvTank{weight=").append(getWeight());
        if (getDrive() == MDriveTypes.Reaction) sb.append(", thrust=").append(getRating());
        if (getDrive() == MDriveTypes.Reaction) sb.append(" per ").append(getTime()).append("h");
        if (getDrive() == MDriveTypes.Reaction) sb.append(", CTP=").append(getThrustPoints());
        sb.append('}');
        return sb.toString();
    }
}
