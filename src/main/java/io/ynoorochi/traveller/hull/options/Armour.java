/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.hull.options;

import io.ynoorochi.traveller.hull.Definitions.*;
import static io.ynoorochi.traveller.hull.Definitions.ArmourOptions.*;

/**
 *
 * @author PR3J
 */
public class Armour extends Options {
    /* ---------
    *  Armour Type
    --------- */
    private ArmourOptions armourType = NONE;
    
    public ArmourOptions getArmourType() {
        return this.armourType;
    }
    
    public void setArmourType(ArmourOptions armour) {
        this.armourType = armour;
        this.setOptTL(this.armourTL);
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
        switch(getArmourType()) {
            case TTST: return Math.min(this.getOptTL(), 9);
            case CRIR: return Math.min(this.getOptTL(), 13);
            case BDSD: return this.getOptTL();
            case MLBD: return this.getOptTL() + 4;
            default: return 0;
        }
    }
    
    /* ---------
    *  Armour TL
    --------- */
    private int armourTL = getArmourType().getArmourBaseTL();
    
    @Override
    public int getOptTL() {
        return this.armourTL;
    }
    
    public boolean setOptTL(int tl) {
        this.armourTL = Math.max(getArmourType().getArmourBaseTL(), tl);
        return getArmourType().getArmourBaseTL() == tl;
    }
    
    /* ---------
    *  Tonnage Used by Option
    --------- */
    @Override
    public double getOptUsedTon() {
        return armourPoints * getArmourType().getArmourWeight() * Options.hullSize;
    }

    /* ---------
    *  Option Specific Cost
    --------- */
    @Override
    public double getOptCostModf() {
        return armourPoints * getArmourType().getArmourCostModf();
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
        sb.append("Armour{armourType=").append(armourType);
        sb.append(", armourPoints=").append(armourPoints);
        sb.append(", armourTL=").append(armourTL);
        sb.append('}');
        return sb.toString();
    }
}
