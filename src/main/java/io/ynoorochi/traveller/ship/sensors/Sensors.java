/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.sensors;

import io.ynoorochi.traveller.ship.Groups;

/**
 *
 * @author PR3J
 */
public class Sensors extends Groups {
    /* ---------
     *  Constructor
    --------- */
    public Sensors(int hullSize) {
        setHullSize(hullSize);
        addItem(new Base());
        
        otherItems();
    }

    /* ---------
     *  Adiciona todos os sensores
    --------- */
    private void otherItems() {
        addItem(new Countermeasures());
        addItem(new DeepPenetration());
        addItem(new DistArrays(getHullSize()));
        addItem(new ExtensionNet(getHullSize()));
        addItem(new LifeScanner());
        addItem(new MailDistArray());
        addItem(new MineralDetection());
        addItem(new ShallowSuite());
        addItem(new SignalProcess());
    }
}
