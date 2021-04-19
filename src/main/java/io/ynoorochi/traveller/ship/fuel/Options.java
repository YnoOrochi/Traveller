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
public abstract class Options {
    /* ---------
     *  Attributes
    --------- */
    private boolean option = false;
    
    /* ---------
     *  Fuel Tank Weight
    --------- */
    public int getWeight() {
        return 0;
    }
    
    /* ---------
     *  Fuel Tank Cost
    --------- */
    public int getCost() {
        return 0;
    }
    
    /* ---------
    *  Option setter
    *      returns the operation result
    *      false means: the option has some constraint that was not observed
    --------- */
    public boolean setOptiOn(boolean opt) {
        this.option = opt;
        return true;
    }
    
    /* ---------
    *  is Option on?
    --------- */
    public boolean isOptiOn() {
        return this.option;
    }

    /* ---------
    *  Hull Size
    --------- */
    private int hullSize;

    public int getHullSize() {
        return this.hullSize;
    }

    public void setHullSize(int hullSize) {
        this.hullSize = hullSize;
    }

    /* ---------
    *  Auxiliar rating
    --------- */
    protected int rating;

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    /* ---------
    *  Autonomy (Hours, Weeks, Jumps ...)
    --------- */
    protected int time;

    public int getTime() {
        return this.time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append("(").append(isOptiOn());
        if (isOptiOn()) sb.append(", Weight=").append(getWeight());
        if (isOptiOn()) sb.append(", Cost=").append(getCost());
        sb.append('}');
        return sb.toString();
    }
}
