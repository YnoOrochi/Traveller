/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.spaces.modules;

import io.ynoorochi.traveller.ship.spaces.Definitions.RoomType;
import io.ynoorochi.traveller.ship.spaces.RoomItems;

/**
 *
 * @author PR3J
 */
public class Vaults extends RoomItems {
    /* ---------
     *  Room
    --------- */
    public Vaults() {
        setRoomType(RoomType.VAULTS);
        setQtty(0);
    }
}
