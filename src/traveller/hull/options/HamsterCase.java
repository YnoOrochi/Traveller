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
public class HamsterCase extends Options {

    /* ---------
    *  Option constructor
    --------- */
    public HamsterCase(int size) {
        super(size);
    }
    
    /* ---------
    *  Option setter
    --------- */
    public boolean setOption(int size) {
        if (size >= 0) {
            this.hmsSize = size;
            return this.setOption(true);
        } else {
            this.hmsSize = 0;
            this.setOption(false);
            return false;
        }
    }
    
    /* ---------
    *  get Hamster Case Size
    --------- */
    private int hmsSize = 0;
    public int getHmsSize() {
        return this.hmsSize;
    }

    /* ---------
    *  Tonnage Used by Option
    *       uses 0.1 ton for every ton of outer hull.
    --------- */
    @Override
    public double getOptUsedTon() {
        if (isOption()) return 0.1 * getHmsSize();
        else return 0;
    }
    
    /* ---------
    *  Option Hull Cost Modifier
    *       For each full percent of the total hull which is made part of
    *       the spun hull, the cost of the hull must be increased by +2% 
    --------- */
    @Override
    public double getOptCostModf() {
        if (isOption()) return 2 * (int) (getHmsSize() / optHullSize);
        else return 0;
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Option(HamsterCase=").append(isOption());
        if (getHmsSize() != 0) sb.append(", OaseSize=").append(getHmsSize());
        if (getOptUsedTon() != 0) sb.append(", UsedTon=").append(getOptUsedTon());
        if (getOptCostModf() != 0) sb.append(", Cost=").append(getOptCostModf());
        sb.append('}');
        return sb.toString();
    }
}
