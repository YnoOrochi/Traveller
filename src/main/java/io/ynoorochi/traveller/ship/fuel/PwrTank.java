/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.fuel;

import io.ynoorochi.traveller.ship.Items;
import io.ynoorochi.traveller.ship.equip.Definitions.*;

/**
 *
 * @author PR3J
 */
public class PwrTank extends Items {
    /* ---------
    *  Atributes
    --------- */
    private PwrPlants type;

    /* ---------
    *  Constructor
    --------- */
    public PwrTank(PwrPlants type, double size, int weeks) {    
        this.setType(type);
        this.setPlantSize(size);
        this.setAutonomy(weeks);

        setOptiOn(true);
    }

    /* ---------
     *  Power Plant Fuel
     *       Chemical power plants require 10 (5) tons of fuel per ton of
     *       power plant for every two time (week) of operation.
     *       Other power plants require fuel tankage equal to 10% (2.5%) of
     *       their plantSize (rounding up, minimum 1 ton) per month (week).
    --------- */
    @Override
    public double getWeight() {
        switch (getType()) {
            case Chemical: return 5 * getAutonomy();
            default: return Math.ceil(0.025 * getPlantSize() * getAutonomy());
        }
    }
    
    public double getWeight(PwrPlants type, double size, int weeks) {
        this.setType(type);
        this.setPlantSize(size);
        this.setAutonomy(weeks);
        
        return getWeight();
    }

    /* ---------
    *  Power Plant Type
    --------- */
    public PwrPlants getType() {
        return this.type;
    }

    public void setType(PwrPlants type) {
        this.type = type;
    }

    /* ---------
    *  Power Plant Size
    --------- */
    public double getPlantSize() {
        return getAttribute();
    }

    public void setPlantSize(double size) {
        if (size >= 0) setAttribute(size);
    }

    /* ---------
    *  Autonomy
    --------- */
    public int getAutonomy() {
        return getIntAtt();
    }
    
    public void setAutonomy(int weeks) {
        if (weeks >= 0) setIntAtt(weeks);
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PwrTank{weight=").append(getWeight());
        sb.append(", Weeks=").append(getAutonomy());
        sb.append('}');
        return sb.toString();
    }
}
