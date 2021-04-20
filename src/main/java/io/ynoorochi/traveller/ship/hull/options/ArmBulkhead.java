/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.hull.options;

import io.ynoorochi.traveller.ship.Items;

/**
 *
 * @author PR3J
 */
public class ArmBulkhead extends Items {
    /* ---------
    *  Bulkhead Tonnage
    --------- */
    public void setWeight(double tonnage) {
        if (tonnage > 0) {
            setAttribute(tonnage);
            setOptiOn(true);
        } else {
            setAttribute(0);
            setOptiOn(false);
        }
    }

    /* ---------
    *  Tonnage Used by Option
    --------- */
    @Override
    public double getWeight() {
        return 0.1 * getAttribute();
    }

    /* ---------
    *  Option Specific Cost
    --------- */
    @Override
    public double getCost() {
        return 200000 * getAttribute();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append("(");
        sb.append(getAttribute()).append(" Ton");
        sb.append(", Weight=").append(getWeight());
        sb.append(", Cost=").append(getCost());
        sb.append('}');
        return sb.toString();
    }

}
