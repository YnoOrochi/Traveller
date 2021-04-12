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
public class DoubleHull extends Options {
    
    /* ---------
    *  Minimum Double Hull optHullSize is 60 tons
    *  Maximun is 90% of ship hull
    --------- */
    private final int MIN = 60;
    private final double MAX = 0.9;

    /* ---------
    *  Option constructor
    --------- */
    public DoubleHull(int size) {
        super(size);
    }
    
    /* ---------
    *  Option setter
    --------- */
    public boolean setOption(int size) {
        if (size >= MIN || size <= MAX * optHullSize) {
            this.outerHull = size;
            return this.setOption(true);
        } else {
            this.outerHull = 0;
            this.setOption(false);
            return false;
        }
    }
    
    /* ---------
    *  Outer Hull Size
    --------- */
    protected int outerHull = 0;
    public int getOutHullSize() {
        return this.outerHull;
    }

    /* ---------
    *  Tonnage Used by Option
    *       uses 0.1 ton for every ton of outer hull.
    --------- */
    @Override
    public double getOptUsedTon() {
        if (isOption()) return 0.1 * getOutHullSize();
        else return 0;
    }
    
    /* ---------
    *  Option Hull Cost Modifier
    *       For each full percent of the total hull which is made part of
    *       the spun hull, the cost of the hull must be increased by +1% 
    --------- */
    @Override
    public double getOptCostModf() {
        if (isOption()) return 1 * (int) (getOutHullSize() / optHullSize);
        else return 0;
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Option(DoubleHull=").append(isOption());
        if (getOutHullSize() != 0) sb.append(", OuterHull=").append(getOutHullSize());
        if (getOptUsedTon() != 0) sb.append(", UsedTon=").append(getOptUsedTon());
        if (getOptCostModf() != 0) sb.append(", Cost=").append(getOptCostModf());
        sb.append('}');
        return sb.toString();
    }
}
