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
    private MHydride mHydride = new MHydride();
    private Collapsible collaps = new Collapsible();
    private Demountable demount = new Demountable();
    private Drop drop = new Drop();
    private Processor processor = new Processor();
    private Scoop scoop = new Scoop();
    
    /* ---------
     *  Item list
    --------- */
    private final Items[] optTanks = {
        hidden, mHydride, collaps, demount, drop, processor, scoop
    };
    
    public Items[] getItems() {
        return this.optTanks;
    }

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tank Options {\n");
        for (var opt : optTanks) 
            sb.append("    ").append(opt.toString()).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
