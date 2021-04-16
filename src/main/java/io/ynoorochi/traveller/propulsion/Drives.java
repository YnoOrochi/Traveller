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
public class Drives {
    private final static int[] nTL = {0};
    private final static int[] mTL = {7, 9, 10, 10, 11, 11, 12, 12, 13, 13, 16, 17};
    private final static int[] rTL = {0, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10, 11, 11, 11, 12};

    /* ---------
    *  MDriveTypes Enum
    --------- */
    public enum MDriveTypes {
        None(0, 0, nTL),
        Maneuver(2000000, 11, mTL),
        Reaction(200000, 16, rTL);

        private final double mDriveCost;
        private final int mDriveMax;
        private final int[] mDriveTL;

        private MDriveTypes (double cost, int max, int[] tl) {
            this.mDriveCost = cost;
            this.mDriveMax = max;
            this.mDriveTL = tl;
        }
        
        public double getMDriveCost() {
            return this.mDriveCost;
        }
        
        public int getMDriveMax() {
            return this.mDriveMax;
        }
        
        public int getMDriveTL(int rating) {
            if (rating <= getMDriveMax()) return this.mDriveTL[rating];
            else return 0;
        }
    }

    
}
