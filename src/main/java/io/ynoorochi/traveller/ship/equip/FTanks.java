/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.equip;

/**
 *
 * @author PR3J
 */
public class FTanks extends Equipment {
    /* ---------
    *  Constructor
    --------- */
//    public FTanks(JDriveTypes type, int rating, int size) {
//        this.setType(type);
//        this.setRating(rating);
//        this.setHullSize(size);
//    }
    public FTanks() {
        
    }

    /* ---------
    *  Maneuver Fuel
    *       Maneuver does not use fuel.
    *       Reaction: 2.5% of ship tonnage per Thrust per hour
    *           In combat, it is convenient to multiply the Thrust the
    *           ship is capable of by the number of hours it can operate,
    *           and then multiply that again by 10 to obtain a Thrust
    *           Point Total (10 combat rounds per hour).
    --------- */

    /* ---------
    *  Jump Fuel
    *       10% of the total tonnage of the ship, multiplied by the
    *       maximum jump score of the drive, per jump.
    --------- */

    /* ---------
    *  Power Plant Fuel
    *       Chemical power plants require 10 tons of fuel per ton of
    *       power plant for every two weeks of operation.
    *       Other power plants require fuel tankage equal to 10% of
    *       their size (rounding up, minimum 1 ton) per month.
    --------- */

}
