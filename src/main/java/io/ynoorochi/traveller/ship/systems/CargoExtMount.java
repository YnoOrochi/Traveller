/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.systems;

import io.ynoorochi.traveller.ship.Items;
import io.ynoorochi.traveller.ship.hull.Definitions.Streamlined;

/**
 *
 * @author PR3J
 */
public class CargoExtMount extends Items {
    /* ---------
     *  Constructor
    --------- */
    public CargoExtMount(Streamlined str, int qtty) {
        setNotStreamlined(str);
        setQtty(qtty); 
    }

    /* ---------
     *  Number of tonnage
    --------- */
    public int getQtty() { return getIntAtt(); }
    public void setQtty(int qtty) { setIntAtt(isNotStreamlined() ? qtty : 0); }

    /* ---------
     *  Streamlined
    --------- */
    private boolean notStream = true;
    public boolean isNotStreamlined() { return this.notStream; }
    public void setNotStreamlined(Streamlined str) { this.notStream = (str == Streamlined.No); }

    /* ---------
     * is Option on?
    --------- */
    @Override
    public boolean isOptiOn() { return (isNotStreamlined() && getQtty() > 0); }

    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getTL() { return 7; }

    /* ---------
     *  Option Specific Cost
    --------- */
    @Override
    public double getCost() { return 1000 * getQtty(); }

    /* ---------
     *  Option Name
    --------- */
    @Override
    public String getName() { return "Cargo External Mount (per t)"; }

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
