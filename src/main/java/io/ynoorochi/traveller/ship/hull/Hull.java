/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.hull;

import io.ynoorochi.traveller.ship.Items;
import io.ynoorochi.traveller.ship.hull.options.*;
import static io.ynoorochi.traveller.ship.hull.Definitions.*;
import java.util.Arrays;

/**
 *
 * @author PR3J
 */
public class Hull {
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
     *  Array Manipulation
    --------- */
    private Items[] itemList = {};
    
    public void addItem(Items item) {
        itemList = Arrays.copyOf(itemList, itemList.length + 1);
        itemList[itemList.length - 1] = item;
    }
    
    public void delItem(Items item) {
        int pos = Arrays.binarySearch(itemList, item);
        if (pos >= 0) {
            if (itemList.length > pos + 1)
                for (int i=pos; i<itemList.length - 1; i++) {
                    itemList[i] = itemList[i+1];
                }
            itemList = Arrays.copyOf(itemList, itemList.length - 1);
        }
    }

    public Items[] getItems() { return itemList; }

    /* ---------
     *  Add Other Hull Equipments
    --------- */
    private void otherItems() {
        addItem(new Armour());
        addItem(new ArmBulkhead());
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
    public int setHullSize(int size) {
        this.hullSize = Math.max(size, MIN_HULL);
        for (var opt : getItems()) {
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
        
        for (var opt : getItems()) {
            othr += opt.getCost();
            modf += opt.getCostModf();
        }

        return getHullSize() * ((getItems()[0].getCost() * modf) + othr);
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
        for (var opt : getItems()) {
            hpModf += opt.getAttModf();
        }
        
        return (int) (hpModf * getHullSize() / hp);
    }
    
    /* ---------
    *  Hull TL
    --------- */
    public int getTL() {
        int tl = 0;
        for (var opt : getItems()) {
            tl = Math.max(tl, opt.getTL());
        }
        return tl;
    }
    
    /* ---------
    *  Hull Weight
    --------- */
    public int getWeight() {
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
        sb.append("}\n");
        for (var opt : getItems()) {
            sb.append("    ").append(opt).append("\n");
        }
        return sb.toString();
    }
}
