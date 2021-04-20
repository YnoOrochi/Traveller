/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.equip;

import io.ynoorochi.traveller.ship.Items;
import io.ynoorochi.traveller.ship.equip.Definitions.MDriveTypes;

/**
 *
 * @author PR3J
 */
public class MDrive extends Items {

    /* ---------
     *  Constructor
    --------- */
    public MDrive(MDriveTypes type, int rating, int size) {
        this.setType(type);
        this.setRating(rating);
        this.setHullSize(size);
    }

    /* ---------
    *  type
    --------- */
    private MDriveTypes type = MDriveTypes.Maneuver;
    
    public MDriveTypes getType () {
        return this.type;
    }
    
    public boolean setType(MDriveTypes type) {
        this.type = type;
        setRating(getRating());
        return true;
    }

    /* ---------
    *  MDriveRating
    *           10% of the hull’s total tonnage multiplied by the
    *       maximum Thrust the drive is capable of (multiply by
    *       0.25 if the ship is capable only of Thrust 0)
    --------- */
    @Override
    public double getPower() {
        switch (getType()) {
            case Maneuver:
                return 0.1 * Math.max(0.25, getRating()) * getHullSize();
            default: return 0;
        }
    }
    
    /* ---------
    *  MDriveRating
    --------- */
    public double getRating() {
        return getAttribute();
    }
    
    public boolean setRating(double rating) {
        if (rating > 0)
            if (rating <= getType().getMax()) {
                setAttribute(rating);
                return true;
            } else {
                setAttribute(getType().getMax());
                return false;
            }
        else {
            setAttribute(0);
            return false;
        }
    }

        /* ---------
    *  MDriveCost
    --------- */
    @Override
    public double getCost() {
        return getType().getCost() * getHullSize();
    }

    /* ---------
    *  MDriveTL
    --------- */
    @Override
    public int getTL() {
        return getType().getTL((int) Math.ceil(getRating()));
    }
    
    /* ---------
    *  MDriveWeight
    --------- */
    @Override
    public double getWeight() {
        switch(getType()) {
            case Maneuver:
                if (getRating() == 0) return 0.005 * getHullSize();
                else return getRating() * getHullSize() / 100;
            case Reaction:
                return 2 * getRating() * getHullSize() / 100;
            default: return 0;
        }
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MDrive{").append(getType());
        sb.append(" ").append(getRating());
        sb.append(", HullSize=").append(getHullSize());
        sb.append(", Cost=").append(getCost());
        sb.append(", Pwr=").append(getPower());
        sb.append(", TL=").append(getTL());
        sb.append(", Weight=").append(getWeight());
        sb.append('}');
        return sb.toString();
    }
}
