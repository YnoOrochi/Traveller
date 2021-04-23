/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.hull;

import io.ynoorochi.traveller.ship.Items;
import io.ynoorochi.traveller.ship.hull.options.*;
import static io.ynoorochi.traveller.ship.hull.Definitions.*;

/**
 *
 * @author PR3J
 */
public class Hull {
    
    private final int MIN_HULL = 10;
    private int hullSize;
    
    /* ---------
    *  Hull Equipment
    --------- */
    private Configuration config = new Configuration(MIN_HULL);
    private Type type = new Type();
    private Bridge bridge = new Bridge();
    private Armour armour = new Armour();
    private ArmBulkhead armBulk = new ArmBulkhead();
    private Coating coat = new Coating();
    private NonGHull nonGHull = new NonGHull();
    private DoubleHull dblHull = new DoubleHull();
    private HamsterCase hmsCase = new HamsterCase();
    private EAGrid eAGrid = new EAGrid();
    private HeatShield hShield = new HeatShield();
    private RadShield rShield = new RadShield();
    private Breakaway breakaway = new Breakaway();

    public Items[] hullOpt = { config, type, coat, bridge, armour, armBulk,
        nonGHull, dblHull, hmsCase, eAGrid, hShield, rShield, breakaway
    };
    
    /* ---------
    *  Hull Constructor
    --------- */
    public Hull(HullConfiguration config, int size) {
        this.setHullSize(size);
        this.config.setConfig(config);
    }
    
    /* ---------
    *  Hull Size
    --------- */
    public int setHullSize(int size) {
        this.hullSize = Math.max(size, MIN_HULL);
        for (var opt : hullOpt) {
            opt.setHullSize(this.hullSize);
        }
        return this.hullSize;
    }
    
    public int getHullSize() {
        return this.hullSize;
    }

    /* ---------
    *  Method: Hull cost
    --------- */
    public double getCost() {
        double othr = 0;
        double modf = 0;
        
        for (var opt : hullOpt) {
            othr += opt.getCost();
            modf += opt.getCostModf();
        }

        return getHullSize() * ((config.getCost() * modf) + othr);
    }
    
    /* ---------
    *  Hull Basic Systems Power
    *       20% of the total tonnage of the hull.
    --------- */
    public double getPower() {
        return 0.2 * getHullSize();
    }
    
    /* ---------
    *  Hull Points
    --------- */
    public int getHP() {
        double hp;
        if (getHullSize() <= 25000)           hp = 2.5;
            else if (getHullSize() <= 100000) hp = 2;
                else                          hp = 1.5;

        double hpModf = 1;
        for (var opt : hullOpt) {
            hpModf += opt.getAttModf();
        }
        
        return (int) (hpModf * getHullSize() / hp);
    }
    
    /* ---------
    *  Hull TL
    --------- */
    public int getTL() {
        int tl = 0;
        for (var opt : hullOpt) {
            tl = Math.max(tl, opt.getTL());
        }
        return tl;
    }
    
    /* ---------
    *  Hull Weight
    --------- */
    public int getWeight() {
        double usedTon = 0;
        for (var opt : hullOpt) {
            usedTon += opt.getWeight();
        }
        return (int) Math.ceil(usedTon);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hull{Cost=").append(getCost());
        sb.append(", HP=").append(getHP());
        sb.append(", TL=").append(getTL());
        sb.append(", Weight=").append(getWeight());
        sb.append("}\n");
        for (var opt : hullOpt) {
            sb.append("    ").append(opt).append("\n");
        }
        return sb.toString();
    }
}
