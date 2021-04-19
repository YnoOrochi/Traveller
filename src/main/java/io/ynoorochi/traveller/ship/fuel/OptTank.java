/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.fuel;

import io.ynoorochi.traveller.ship.Items;

/**
 *
 * @author PR3J
 */
public class OptTank extends Items {
    /* ---------
     *  Attributes
    --------- */
    private Hidden hidden = new Hidden();
    
    private final Items[] optTanks = {
        hidden
    };
    
    public Items[] getOptions() {
        return this.optTanks;
    }

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (var opt : optTanks) 
            sb.append(opt.toString()).append("\n");

        sb.append('}');
        return sb.toString();
    }
}
