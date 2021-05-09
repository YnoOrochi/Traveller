/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.hull;

import io.ynoorochi.traveller.ship.Groups;
import io.ynoorochi.traveller.ship.hull.options.*;
import static io.ynoorochi.traveller.ship.hull.Definitions.*;

/**
 *
 * @author PR3J
 */
public class Hull extends Groups {
    /* ---------
     *  Attributes
    --------- */
    private final int MIN_HULL = 10;
    private int hullSize;
    
    /* ---------
     *  Constructor
    --------- */
    public Hull(HullConfiguration config, int size) {
        this.setHullSize(size);
        
        addItem(new Configuration(MIN_HULL, config));
        addItem(new Type());
        addItem(new Bridge());
        
        otherItems();
    }
    
    /* ---------
     *  Add Other Hull Equipments
    --------- */
    private void otherItems() {
        addItem(new Armour());
        addItem(new Coating());
        addItem(new NonGHull());
        addItem(new DoubleHull());
        addItem(new HamsterCase());
        addItem(new EAGrid());
        addItem(new HeatShield());
        addItem(new RadShield());
        addItem(new Breakaway());
    }
        
    /* ---------
    *  Hull Size
    --------- */
    @Override
    public void setHullSize(int size) {
        this.hullSize = Math.max(size, MIN_HULL);
        for (var opt : getItems()) {
            opt.setHullSize(this.hullSize);
        }
    }
    
    /* ---------
    *  Method: Hull cost
    --------- */
    @Override
    public double getCost() {
        double othr = 0;
        double modf = 0;
        
        for (var opt : getItems()) {
            othr += opt.getCost();
            modf += opt.getCostModf();
        }

        return getHullSize() * ((getItem(0).getCost() * modf) + othr);
    }
    
    /* ---------
    *  Hull Basic Systems Power
    *       20% of the total tonnage of the hull.
    --------- */
    @Override
    public double getPower() {
        return (int) Math.ceil(0.2 * getHullSize());
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
        for (var opt : getItems()) {
            hpModf += opt.getAttModf();
        }
        
        return (int) (hpModf * getHullSize() / hp);
    }
    
    /* ---------
    *  Hull Weight
    --------- */
    @Override
    public double getWeight() {
        double usedTon = 0;
        for (var opt : getItems()) {
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
        sb.append("}");
        for (var opt : getItems()) {
            sb.append("\n    ").append(opt);
        }
        return sb.toString();
    }
}
