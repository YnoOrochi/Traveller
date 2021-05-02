/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.computer;

import io.ynoorochi.traveller.ship.computer.software.*;
import java.util.Arrays;

/**
 *
 * @author PR3J
 */
public class Softwares {
    /* ---------
     *  Constructor
    --------- */
    public Softwares(int max, int jmp) {
        setMaxBW(max);
        
        addItem(new JumpControl(jmp));
        addItem(new Maneouvre());
        addItem(new Library());
        
        otherItems(max);
    }

    /* ---------
     *  Array Manipulation
    --------- */
    private SoftItems[] itemList = {};
    
    public void addItem(SoftItems item) {
        itemList = Arrays.copyOf(itemList, itemList.length + 1);
        itemList[itemList.length - 1] = item;
    }
    
    public void delItem(SoftItems item) {
        int pos = Arrays.binarySearch(itemList, item);
        if (pos >= 3) {
            if (itemList.length > pos + 1)
                for (int i=pos; i<itemList.length - 1; i++) {
                    itemList[i] = itemList[i+1];
                }
            itemList = Arrays.copyOf(itemList, itemList.length - 1);
        }
    }

    public SoftItems[] getItems() { return itemList; }

    /* ---------
    *  Other Softwares for test
    --------- */
    private void otherItems(int max) {
        addItem(new Evade(max));
        addItem(new FireControl(max));
        addItem(new AdvFireControl(max));
        addItem(new LaunchSolution(max));
        addItem(new AntiHijack(max));
        addItem(new AutoRepair(max));
        addItem(new BattleSystem(max));
        addItem(new Intellect(max));
        addItem(new ConsciousIntel(max));
        addItem(new EletronicWar(max));
        addItem(new BroadSpectrumEW(max));
        addItem(new PointDefense(max));
        addItem(new ScreenOptimizer(max));
        addItem(new VirtualCrew(max));
        addItem(new VirtualGunner(max));
        addItem(new VirtualMining(max));
    }

    /* ---------
     *  Attribute MaxBandwith Allowed
    --------- */
    private int maxBW = 5;
    private int getMaxBW() { return this.maxBW; }
    public void setMaxBW(int max) { this.maxBW = max; }

    /* ---------
    *  Bandwidth
    --------- */
    public int getTotBW() { 
        int bw = 0;
        for (var soft : getItems() ) {
            bw += soft.getBW();
        }
        return bw;
    }

    /* ---------
    *  Tech Level
    --------- */
    public int getTL() { 
        int tl = 0;
        for (var soft : getItems() ) {
            tl = Math.max(tl, soft.getTL());
        }
        return tl;
    }

    /* ---------
    *  Bandwidth
    --------- */
    public int getCost() { 
        int cost = 0;
        for (var soft : getItems() ) {
            cost += soft.getCost();
        }
        return cost;
    }

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append("{");
        sb.append("TL=").append(getTL());
        sb.append(", Cost=").append(getCost());
        sb.append(", Total Bandwidth=").append(getTotBW());
        sb.append("}\n");
        for (var soft : getItems()) 
            sb.append("    ").append(soft.toString()).append("\n");
        return sb.toString();
    }
}
