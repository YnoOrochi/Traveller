/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.power;

/**
 *
 * @author PR3J
 */
public class PlantTypes {
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
        
        public int getTl() {
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
