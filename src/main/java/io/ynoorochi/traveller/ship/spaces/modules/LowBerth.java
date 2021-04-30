/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.spaces.modules;

import io.ynoorochi.traveller.ship.spaces.Definitions.RoomType;
import io.ynoorochi.traveller.ship.spaces.RoomItems;
import io.ynoorochi.traveller.ship.spaces.RoomItems;

/**
 *
 * @author PR3J
 */
public class LowBerth extends RoomItems {
    /* ---------
     *  Room
    --------- */
    public LowBerth() {
        setRoomType(RoomType.LBERTH);
        setQtty(0);
    }
}
