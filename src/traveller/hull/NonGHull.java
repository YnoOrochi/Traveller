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
public class NonGHull extends Options {
    
    /* ---------
    *  Non-gravity Hull maximum optHullSize is 500,000 tons
    --------- */
    private final int NONG_MAX = 500000;

    /* ---------
    *  Option constructor
    --------- */
    public NonGHull(int size) {
        super(size);
    }
    
    /* ---------
    *  Option setter
    --------- */
    @Override
    public boolean setOption(boolean opt) {
        if (opt && this.optHullSize > NONG_MAX) return this.option = false;
        
        this.option = opt;
        return true;
    }
    
    /* ---------
    *  Option Hull Cost Modifier (modf -0.5)
    *      basic cost from Cr50000 to Cr25000 per ton 
    *      problem: PLNT basic cost is Cr4000 per ton, then I used 2000 ...
    --------- */
    @Override
    public double getOptCostModf() {
        if (isOption()) return -0.5;
        else return 0;
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Option(RadShield=").append(isOption());
        sb.append(", MAXTon=").append(NONG_MAX);
        if (getOptCostModf() != 0) sb.append(", Cost=").append(getOptCostModf());
        sb.append('}');
        return sb.toString();
    }
}
