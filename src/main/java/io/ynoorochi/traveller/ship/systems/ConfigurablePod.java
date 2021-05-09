/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.systems;

import io.ynoorochi.traveller.ship.Groups;
import io.ynoorochi.traveller.ship.Items;
import io.ynoorochi.traveller.ship.spaces.Definitions;
import io.ynoorochi.traveller.ship.spaces.SpaceItems;

/**
 *
 * @author PR3J
 */
public class ConfigurablePod extends Groups {
    /* ---------
     *  Constructor
    --------- */
    public ConfigurablePod() {
        setOptiOn(true);
        otherItems();
    }

    /* ---------
     *  Items Manipulation - Lists
    --------- */
    @Override
    public void addItem(Items item) { 
        double aux = 0;
        for (var obj : getItems() ) { aux += obj.getWeight(); }
        if (aux + item.getWeight() <= 10) super.addItem(item); 
    }

    /* ---------
    *  Total Weight
    --------- */
    @Override
    public double getBaseWeight() { return 10; }

    /* ---------
    *  Total Cost
    --------- */
    @Override
    public double getBaseCost() { 
        double aux = 250000;
        for (var obj : getItems() ) { aux += obj.getCost(); }
        return aux;
    }

    /* ---------
     *  Add all Available Spaces for test
    --------- */
    private void otherItems() {
        addItem(new SpaceItems(Definitions.RoomType.HROOMS, 1));
        addItem(new SpaceItems(Definitions.RoomType.MEDBAY, 1));
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
            sb.append("\n        ").append(obj.toString());
        return sb.toString();
    }
}
