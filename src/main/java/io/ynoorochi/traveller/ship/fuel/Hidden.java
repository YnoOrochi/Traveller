/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.fuel;

/**
 *
 * @author PR3J
 */
public class Hidden extends Options {
    
    /* ---------
    *  Jump Drive rating
    --------- */
    @Override
    public void setRating(int rating) {
        this.rating = rating;
        
        setOptiOn(rating > 0);
    }

    /* ---------
     *  Fuel Tank Weight
    --------- */
    @Override
    public int getWeight() {
        return getRating();
    }
    
    /* ---------
     *  Fuel Tank Cost
    --------- */
    @Override
    public int getCost() {
        return 40000 * getRating();
    }
}
