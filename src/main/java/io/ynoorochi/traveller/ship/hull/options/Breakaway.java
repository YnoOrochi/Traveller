/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.hull.options;

/**
 *
 * @author PR3J
 */
public class Breakaway extends Options {
    private final double WHT = 0.02;          // 2%
    
    /* ---------
    *  Option Specific Cost
    *       costs an additional MCr2 per ton consumed
    --------- */
    @Override
    public int getCost() {
        if (isOptiOn()) return (int) (WHT * 2000000); // * hullSize 
        else return 0;
    }

    /* ---------
    *  Tonnage Used by Option
    *       consumes 2% of the combined hull tonnage.
    --------- */
    @Override
    public double getWeight() {
        if (isOptiOn()) return WHT * getHullSize();
        else return 0;
    }
    
    /* ---------
    *  toString
    --------- */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Option(Breakaway=").append(isOptiOn());
        if (isOptiOn()) sb.append(", Cost=").append(getCost());
        if (isOptiOn()) sb.append(", Weight=").append(getWeight());
        sb.append('}');
        return sb.toString();
    }
}
