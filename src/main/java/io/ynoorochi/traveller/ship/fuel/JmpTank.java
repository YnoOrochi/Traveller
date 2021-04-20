/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.fuel;

import io.ynoorochi.traveller.ship.Items;

/**
 *
 * @author PR3J
 */
public class JmpTank extends Items{
    /* ---------
    *  Constructor
    --------- */
    public JmpTank(double rating, int jumps, int hullSize) {
        this.setHullSize(hullSize);
        this.setRating(rating);
        this.setJumps(jumps);
        
        setOptiOn(true);
    }

    /* ---------
    *  JDrive Rating
    --------- */
    public double getRating() {
        return getAttribute();
    }
    
    public void setRating(double rating) {
        if (rating >= 0) setAttribute(rating);
    }

    /* ---------
    *  Intended Jumps
    --------- */
    public int getJumps() {
        return getIntAtt();
    }
    
    public void setJumps(int jumps) {
        if (jumps >= 0) setIntAtt(jumps);
    }

    /* ---------
     *  Jump Fuel
     *       10% of the total tonnage of the ship, multiplied by the
     *       maximum jump score of the drive, per jump.
    --------- */
    @Override
    public double getWeight() {
        return Math.ceil(0.1 * getHullSize() * getRating() * getJumps());
    }

    public double getWeight(double rating, int jumps, int hullSize) {
        this.setHullSize(hullSize);
        this.setRating(rating);
        this.setJumps(jumps);

        return getWeight();
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("JmpTank{weight=").append(getWeight());
        sb.append(", Jumps/").append(getRating()).append("=").append(getJumps());
        sb.append('}');
        return sb.toString();
    }
}
