/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.fuel;

import io.ynoorochi.traveller.ship.systems.FuelProcessor;
import io.ynoorochi.traveller.ship.systems.FuelScoop;
import io.ynoorochi.traveller.ship.Groups;

/**
 *
 * @author PR3J
 */
public class OptTank extends Groups {
    /* ---------
     *  Constructor
    --------- */
    public OptTank() {
        addItem(new Hidden());
        addItem(new Collapsible());
        addItem(new Demountable());
        addItem(new Drop());
    }
}
