/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.hull;

import static io.ynoorochi.traveller.hull.Definitions.*;
import io.ynoorochi.traveller.hull.options.*;

/**
 *
 * @author PR3J
 */
public class ClsHull {
    
    private final int OPT = 11;

    /* ---------
    *  Hull Size
    --------- */
    public void setHullSize(int size) {
        config.setHullSize(size);
    }
    
    public int getHullSize() {
        return config.getHullSize();
    }

    /* ---------
    *  Hull Constructor
    --------- */
    public ClsHull(int size) {
        this.setHullSize(size);
    }
    
    public ClsHull( int size,
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
        this.armour.setArmourType(armour);
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
//      0       1     2     3         4        5        6       7
        config, type, coat, nonGHull, dblHull, hmsCase, eAGrid, hShield,
//      8        10         11
        rShield, breakaway, armour
    };
    
    /* ---------
    *  Method: Hull cost
    --------- */
    public double getHullCost() {
        double base = hullOpt[0].getOptCost();
        double modf = 1 + hullOpt[0].getOptCostModf();
        double othr = 0;
        for (int i=1; i<OPT; i++) {
            othr += hullOpt[i].getOptCost();
            modf += hullOpt[i].getOptCostModf();
        }

        return config.getHullSize() * ((base * modf) + othr);
    }
    
    /* ---------
    *  Hull Armour
    --------- */
    
    
    /* ---------
    *  Hull Points
    --------- */
    public int getHP() {
        int size = config.getHullSize();

        double hp;
        if (size <= 25000) hp = 2.5 * size;
            else if (size <= 100000) hp = 2 * size;
                else hp = 1.5 * size;

        double hpModf = 1;
        for (int i=0; i<OPT; i++) {
            hpModf += hullOpt[i].getHPModf();
        }
        
        return (int) (hpModf * hp);
    }
    
    /* ---------
    *  Hull TL
    --------- */
    public int getTL() {
        int tl = 0;
        for (int i=0; i<OPT; i++) {
            tl = Math.max(tl, hullOpt[i].getOptTL());
        }
        return tl;
    }
    
    /* ---------
    *  Hull Weight
    --------- */
    public int getUsedTon() {
        double usedTon = 0;
        for (int i=0; i<OPT; i++) {
            usedTon += hullOpt[i].getOptUsedTon();
        }
        return (int) Math.ceil(usedTon);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ClsHull{Cost=").append(getHullCost());
        sb.append(", HP=").append(getHP());
        sb.append(", TL=").append(getTL());
        sb.append(", UsedTon=").append(getUsedTon());
        sb.append(", config=").append(config);
        sb.append(", type=").append(type);
        sb.append(", coat=").append(coat);
        sb.append(", nonGHull=").append(nonGHull.isOptiOn());
        sb.append(", dblHull=").append(dblHull);
        sb.append(", hmsCase=").append(hmsCase);
        sb.append(", eAGrid=").append(eAGrid.isOptiOn());
        sb.append(", hShield=").append(hShield.isOptiOn());
        sb.append(", rShield=").append(rShield.isOptiOn());
        sb.append(", Breakaway=").append(breakaway.isOptiOn());
        sb.append(", Armour=").append(armour);
        sb.append('}');
        return sb.toString();
    }
}
