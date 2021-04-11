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
public class Options {
    protected int hullSize;
    protected int optSize = 0;
    protected boolean option = false;

    /* ---------
    *  Option constructor
    --------- */
    public Options(int size) {
        this.hullSize = size;
    }

    /* ---------
    *  Option setter
    *      returns the operation result
    *      false means: the option has some constraint that was not observed
    --------- */
    public boolean setOption(boolean opt) {
        this.option = opt;
        return true;
    }
    
    /* ---------
    *  is Option on?
    --------- */
    public boolean isOption() {
        return this.option;
    }

    /* ---------
    *  Tech Level
    --------- */
    public int getOptTL() {
        return 0;
    }

    public int maxOptTL(int tl) {
        return Math.max(this.getOptTL(), tl);
    }

    /* ---------
    *  Option Specific Tonnage
    --------- */
    public int getOptSize() {
        return this.optSize;
    }

    /* ---------
    *  Tonnage Used by Option
    --------- */
    public double getOptUsedTon() {
        return 0;
    }

    /* ---------
    *  Option Specific Cost
    --------- */
    public int getOptCost() {
        return 0;
    }

    /* ---------
    *  Option Hull Cost Modifier
    --------- */
    public double getOptCostModf() {
        return 0;
    }

    /* ---------
    *  basic toString
    --------- */
    @Override
    public String toString() {
        return "Options{" + "size=" + hullSize + ", option=" + option + '}';
    }

}
