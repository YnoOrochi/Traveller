/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.propulsion;

/**
 *
 * @author PR3J
 */
public class MDrive {
    /* ---------
    *  MDriveTypes Enum
    --------- */
    public enum MDriveTypes {
        None(0, 0),
        Maneuver(2, 11),
        Reaction(0.2, 16);

        private final double mDriveCostModf;
        private final int mDriveMax;

        private MDriveTypes (double costModf, int max) {
            this.mDriveCostModf = costModf;
            this.mDriveMax = max;
        }
    }

    /* ---------
    *  MDriveType
    --------- */
    private MDriveTypes MDriveType = MDriveTypes.Maneuver;

    /* ---------
    *  MDriveRating
    --------- */
    private int mDriveRating = 0;

    public int getMDriveRating() {
        return this.mDriveRating;
    }

    public boolean setMDriveRating(int rating) {
        if (rating > 0)
            if (rating <= MDriveType.mDriveMax) {
                this.mDriveRating = rating;
                return true;
            } else {
                this.mDriveRating = MDriveType.mDriveMax;
                return false;
            }
        else {
            mDriveRating = 0;
            return false;
        }
    }

    /* ---------
    *  MDriveWeight
    --------- */
    public double getMDriveWeight() {
        switch(MDriveType) {
            case Maneuver:
                if (mDriveRating == 0) return 0.005;
                else return mDriveRating / 100;
            case Reaction:
                return 2 * mDriveRating / 100;
            default: return 0;
        }
    }

    /* ---------
    *  MDriveTL
    --------- */
    
}
