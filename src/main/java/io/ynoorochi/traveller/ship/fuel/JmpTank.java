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
public class JmpTank extends FuelItems{
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
    protected double getRating() { return getDblAtt(); }
    public void setRating(double rating) { setDblAtt(rating >= 0 ? rating : 0); }

    /* ---------
    *  Intended Jumps
    --------- */
    public int getJumps() { return getIntAtt(); }
    public void setJumps(int jumps) { setIntAtt(jumps >= 0 ? jumps : 0); }

    /* ---------
     *  Tank Size (ton)
    --------- */
    @Override
    public int getSize() { 
        return (int) getBaseWeight(getRating(), getJumps(), getHullSize());
    }

    @Override
    public void setSize(int size) { }

    /* ---------
     *  Jump Fuel
     *       10% of the total tonnage of the ship, multiplied by the
     *       maximum jump score of the drive, per jump.
    --------- */
    @Override
    public double getBaseWeight() {
        return Math.ceil(0.1 * getRating() * getJumps() * getHullSize());
    }

    protected double getBaseWeight(double rating, int jumps, int hullSize) {
        this.setHullSize(hullSize);
        this.setRating(rating);
        this.setJumps(jumps);

        return getBaseWeight();
    }

    /* ---------
     *  Fuel Tank Cost
    --------- */
    @Override
    protected double getBaseCost() { return 0; }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("JmpTank{Size=").append(getSize());
        sb.append(", weight=").append(getWeight());
        sb.append(", Jumps/").append(getRating()).append("=").append(getJumps());
        if (isArmoured()) sb.append(", Armoured Bulkheaded");
        sb.append('}');
        return sb.toString();
    }
}
