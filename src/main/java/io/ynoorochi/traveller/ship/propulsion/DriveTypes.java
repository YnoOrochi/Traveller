/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.propulsion;

/**
 *
 * @author PR3J
 */
public class DriveTypes {
    private final static int[] nTL = {0};
    private final static int[] mTL = {7, 9, 10, 10, 11, 11, 12, 12, 13, 13, 16, 17};
    private final static int[] rTL = {0, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10, 11, 11, 11, 12};
    private final static int[] jTL = {0, 9, 11, 12, 13, 14, 15, 16, 17, 18};

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

    /* ---------
    *  MDriveTypes Enum
    --------- */
    public enum JDriveTypes {
        None(0, 0, nTL),
        Jump(1500000, 9, jTL);

        private final double jDriveCost;
        private final int jDriveMax;
        private final int[] jDriveTL;

        private JDriveTypes (double cost, int max, int[] tl) {
            this.jDriveCost = cost;
            this.jDriveMax = max;
            this.jDriveTL = tl;
        }
        
        public double getJDriveCost() {
            return this.jDriveCost;
        }
        
        public int getJDriveMax() {
            return this.jDriveMax;
        }
        
        public int getJDriveTL(int rating) {
            if (rating <= getJDriveMax()) return this.jDriveTL[rating];
            else return 0;
        }
    }
}
