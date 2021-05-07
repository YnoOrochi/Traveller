/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author PR3J
 */
public class Groups {
//    /* ---------
//     *  Items Manipulation - Arrays
//    --------- */
//    private Items[] itemList = {};
//    
//    public void addItem(Items item) {
//        itemList = Arrays.copyOf(itemList, itemList.length + 1);
//        itemList[itemList.length - 1] = item;
//    }
//    
//    public void delItem(Items item) {
//        int pos = Arrays.binarySearch(itemList, item);
//        if (pos >= 0) {
//            if (itemList.length > pos + 1)
//                for (int i=pos; i<itemList.length - 1; i++) {
//                    itemList[i] = itemList[i+1];
//                }
//            itemList = Arrays.copyOf(itemList, itemList.length - 1);
//        }
//    }
//
//    public Items[] getItems() { return itemList; }
//    public Items getItem(int index) { return itemList[index]; }

    /* ---------
     *  Items Manipulation - Lists
    --------- */
    private List<Items> itemList = new ArrayList<>();
    public <S> void addItem(Items item) { this.itemList.add(item); }
    public <S> void delItem(Items item) { this.itemList.remove(item); }
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
     * Attribute
    --------- */
    private int attribute;
    protected int getAttribute() { return this.attribute; }
    protected void setAttribute(int hullSize) { this.attribute = attribute; }

    /* ---------
    *  Best Tech Level
    --------- */
    public int getTL() { 
        int tl = 0;
        for (var obj : getItems() ) { tl = Math.max(tl, obj.getTL()); }
        return tl;
    }

    /* ---------
    *  Total Weight
    --------- */
    public double getWeight() { 
        double aux = 0;
        for (var obj : getItems() ) { aux += obj.getWeight(); }
        return aux;
    }

    /* ---------
    *  Total Power
    --------- */
    public int getPower() { 
        int aux = 0;
        for (var obj : getItems() ) { aux += obj.getPower(); }
        return aux;
    }

    /* ---------
    *  Total Cost
    --------- */
    public double getCost() { 
        double aux = 0;
        for (var obj : getItems() ) { aux += obj.getCost(); }
        return aux;
    }

    /* ---------
    *  Option Get Name
    --------- */
    public String getName() { return this.getClass().getSimpleName(); }
    
    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append("{");
        sb.append("TL=").append(getTL());
        sb.append(", Weight=").append(getWeight());
        sb.append(", Cost=").append(getCost());
        sb.append("}\n");
        for (var obj : getItems()) 
            sb.append("    ").append(obj.toString()).append("\n");
        return sb.toString();
    }
}
