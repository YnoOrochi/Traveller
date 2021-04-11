/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveller.hull;

/**
 *
 * @author PR3J
 */
public class EAGrid extends Options {

    /* ---------
    *  Constructor
    --------- */
    public EAGrid(int size) {
        super(size);
    }

    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getOptTL() {
        if (isOption()) return 8;
        else return 0;
    }
    
    /* ---------
    *  Tonnage Used by Option
    --------- */
    @Override
    public double getOptUsedTon() {
        if (isOption()) return 0.02 * hullSize;
        else return 0;
    }
    
    /* ---------
    *  Option Specific Cost
    --------- */
    @Override
    public int getOptCost() {
        if (isOption()) return 40000;
        else return 0;
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Option(EAGrig=").append(isOption());
        if (getOptTL() != 0) sb.append(", TL=").append(getOptTL());
        if (getOptUsedTon() != 0) sb.append(", UsedTon=").append(getOptUsedTon());
        if (getOptCost() != 0) sb.append(", Cost=").append(getOptCost());
        sb.append('}');
        return sb.toString();
    }
}
