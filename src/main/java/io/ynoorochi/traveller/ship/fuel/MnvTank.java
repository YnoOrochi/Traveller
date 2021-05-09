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
public class MnvTank extends FuelItems {
    /* ---------
    *  Constructor
    --------- */
    public MnvTank(MDriveTypes type, double thrust, int hours, int hullSize) {
        this.setHullSize(hullSize);
        this.setDrive(type);
        this.setThrust(thrust);
        this.setAutonomy(hours);

        setOptiOn(true);
    }

    /* ---------
    *  JDrive Rating
    --------- */
    public double getThrust() { return getDblAtt(); }
    public void setThrust(double thrust) { setDblAtt(thrust >= 0 ? thrust : 0); }

    /* ---------
    *  Autonomy
    --------- */
    public int getAutonomy() { return getIntAtt(); }
    public void setAutonomy(int hours) { setIntAtt(hours >= 0 ? hours : 0); }

    /* ---------
     *  Tank Size (ton)
    --------- */
    @Override
    public int getSize() { 
        return (int) getBaseWeight(getDrive(), getThrust(), getAutonomy(), getHullSize());
    }

    @Override
    public void setSize(int size) { }

    /* ---------
    *  Maneuver Fuel
    *       Maneuver drive does not use fuel.
    *       Reaction drive: 2.5% of ship tonnage per Thrust per hour
    --------- */
    @Override
    public double getBaseWeight() {
        if (getDrive() == MDriveTypes.Reaction)
            return Math.ceil(0.025 * getThrust() * getAutonomy() * getHullSize());
        else return 0;
    }

    protected double getBaseWeight(MDriveTypes type, double thrust, int hours, int hullSize) {
        this.setDrive(type);
        this.setThrust(thrust);
        this.setHullSize(hullSize);
        this.setAutonomy(hours);

        return getBaseWeight();
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
            return (int) Math.floor(10 * getThrust() * getAutonomy());
        else return 0;
    }

    /* ---------
    *  Drive type
    --------- */
    private MDriveTypes type;
    public MDriveTypes getDrive() { return this.type; }
    public void setDrive(MDriveTypes type) { this.type = type; }

    /* ---------
    *  is Option on?
    --------- */
    @Override
    public boolean isOptiOn() { return getThrust() > 0; }

    /* ---------
     *  Fuel Tank Cost
    --------- */
    @Override
    protected double getBaseCost() { return 0; }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MnvTank{Size=").append(getSize());
        if (getDrive() == MDriveTypes.Reaction) sb.append(", weight=").append(getWeight());
        if (getDrive() == MDriveTypes.Reaction) sb.append(", thrust=").append(getThrust());
        if (getDrive() == MDriveTypes.Reaction) sb.append(" per ").append(getAutonomy()).append("h");
        if (getDrive() == MDriveTypes.Reaction) sb.append(", CTP=").append(getThrustPoints());
        if (isArmoured()) sb.append(", Armoured Bulkheaded");
        sb.append('}');
        return sb.toString();
    }
}
