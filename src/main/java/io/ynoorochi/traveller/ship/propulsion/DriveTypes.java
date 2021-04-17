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

        private final double cost;
        private final int max;
        private final int[] tl;

        private MDriveTypes (double cost, int max, int[] tl) {
            this.cost = cost;
            this.max = max;
            this.tl = tl;
        }
        
        public double getCost() {
            return this.cost;
        }
        
        public int getMax() {
            return this.max;
        }
        
        public int getTL(int rating) {
            if (rating <= getMax()) return this.tl[rating];
            else return 0;
        }
    }

    /* ---------
    *  MDriveTypes Enum
    --------- */
    public enum JDriveTypes {
        None(0, 0, nTL),
        Jump(1500000, 9, jTL);

        private final double cost;
        private final int max;
        private final int[] tl;

        private JDriveTypes (double cost, int max, int[] tl) {
            this.cost = cost;
            this.max = max;
            this.tl = tl;
        }
        
        public double getCost() {
            return this.cost;
        }
        
        public int getMax() {
            return this.max;
        }
        
        public int getTL(int rating) {
            if (rating <= getMax()) return this.tl[rating];
            else return 0;
        }
    }
}
