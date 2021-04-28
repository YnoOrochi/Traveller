/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.computer;

import io.ynoorochi.traveller.ship.Definitions.Hardened;
import static io.ynoorochi.traveller.ship.Definitions.Hardened.HARDENED;
import static io.ynoorochi.traveller.ship.Definitions.Hardened.NOTHARDENED;
import io.ynoorochi.traveller.ship.Items;
import io.ynoorochi.traveller.ship.computer.Definitions.Computers;
import static io.ynoorochi.traveller.ship.computer.Definitions.Computers.*;

/**
 *
 * @author PR3J
 */
public class Computer extends Items {
    /* ---------
     * Constructor
    --------- */
    public Computer(int jump) {
        setJump(jump);
        setOptiOn(true);
        setType(getMinBW(jump));
    }
    
    /* ---------
     * type
    --------- */
    private Computers type = COMP05;
    
    public Computers getType () {
        return this.type;
    }
    
    public void setType(Computers type) {
        if (type == NONE || 5 * getJump() - getBISBand() < type.getBandwidth()) 
            this.type = getMinBW(getJump());
        else this.type = type;
        super.setOptiOn(true);
    }

    /* ---------
     * setOptiOn
    --------- */
    @Override
    public boolean setOptiOn(boolean opt) {
        setType(COMP05);
        return true;
    }

    /* ---------
     * Tech Level
    --------- */
    @Override
    public int getTL() {
        return type.getTL();
    }

    /* ---------
     * Option Specific Cost
    --------- */
    @Override
    public double getCost() {
        return (1 + getHardened() + getBISModf()) * type.getCost();
    }

    /* ---------
     * Computer Bandwidth
    --------- */
    public int getBandwidth() {
        return type.getBandwidth();
    }
    
    /* ---------
     * Jump Drive Rating
    --------- */
    public int getJump() { return getIntAtt(); }
    public void setJump(int jump) { setIntAtt(jump); }

    /* ---------
     * Minimum Bandwidth
    --------- */
    public Computers getMinBW(int jump) {
        switch(jump - (isBIS() ? 1 : 0)) {
            case 2: return Computers.COMP10;
            case 3: return Computers.COMP15;
            case 4: return Computers.COMP20;
            case 5: return Computers.COMP25;
            case 6: return Computers.COMP30;
            case 7: return Computers.COMP35;
            case 8: return Computers.CORE40;
            case 9: 
            case 10: return Computers.CORE50;
            default: return Computers.COMP05;
        }
    }
    
    /* ---------
     *  Hardened Computer (/fib)
    --------- */
    @Override
    public double getHardened() { return this.hardened.getModf(); }
    
    @Override
    public void setHardened(Hardened opt) { this.hardened = opt; }
    
    /* ---------
     * Jump Control Specialisation (/bis)
    --------- */
    private boolean bis = false;
    public boolean isBIS() { return this.bis; }
    public double getBISModf() { return (isBIS() ? 0.5 : 0); }
    public double getBISBand() { return (isBIS() ? 5 : 0); }
    public void setBIS(boolean opt) { this.bis = opt; }

    /* ---------
     * toString
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
