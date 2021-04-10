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
public class HeatShield extends Options {
    
    @Override
    public boolean setOption(boolean opt) {
        option = opt;
        if (opt) {
            optTL = 6;
            optCost = 100000;
        } else {
            optTL = 0;
            optCost = 0;
        }
        return option = opt;
    }

}
