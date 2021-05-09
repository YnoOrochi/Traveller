/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author PR3J
 */
public class Groups extends Items {
    /* ---------
     *  Items Manipulation - Lists
    --------- */
    private List<Items> itemList = new ArrayList<>();
    public void addItem(Items item) { this.itemList.add(item); }
    public void delItem(Items item) { this.itemList.remove(item); }
    public List<Items> getItems() { return itemList; }
    
    /* Get one specific item ... */
    public Items getItem(int index) { return itemList.get(index); }
    public Items getItem(String classe) { 
        Iterator<Items> iter = itemList.iterator();
        while (iter.hasNext()) {
            Items i = iter.next();
            if (i.getClass().getSimpleName().equals(classe)) { return i; }
        }
        return null; 
    }
    
    /* ---------
    *  Best Tech Level
    --------- */
    @Override
    public int getTL() { 
        int tl = 0;
        for (var obj : getItems() ) { tl = Math.max(tl, obj.getTL()); }
        return tl;
    }

    /* ---------
    *  Total Weight
    --------- */
    @Override
    protected double getBaseWeight() { 
        double aux = 0;
        for (var obj : getItems() ) { aux += obj.getWeight(); }
        return aux;
    }

    /* ---------
    *  Total Power
    --------- */
    @Override
    public double getPower() { 
        int aux = 0;
        for (var obj : getItems() ) { aux += obj.getPower(); }
        return aux;
    }

    /* ---------
    *  Total Cost
    --------- */
    @Override
    protected double getBaseCost() { 
        double aux = 0;
        for (var obj : getItems() ) { aux += obj.getCost(); }
        return aux;
    }

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append("{");
        sb.append("TL=").append(getTL());
        sb.append(", Weight=").append(getWeight());
        sb.append(", Power=").append(getPower());
        sb.append(", Cost=").append(getCost());
        sb.append("}");
        for (var obj : getItems()) 
            sb.append("\n    ").append(obj.toString());
        return sb.toString();
    }
}
