/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.equip;

/**
 *
 * @author PR3J
 */
public class Definitions {
    private final static int[] nTL = {0};
    private final static int[] mTL = {7, 9, 10, 10, 11, 11, 12, 12, 13, 13, 16, 17};
    private final static int[] rTL = {0, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10, 11, 11, 11, 12};
    private final static int[] jTL = {0, 9, 11, 12, 13, 14, 15, 16, 17, 18};

    /* ---------
    *  MDriveTypes Enum
    --------- */
    public enum MDriveTypes {
        None(          0,  0, nTL),
        Maneuver(2000000, 11, mTL),
        Reaction( 200000, 16, rTL);

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
    *  Jump Drive Types Enum
    --------- */
    public enum JDriveTypes {
        None(      0, 0, nTL),
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

    /* ---------
    *  Power Plant Types
    --------- */
    public enum PwrPlants {
        Fission(    6,   8,   400000),
        Chemical(   7,   5,   250000),
        Fusion08(   8,  10,   500000),
        Fusion12(  12,  15,  1000000),
        Fusion15(  15,  20,  2000000),
        Antimatter(20, 100, 10000000);
        
        private final int tl;
        private final int rating;
        private final double cost;
        
        private PwrPlants(int tl, int rating, double cost) {
            this.tl = tl;
            this.rating = rating;
            this.cost = cost;
        }
        
        public int getTL() {
            return this.tl;
        }
        
        public int getRating() {
            return this.rating;
        }
        
        public double getCost() {
            return this.cost;
        }
    }
}
