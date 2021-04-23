/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.computer;

import io.ynoorochi.traveller.ship.Items;
import io.ynoorochi.traveller.ship.computer.Definitions.Computers;
import static io.ynoorochi.traveller.ship.computer.Definitions.Computers.*;

/**
 *
 * @author PR3J
 */
public class BackupComputer extends Items {
    /* ---------
    *  Attributes
    --------- */
    private int baseBandwidth;
    
    /* ---------
    *  Constructor
    --------- */
    public BackupComputer(int base) {
        this.baseBandwidth = base;
        setType(NONE);
    }

    /* ---------
    *  type
    --------- */
    private Computers type = COMP05;
    
    public Computers getType () {
        return this.type;
    }
    
    public void setType(Computers type) {
        if (type != NONE && baseBandwidth > type.getBandwidth()) {
            this.type = type;
            super.setOptiOn(true);
        } else { 
            this.type = NONE;
            super.setOptiOn(false);
        }
    }

    /* ---------
    *  setOptiOn
    --------- */
    @Override
    public boolean setOptiOn(boolean opt) {
        if (opt) setType(COMP05);
        else setType(NONE);
        return true;
    }

    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getTL() {
        return type.getTL();
    }

    /* ---------
     *  Option Specific Cost
    --------- */
    @Override
    public double getCost() {
        return (1 + getHardened() + getBIS()) * type.getCost();
    }

    /* ---------
     *  Computer Bandwidth
    --------- */
    public int getBandwidth() {
        return type.getBandwidth();
    }
    
    /* ---------
     *  Computer Bandwidth
    --------- */
    private boolean bis = false;
    
    public double getBIS() {
        return 0.5;
    }
    
    public boolean isBIS() {
        return this.bis;
    }
    
    public void setBIS(boolean opt) {
        this.bis = opt;
    }

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append("{").append(getType().getName());
        if (isOptiOn()) { 
            sb.append(", TL=").append(getTL());
            sb.append(", Cost=").append(getCost());
            sb.append(", Bandwidth=").append(getBandwidth());
            if (isBIS()) sb.append(" /bis").append(getPower());
            if (isHardened()) sb.append(" /fib");
        }
        sb.append('}');
        return sb.toString();
    }
}
