/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.hull;

import io.ynoorochi.traveller.ship.hull.options.*;

import static io.ynoorochi.traveller.ship.hull.Definitions.*;

/**
 *
 * @author PR3J
 */
public class Hull {
    
    /* ---------
    *  Hull Constructor
    --------- */
    public Hull(int size) {
        this.setHullSize(size);
    }
    
    public Hull( int size,
                    HullType hullType,
                    CoatOptions coating,
                    HullConfiguration hullConfig,
                    boolean nonGravity,
                    int doubleHull,
                    int hamsterCase,
                    boolean eAGrid,
                    boolean heatShield,
                    boolean radShield,
                    boolean breakaway,
                    ArmourOptions armour) {
        this.setHullSize(size);
        this.type.setType(hullType);
        this.coat.setCoat(coating);
        this.config.setConfig(hullConfig);
        this.nonGHull.setOption(nonGravity);
        this.dblHull.setOption(doubleHull);
        this.hmsCase.setOption(hamsterCase);
        this.eAGrid.setOption(eAGrid);
        this.hShield.setOption(heatShield);
        this.rShield.setOption(radShield);
        this.breakaway.setOption(breakaway);
        this.armour.setType(armour);
    }

    /* ---------
    *  Hull Options
    --------- */
    private Configuration config = new Configuration();
    private Type type = new Type();
    private Coating coat = new Coating();
    private NonGHull nonGHull = new NonGHull();
    private DoubleHull dblHull = new DoubleHull();
    private HamsterCase hmsCase = new HamsterCase();
    private EAGrid eAGrid = new EAGrid();
    private HeatShield hShield = new HeatShield();
    private RadShield rShield = new RadShield();
    private Breakaway breakaway = new Breakaway();
    private Armour armour = new Armour();

    public Options[] hullOpt = { 
        config, type, coat, nonGHull, dblHull, hmsCase, eAGrid, hShield,
            rShield, breakaway, armour
    };
    
    /* ---------
    *  Hull Size
    --------- */
    public int setHullSize(int size) {
        return config.setHullSize(size);
    }
    
    public int getHullSize() {
        return config.getHullSize();
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
        int size = getHullSize();

        double hp;
        if (size <= 25000) hp = 2.5 * size;
            else if (size <= 100000) hp = 2 * size;
                else hp = 1.5 * size;

        double hpModf = 1;
        for (var opt : hullOpt) {
            hpModf += opt.getHPModf();
        }
        
        return (int) (hpModf * hp);
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
        for (var opt : hullOpt) {
            sb.append(", ").append(opt);
        }
        sb.append('}');
        return sb.toString();
    }
}
