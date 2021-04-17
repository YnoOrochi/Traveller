/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.propulsion;

import io.ynoorochi.traveller.ship.propulsion.DriveTypes.MDriveTypes;

/**
 *
 * @author PR3J
 */
public class MDrive {

    /* ---------
     *  Constructor
    --------- */
    public MDrive(MDriveTypes type, int rating) {
        this.setType(type);
        this.setRating(rating);
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
        setRating(this.rating);
        return true;
    }

    /* ---------
    *  MDriveRating
    *           10% of the hull’s total tonnage multiplied by the
    *       maximum Thrust the drive is capable of (multiply by
    *       0.25 if the ship is capable only of Thrust 0)
    --------- */
    public double getPower() {
        switch (getType()) {
            case Maneuver:
                return 0.1 * Math.max(0.25, getRating());
            default: return 0;
        }
    }
    
    public double getPower(int hullSize) {
        return this.getPower() * hullSize;
    }
    
    /* ---------
    *  MDriveRating
    --------- */
    private int rating = 0;

    public int getRating() {
        return this.rating;
    }

    public boolean setRating(int rating) {
        if (rating > 0)
            if (rating <= type.getMax()) {
                this.rating = rating;
                return true;
            } else {
                this.rating = type.getMax();
                return false;
            }
        else {
            this.rating = 0;
            return false;
        }
    }

    /* ---------
    *  MDriveCost
    --------- */
    public double getCost(int hullSize) {
        return hullSize * getCost();
    }
    
    public double getCost() {
        return type.getCost();
    }

    /* ---------
    *  MDriveTL
    --------- */
    public int getTL(int rating) {
        return type.getTL(rating);
    }
    
    /* ---------
    *  MDriveWeight
    --------- */
    public double getWeight(int hullSize) {
        return hullSize * getWeight();
    }
    
    public double getWeight() {
        switch(type) {
            case Maneuver:
                if (rating == 0) return 0.005;
                else return rating / 100;
            case Reaction:
                return 2 * rating / 100;
            default: return 0;
        }
    }

    /* ---------
    *  MDriveWeight
    --------- */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MDrive{Type=").append(type);
        sb.append(", Rating=").append(rating);
        sb.append(", TL=").append(getTL(rating));
        sb.append('}');
        return sb.toString();
    }
}
