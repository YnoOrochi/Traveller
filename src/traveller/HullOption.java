/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveller;

/**
 *
 * @author PR3J
 */
public class HullOption {
    private boolean option = false;
    private int optTL = 0;
    private int optValue = 0;
    private double optUsedTon = 0;
    private int optCost = 0;
    private double optCostModf = 0;

    public boolean setOption(boolean opt) {
        return this.option = opt;
    }
    
    public boolean isOption() {
        return option;
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
