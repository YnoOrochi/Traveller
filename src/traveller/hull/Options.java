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
    static boolean option = false;
    static int optTL = 0;
    static int optValue = 0;
    static double optUsedTon = 0;
    static int optCost = 0;
    static double optCostModf = 0;

    public boolean setOption(boolean opt) {
        return option = opt;
    }
    
    public boolean isOption() {
        return option;
    }

    public int maxOptTL(int tl) {
        return Math.max(optTL, tl);
    }

    public int getOptTL() {
        return optTL;
    }

    public int getOptValue() {
        return optValue;
    }

    public double getOptUsedTon() {
        return optUsedTon;
    }

    public int getOptCost() {
        return optCost;
    }

    public double getOptCostModf() {
        return optCostModf;
    }

}
