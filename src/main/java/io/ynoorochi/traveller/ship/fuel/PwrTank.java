/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.fuel;

import io.ynoorochi.traveller.ship.equip.Definitions.*;

/**
 *
 * @author PR3J
 */
public class PwrTank extends Options {
    /* ---------
    *  Atributes
    --------- */
    private PwrPlants type;
    private double plantSize;

    /* ---------
    *  Constructor
    --------- */
    public PwrTank(PwrPlants type, double size, int weeks) {    
        this.setType(type);
        this.setPlantSize(size);
        this.setTime(weeks);

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
    public int getWeight() {
        switch (getType()) {
            case Chemical: return 5 * getTime();
            default: return (int) Math.ceil(0.025 * getPlantSize() * getTime());
        }
    }
    
    public int getWeight(PwrPlants type, double size, int weeks) {
        this.setType(type);
        this.setPlantSize(size);
        this.setTime(weeks);
        
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
        return this.plantSize;
    }

    public void setPlantSize(double size) {
        this.plantSize = size;
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PwrTank{weight=").append(getWeight());
        sb.append(", Weeks=").append(getTime());
        sb.append('}');
        return sb.toString();
    }
}