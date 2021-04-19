/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.hull.options;

/**
 *
 * @author PR3J
 */
public class ArmBulkhead extends Options {
    /* ---------
    *  Bulkhead Tonnage
    --------- */
    private int bulkTon = 0;
    
    public int getBulkTon() {
        return bulkTon;
    }

    public void setBulkTon(int bulkTon) {
        if (bulkTon > 0) {
            this.bulkTon = bulkTon;
            setOptiOn(true);
        } else {
            this.bulkTon = 0;
            setOptiOn(false);
        }
    }

    /* ---------
    *  Tonnage Used by Option
    --------- */
    @Override
    public double getWeight() {
        return 0.1 * getBulkTon();
    }

    /* ---------
    *  Option Specific Cost
    --------- */
    @Override
    public int getCost() {
        return 200000 * getBulkTon();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append("(");
        sb.append(bulkTon).append(" Ton");
        sb.append(", Weight=").append(getWeight());
        sb.append(", Cost=").append(getCost());
        sb.append('}');
        return sb.toString();
    }

}
