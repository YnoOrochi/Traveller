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
public abstract class Equipment {

    /* ---------
    *  Atributes
    --------- */
    protected int hullSize;

    /* ---------
    *  Hull Size
    --------- */
    public int getHullSize() {
        return this.hullSize;
    }

    public void setHullSize(int size) {
        this.hullSize = size;
    }

    /* ---------
    *  Cost
    --------- */
    public double getCost() {
        return 0;
    }

    /* ---------
    *  Power used
    --------- */
    public double getPower() {
        return 0;
    }

    /* ---------
    *  Rating
    --------- */
    public int getRating() {
        return 0;
    }

    /* ---------
    *  Tech Level
    --------- */
    public int getTL() {
        return 0;
    }

    public int maxTL(int tl) {
        return Math.max(this.getTL(), tl);
    }

    /* ---------
    *  Tonnage Used
    --------- */
    public double getWeight() {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Equipment{Base").append("");
        sb.append(", Cost=").append(getCost());
        sb.append(", Pwr=").append(getPower());
        sb.append(", Rating=").append(getRating());
        sb.append(", TL=").append(getTL());
        sb.append(", Weight=").append(getWeight());
        sb.append('}');
        return sb.toString();
    }
}
