/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.fuel;

/**
 *
 * @author PR3J
 */
public class JmpTank extends Options{
    /* ---------
    *  Constructor
    --------- */
    public JmpTank(int rating, int jumps, int hullSize) {
        this.setHullSize(hullSize);
        this.setRating(rating);
        this.setTime(jumps);
        
        setOptiOn(true);
    }

    /* ---------
     *  Jump Fuel
     *       10% of the total tonnage of the ship, multiplied by the
     *       maximum jump score of the drive, per jump.
    --------- */
    @Override
    public int getWeight() {
        return (int) Math.ceil(0.1 * getHullSize() * getRating() * getTime());
    }

    public int getWeight(int rating, int jumps, int hullSize) {
        this.setHullSize(hullSize);
        this.setRating(rating);
        this.setTime(jumps);

        return getWeight();
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("JmpTank{weight=").append(getWeight());
        sb.append(", Jump").append(getRating()).append("s=").append(getTime());
        sb.append('}');
        return sb.toString();
    }
}
