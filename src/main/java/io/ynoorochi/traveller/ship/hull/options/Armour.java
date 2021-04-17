/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.hull.options;

import io.ynoorochi.traveller.ship.hull.Definitions.*;
import static io.ynoorochi.traveller.ship.hull.Definitions.ArmourOptions.*;

/**
 *
 * @author PR3J
 */
public class Armour extends Options {
    /* ---------
    *  Armour Type
    --------- */
    private ArmourOptions type = NONE;
    
    public ArmourOptions getType() {
        return this.type;
    }
    
    public void setType(ArmourOptions armour) {
        this.type = armour;
        this.setTL(this.tl);
    }

    /* ---------
    *  Armour Points
    --------- */
    private int armourPoints;

    public int getArmourPoints(HullConfiguration hull) {
        switch(hull) {
            case PNTD: return this.armourPoints + 2;
            case BFPN: return this.armourPoints + 4;
            default: return this.armourPoints;
        }
    }
    
    public void setArmourPoints(int ap) {
        this.armourPoints = Math.min(getArmourMax(), ap);
    }
    
    public int getArmourMax(){
        switch(getType()) {
            case TTST: return Math.min(this.getTL(), 9);
            case CRIR: return Math.min(this.getTL(), 13);
            case BDSD: return this.getTL();
            case MLBD: return this.getTL() + 4;
            default: return 0;
        }
    }
    
    /* ---------
    *  Armour TL
    --------- */
    private int tl = getType().getBaseTL();
    
    @Override
    public int getTL() {
        return this.tl;
    }
    
    public boolean setTL(int tl) {
        this.tl = Math.max(getType().getBaseTL(), tl);
        return getType().getBaseTL() == tl;
    }
    
    /* ---------
    *  Tonnage Used by Option
    --------- */
    @Override
    public double getWeight() {
        return armourPoints * getType().getWeight() * getHullSize();
    }

    /* ---------
    *  Option Specific Cost
    --------- */
    @Override
    public double getCostModf() {
        return armourPoints * getType().getCostModf();
    }

/* ---------
    *  is not 0?
    --------- */
    @Override
    public boolean isOptiOn() {
        return this.armourPoints > 0;
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Armour{Type=").append(type.getType());
        sb.append(", Points=").append(armourPoints);
        sb.append(", TL=").append(tl);
        sb.append('}');
        return sb.toString();
    }
}
