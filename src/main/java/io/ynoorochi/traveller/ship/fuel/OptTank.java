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
    *  Tech Level
    --------- */
    @Override
    public int getTL() { 
        int tl = 0;
        for (var opt : optTanks ) {
            tl = Math.max(tl, opt.getTL());
        }
        return tl;
    }

    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getWeight() { 
        double aux = 0;
        for (var opt : optTanks ) {
            aux += opt.getWeight();
        }
        return aux;
    }

    /* ---------
     *  Option Specific Cost
    --------- */
    @Override
    public double getCost() { 
        double aux = 0;
        for (var opt : optTanks ) {
            aux += opt.getCost();
        }
        return aux;
    }

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tank Options {");
        sb.append("TL=").append(getTL());
        sb.append(", Cost=").append(getCost());
        sb.append(", Weight=").append(getWeight());
        sb.append("}\n");
        for (var opt : optTanks) 
            sb.append("    ").append(opt.toString()).append("\n");
        return sb.toString();
    }
}
