/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.hull.options;

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
    public int getOptCost() {
        if (isOptiOn()) return (int) (WHT * 2000000); // * hullSize 
        else return 0;
    }

    /* ---------
    *  Tonnage Used by Option
    *       consumes 2% of the combined hull tonnage.
    --------- */
    @Override
    public double getOptUsedTon() {
        if (isOptiOn()) return WHT * Options.hullSize;
        else return 0;
    }
    
    /* ---------
    *  toString
    --------- */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Option(Breakaway=").append(isOptiOn());
        if (isOptiOn()) sb.append(", Cost=").append(getOptCost());
        if (isOptiOn()) sb.append(", UsedTon=").append(getOptUsedTon());
        sb.append('}');
        return sb.toString();
    }
}
