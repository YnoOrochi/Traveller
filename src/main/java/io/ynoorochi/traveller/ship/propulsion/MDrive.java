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
        this.setMDriveType(type);
        this.setMDriveRating(rating);
    }

    /* ---------
    *  mDriveType
    --------- */
    private MDriveTypes mDriveType = MDriveTypes.Maneuver;
    
    public MDriveTypes getMDriveType () {
        return this.mDriveType;
    }
    
    public boolean setMDriveType(MDriveTypes type) {
        this.mDriveType = type;
        setMDriveRating(this.mDriveRating);
        return true;
    }

    /* ---------
    *  MDriveRating
    --------- */
    private int mDriveRating = 0;

    public int getMDriveRating() {
        return this.mDriveRating;
    }

    public boolean setMDriveRating(int rating) {
        if (rating > 0)
            if (rating <= mDriveType.getMDriveMax()) {
                this.mDriveRating = rating;
                return true;
            } else {
                this.mDriveRating = mDriveType.getMDriveMax();
                return false;
            }
        else {
            mDriveRating = 0;
            return false;
        }
    }

    /* ---------
    *  MDriveCost
    --------- */
    public double getMDriveCost(int hullSize) {
        return hullSize * getMDriveCost();
    }
    
    public double getMDriveCost() {
        return mDriveType.getMDriveCost();
    }

    /* ---------
    *  MDriveTL
    --------- */
    public int getMDriveTL(int rating) {
        return mDriveType.getMDriveTL(rating);
    }
    
    /* ---------
    *  MDriveWeight
    --------- */
    public double getMDriveWeight(int hullSize) {
        return hullSize * getMDriveWeight();
    }
    
    public double getMDriveWeight() {
        switch(mDriveType) {
            case Maneuver:
                if (mDriveRating == 0) return 0.005;
                else return mDriveRating / 100;
            case Reaction:
                return 2 * mDriveRating / 100;
            default: return 0;
        }
    }

    /* ---------
    *  MDriveWeight
    --------- */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MDrive{Type=").append(mDriveType);
        sb.append(", Rating=").append(mDriveRating);
        sb.append(", TL=").append(getMDriveTL(mDriveRating));
        sb.append('}');
        return sb.toString();
    }
}
