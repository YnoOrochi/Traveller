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
public class EAGrid extends Options {

    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getOptTL() {
        if (isOptiOn()) return 8;
        else return 0;
    }
    
    /* ---------
    *  Tonnage Used by Option
    --------- */
    @Override
    public double getOptUsedTon() {
        if (isOptiOn()) return 0.02 * Options.hullSize;
        else return 0;
    }
    
    /* ---------
    *  Option Specific Cost
    --------- */
    @Override
    public int getOptCost() {
        if (isOptiOn()) return 40000;
        else return 0;
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Option(EAGrig=").append(isOptiOn());
        if (getOptTL() != 0) sb.append(", TL=").append(getOptTL());
        if (getOptUsedTon() != 0) sb.append(", UsedTon=").append(getOptUsedTon());
        if (getOptCost() != 0) sb.append(", Cost=").append(getOptCost());
        sb.append('}');
        return sb.toString();
    }
}
