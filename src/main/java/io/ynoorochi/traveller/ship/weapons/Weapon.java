/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.weapons;

import io.ynoorochi.traveller.ship.Items;
import io.ynoorochi.traveller.ship.weapons.Definitions.WeaponRanges;

/**
 *
 * @author PR3J
 */
public abstract class Weapon extends Items {
    /* ---------
     *  Getters
    --------- */
    @Override
    public abstract String getName();
    
    @Override
    public abstract int getTL();

    @Override
    public abstract double getPower();

    @Override
    public abstract double getBaseWeight();

    @Override
    public abstract double getBaseCost();

    public abstract WeaponRanges getRange();
    public abstract String getDamage();
    public abstract String getTraits();

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append("{TL=").append(getTL());
        if(getWeight() > 0) sb.append(", Weight=").append(getWeight());
        if (getPower() > 0) sb.append(", Power=").append(getPower());
        sb.append(", Range=").append(getRange());
        sb.append(", Damage=").append(getDamage());
        sb.append(", Cost=").append(getCost());
        sb.append(", Traits=").append(getTraits());
        if (isHardened()) sb.append(", Hardened");
        sb.append('}');
        return sb.toString();
    }

}
