/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.systems;

import io.ynoorochi.traveller.ship.Items;

/**
 *
 * @author PR3J
 */
public class CargoJumpNet extends Items {
    /* ---------
     *  Constructor
    --------- */
    public CargoJumpNet(int qtty) { setQtty(qtty); }

    /* ---------
     *  Number of tonnage
    --------- */
    public int getQtty() { return getIntAtt(); }
    public void setQtty(int qtty) { setIntAtt(qtty); }

    /* ---------
     * is Option on?
    --------- */
    @Override
    public boolean isOptiOn() { return (getQtty() > 0); }

    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getTL() { return 10; }

    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getWeight() { return getQtty(); }
    
    /* ---------
     *  Option Specific Cost
    --------- */
    @Override
    public double getCost() { return 300000 * getQtty(); }

    /* ---------
     *  Option Name
    --------- */
    @Override
    public String getName() { return "Cargo Jump Net (per 100t)"; }

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append("{").append(isOptiOn());
        if (isOptiOn()) {
            sb.append(", TL=").append(getTL());
            sb.append(", Cost=").append(getCost());
            sb.append(", Weight=").append(getWeight());
            sb.append(", Power=").append(getPower());
            if (isHardened()) sb.append(", Hardened");
        }
        sb.append('}');
        return sb.toString();
    }
}
