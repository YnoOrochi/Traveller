/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.equip;

import static io.ynoorochi.traveller.ship.equip.Definitions.*;

/**
 *
 * @author PR3J
 */
public class PwrPlant extends Equipment {
    
    private PwrPlants type;
    private int rating;
    
    /* ---------
    *  Constructor
    --------- */
    public PwrPlant(PwrPlants type, int rating) {
        this.setType(type);
        this.setRating(rating);
    }

    /* ---------
    *  Power Plant Type
    --------- */
    public PwrPlants getType() {
        return type;
    }

    public void setType(PwrPlants type) {
        this.type = type;
    }

    /* ---------
    *  Power Plant Power Rating
    --------- */
    @Override
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    /* ---------
    *  Power Plant TL
    --------- */
    @Override
    public int getTL() {
        return getType().getTL();
    }
    
    /* ---------
    *  Power Plant Weight
    --------- */
    @Override
    public double getWeight() {
        return this.rating / getType().getRating();
    }
    
    /* ---------
    *  Power Plant Cost
    --------- */
    @Override
    public double getCost() {
        return getWeight() * getType().getCost();
    }

    /* ---------
    *  Power Plant Type
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PwrPlant{type=").append(type);
        sb.append(", Cost=").append(getCost());
        sb.append(", Rating=").append(rating);
        sb.append(", TL=").append(getTL());
        sb.append(", Weight=").append(getWeight());
        sb.append('}');
        return sb.toString();
    }
}
