/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.hull.options;

/**
 *
 * @author PR3J
 */
public class EAGrid extends Options {

    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getTL() {
        if (isOptiOn()) return 8;
        else return 0;
    }
    
    /* ---------
    *  Tonnage Used by Option
    --------- */
    @Override
    public double getWeight() {
        if (isOptiOn()) return 0.02 * getHullSize();
        else return 0;
    }
    
    /* ---------
    *  Option Specific Cost
    --------- */
    @Override
    public int getCost() {
        if (isOptiOn()) return 40000;
        else return 0;
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Option(EAGrig=").append(isOptiOn());
        if (getTL() != 0) sb.append(", TL=").append(getTL());
        if (getWeight() != 0) sb.append(", Weight=").append(getWeight());
        if (getCost() != 0) sb.append(", Cost=").append(getCost());
        sb.append('}');
        return sb.toString();
    }
}
