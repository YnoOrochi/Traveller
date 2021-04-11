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
    protected int size;
    protected boolean option = false;

    /* ---------
    *  Option constructor
    --------- */
    public Options(int size) {
        this.size = size;
    }

    /* ---------
    *  Option setter
    --------- */
    public boolean setOption(boolean opt) {
        return this.option = opt;
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
        return 0;
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
        return "Options{" + "size=" + size + ", option=" + option + '}';
    }

}
