/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.computer;

import io.ynoorochi.traveller.ship.computer.software.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
     *  Items Manipulation - Lists
    --------- */
    private List<SoftItems> itemList = new ArrayList<>();
    public void addItem(SoftItems item) { this.itemList.add(item); }
    public void delItem(SoftItems item) { this.itemList.remove(item); }
    public List<SoftItems> getItems() { return itemList; }
    
    /* Get one specific item ... */
    public SoftItems getItem(int index) { return itemList.get(index); }
    public SoftItems getItem(String classe) { 
        Iterator<SoftItems> iter = itemList.iterator();
        while (iter.hasNext()) {
            SoftItems i = iter.next();
            if (i.getClass().getSimpleName().equals(classe)) { return i; }
        }
        return null; 
    }

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
        sb.append("}");
        for (var soft : getItems()) 
            sb.append("\n    ").append(soft.toString());
        return sb.toString();
    }
}
