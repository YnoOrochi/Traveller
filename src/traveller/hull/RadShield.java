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
public class RadShield extends Options {
    
    /* ---------
    *  Option constructor
    --------- */
    public RadShield(int size) {
        super(size);
    }
    
    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getOptTL() {
        if (isOption()) return 7;
        else return 0;
    }
    
    /* ---------
    *  Option Specific Cost
    --------- */
    @Override
    public int getOptCost() {
        if (isOption()) return 25000;
        else return 0;
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Option(RadShield=").append(isOption());
        if (getOptTL() != 0) sb.append(", TL=").append(getOptTL());
        if (getOptCost() != 0) sb.append(", Cost=").append(getOptCost());
        sb.append('}');
        return sb.toString();
    }
}
