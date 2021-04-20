/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.hull.options;

import io.ynoorochi.traveller.ship.Items;
import io.ynoorochi.traveller.ship.hull.Definitions.*;
import static io.ynoorochi.traveller.ship.hull.Definitions.ArmourOptions.*;

/**
 *
 * @author PR3J
 */
public class Armour extends Items {
    /* ---------
    *  Armour Type
    --------- */
    private ArmourOptions type = NONE;
    
    public ArmourOptions getType() {
        return this.type;
    }
    
    public void setType(ArmourOptions armour) {
        this.type = armour;
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
            case TTST: return 9;
            case CRIR: return 13;
            case BDSD: return getTL();
            case MLBD: return getTL() + 4;
            default: return 0;
        }
    }
    
    /* ---------
    *  Armour TL
    --------- */
    @Override
    public int getTL() {
        return Math.max(getType().getBaseTL(), getArmourMax());
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
        sb.append(this.getClass().getSimpleName()).append("(");
        sb.append("Type=").append(type.getType());
        sb.append(", Points=").append(armourPoints);
        sb.append(", TL=").append(getTL());
        sb.append('}');
        return sb.toString();
    }
}
