/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.computer;

/**
 *
 * @author PR3J
 */
public abstract class SoftItems {

    /* ---------
     *  Name Attribute
    --------- */
    private String name = "Software";
    public String getName() { return this.name; }
    protected void setName(String name) { this.name = name; }

    /* ---------
     *  Maximum Bandwidth
    --------- */
    private int maxBW = 5;
    public int getMaxBW() { return this.maxBW; }
    public void setMaxBW(int max) { this.maxBW = max; }
    
    /* ---------
    *  isOptiOn
    --------- */
    public abstract boolean isOptiOn();

    /* ---------
     *  Version Attribute
    --------- */
    public abstract Object getVersion();
    public abstract boolean setVersion(double ver);

    /* ---------
    *  Get Methods
    --------- */
    public abstract int getTL();
    public abstract int getBW();
    public abstract double getCost();

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append("(").append(getVersion());
        if (isOptiOn()) {
            sb.append(", BW=").append(getBW());
            sb.append(", TL=").append(getTL());
            sb.append(", Cost=").append(getCost());
        }
        sb.append('}');
        return sb.toString();
    }

    
}
