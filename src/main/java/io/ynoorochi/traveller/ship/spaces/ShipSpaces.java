/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.spaces;

import io.ynoorochi.traveller.ship.Items;
import io.ynoorochi.traveller.ship.spaces.Definitions.RoomType;

/**
 *
 * @author PR3J
 */
public class ShipSpaces extends Items {
     /* ---------
     *  Constructor
    --------- */
    public ShipSpaces(RoomType room, int qtty) {
        setRoomType(room);
        setQtty(qtty);
    }

    /* ---------
     *  Room
    --------- */
    private RoomType room = RoomType.NONE;
    public RoomType getRoomType() { return room; }
    protected void setRoomType(RoomType room) { this.room = room; }

    /* ---------
    *  Option setter
    *      returns the operation result
    *      false means: the option has some constraint that was not observed
    --------- */
    @Override
    public boolean setOptiOn(boolean opt) {
        setQtty(opt ? 1 : 0);
        return true;
    }
    /* ---------
     *  Tech Level
    --------- */
    @Override
    public int getTL() { return (isOptiOn() ? getRoomType().getTL() : 0); }

    /* ---------
     *  Tonnage Used by Option
    --------- */
    @Override
    public double getWeight() { return getQtty() * getRoomType().getWeight(); }
    
    /* ---------
     *  Power used
    --------- */
    @Override
    public double getPower() { return getQtty() * getRoomType().getPower(); }

    /* ---------
     *  Option Life Support
    --------- */
    public double getLifeSupport() { return getQtty() * getRoomType().getLfSup();
    }
    
    /* ---------
     *  Option Passenger
    --------- */
    public double getPassengers() { return getQtty() * getRoomType().getPassengers(); }
    
    /* ---------
     *  Option Cost
    --------- */
    @Override
    public double getCost() { 
        return (1 + getHardened()) * getQtty() * getRoomType().getCost(); 
    }
    
    /* ---------
    *  Option Get Name
    --------- */
    @Override
    public String getName() { return getRoomType().getName(); }
    
    /* ---------
    *  Input quantity of this room 
    *       Rating
    --------- */
    public int getQtty() { return (int) getAttribute(); }
    public void setQtty(int qtty) {
        setAttribute(qtty);
        super.setOptiOn(qtty > 0);
    }

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append("{").append(getQtty());
        if (isOptiOn()) {
            sb.append(", TL=").append(getTL());
            sb.append(", Weight=").append(getWeight());
            sb.append(", Power=").append(getPower());
            sb.append(", Life Support=").append(getLifeSupport());
            sb.append(", Passengers=").append(getPassengers());
            sb.append(", Cost=").append(getCost());
            if (isHardened()) sb.append(", Hardened");
        }
        sb.append('}');
        return sb.toString();
    }
}
