/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.fuel;

/**
 *
 * @author PR3J
 */
public class OptTank {
    /* ---------
     *  Attributes
    --------- */
    private Hidden hidden = new Hidden();
    
    private final Options[] optTanks = {
        hidden
    };
    
    public Options[] getOptions() {
        return this.optTanks;
    }

    /* ---------
     *  Attributes
    --------- */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Options opt : optTanks) 
            sb.append(opt.toString()).append("\n");

        sb.append('}');
        return sb.toString();
    }
}
