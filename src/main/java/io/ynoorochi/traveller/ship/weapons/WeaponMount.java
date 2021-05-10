/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.weapons;

import io.ynoorochi.traveller.ship.Groups;
import io.ynoorochi.traveller.ship.weapons.Definitions.*;

/**
 *
 * @author PR3J
 */
public class WeaponMount extends Groups {
    /* ---------
     *  Constructor
    --------- */
    public WeaponMount(MountTypes type) {
        type.
    }

    /* ---------
     *  Mount Type
    --------- */
    private MountTypes type = MountTypes.SINGLE;
    public MountTypes getType() { return this.type; }
    public void setType(MountTypes type) { this.type = type; }

    /* ---------
     *  Mount Slots
    --------- */
    private TurretWeapons[] slots = new TurretWeapons[3];
    private TurretWeapons getWeapon(int slot) {
        if (slot > getType().)
    }
    
    
}
