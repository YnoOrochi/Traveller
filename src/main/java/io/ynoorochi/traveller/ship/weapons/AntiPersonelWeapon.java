/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.weapons;

import io.ynoorochi.traveller.ship.weapons.Definitions.APersonelWeapons;
import io.ynoorochi.traveller.ship.weapons.Definitions.WeaponRanges;

/**
 *
 * @author PR3J
 */
public class AntiPersonelWeapon extends Weapon {
    /* ---------
     *  Constructor
    --------- */
    public AntiPersonelWeapon() { this(APersonelWeapons.EMPTY); }
    public AntiPersonelWeapon(APersonelWeapons type) { setType(type); }

    /* ---------
     *  Type
    --------- */
    private APersonelWeapons type = APersonelWeapons.EMPTY;
    public APersonelWeapons getType() { return this.type; }
    public void setType(APersonelWeapons type) { this.type = type; }

    /* ---------
     *  Getters
    --------- */
    @Override
    public String getName() { return getType().getName(); }
    
    @Override
    public int getTL() { return getType().getTL(); }
    
    @Override
    public WeaponRanges getRange() { return getType().getRange(); }
    
    @Override
    public double getPower() { return getType().getPower(); }
    
    @Override
    public String getDamage() { return getType().getDamage(); }
    
    @Override
    public double getBaseWeight() { return getType().getWeight(); }
    
    @Override
    public double getBaseCost() { return getType().getCost(); }
    
    @Override
    public String getTraits() { return getType().getTraits(); }
}
