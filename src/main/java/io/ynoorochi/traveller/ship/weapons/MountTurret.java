/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.weapons;

import io.ynoorochi.traveller.ship.Groups;
import io.ynoorochi.traveller.ship.Items;
import io.ynoorochi.traveller.ship.weapons.Definitions.*;
import java.util.Iterator;

/**
 *
 * @author PR3J
 */
public class MountTurret extends Groups {
    /* ---------
     *  Constructor
    --------- */
    public MountTurret() { this(TurretTypes.SINGLE); }
    public MountTurret(TurretTypes type) { setType(type); }

    /* ---------
     *  Mount Type
    --------- */
    private TurretTypes type = TurretTypes.SINGLE;
    public TurretTypes getType() { return this.type; }

    /* changes if there is sufficient slots for already mounted weapons */
    public void setType(TurretTypes type) { 
        if (type.getSlots() >= countItems()) this.type = type; 
    }

    /* ---------
     *  Items Manipulation - Lists
    --------- */
    @Override
    public void addItem(Items item) {
        /*  only TurretWeapons and PersonelWeapons allowed
                anti-personel weapons use half slot         */
        if ( (  item.getClass().equals(TurretWeapon.class) ||
                item.getClass().equals(AntiPersonelWeapon.class) ) &&
                (item.getClass().equals(AntiPersonelWeapon.class) ? 0.5 : 1) +
                    countItems() <= getType().getSlots() ) 
            super.addItem(item);
    }

    /* anti-personel weapons counts as 1/2 item */
    @Override
    public int countItems() { 
        int count = 0;
        Iterator<Items> iter = getItems().iterator();
        while (iter.hasNext()) {
            Items i = iter.next();
            count += (i.getClass().equals(AntiPersonelWeapon.class) ? 0.5 : 1);
        }
        return count; 
    }

    /* ---------
    *  Best Tech Level
    --------- */
    @Override
    public int getTL() { 
        int tl = getType().getTL();
        for (var obj : getItems() ) { tl = Math.max(tl, obj.getTL()); }
        return tl;
    }

    /* ---------
    *  Total Weight
    --------- */
    @Override
    protected double getBaseWeight() { 
        double aux = getType().getWeight();
        for (var obj : getItems() ) { aux += obj.getWeight(); }
        return aux;
    }

    /* ---------
    *  Total Power
    --------- */
    @Override
    public double getPower() { 
        int aux = getType().getPower();
        for (var obj : getItems() ) { aux += obj.getPower(); }
        return aux;
    }

    /* ---------
    *  Total Cost
    --------- */
    @Override
    protected double getBaseCost() { 
        double aux = getType().getCost();
        for (var obj : getItems() ) { aux += obj.getCost(); }
        return aux;
    }

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append("{").append(getType());
        sb.append(", TL=").append(getTL());
        sb.append(", Weight=").append(getWeight());
        sb.append(", Power=").append(getPower());
        sb.append(", Cost=").append(getCost());
        sb.append("}");
        for (var obj : getItems()) 
            sb.append("\n    ").append(obj.toString());
        return sb.toString();
    }
}
