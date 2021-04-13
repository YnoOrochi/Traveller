/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveller.hull.options;

/**
 *
 * @author PR3J
 */
public class HeatShield extends Options {

    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getOptTL() {
        if (isOptiOn()) return 6;
        else return 0;
    }
    
    /* ---------
    *  Option Specific Cost
    --------- */
    @Override
    public int getOptCost() {
        if (isOptiOn()) return 100000;
        else return 0;
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Option(HeatShield=").append(isOptiOn());
        if (getOptTL() != 0) sb.append(", TL=").append(getOptTL());
        if (getOptCost() != 0) sb.append(", Cost=").append(getOptCost());
        sb.append('}');
        return sb.toString();
    }
}
