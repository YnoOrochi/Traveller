/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.weapons;

import io.ynoorochi.traveller.ship.weapons.Definitions.TurretWeapons;
import io.ynoorochi.traveller.ship.weapons.Definitions.WeaponRanges;

/**
 *
 * @author PR3J
 */
public class TurretWeapon extends Weapon {
    /* ---------
     *  Constructor
    --------- */
    public TurretWeapon() { this(TurretWeapons.EMPTY); }
    public TurretWeapon(TurretWeapons type) { setType(type); }

    /* ---------
     *  Type
    --------- */
    private TurretWeapons type = TurretWeapons.EMPTY;
    public TurretWeapons getType() { return this.type; }
    public void setType(TurretWeapons type) { this.type = type; }

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
