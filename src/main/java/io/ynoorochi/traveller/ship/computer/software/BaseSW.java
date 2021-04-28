/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.computer.software;

/**
 *
 * @author PR3J
 */
public abstract class BaseSW {

    /* ---------
     *  Attributes
    --------- */
    private int maxBW = 5;
    private int bis = 0;
    private int jump = 0;

    /* ---------
     *  Maximum Bandwidth
    --------- */
    public int getMaxBW() { 
        System.out.println("Passei no get:" + maxBW);
        return this.maxBW; }
    public void setMaxBW(int max) { 
        System.out.println("Passei no set:" + max);
        this.maxBW = max; }
    
    /* ---------
     *  /bis modifier
    --------- */
    public int getBIS() { return this.bis; }
    public void setBIS(int bis) { this.bis = bis; }

    /* ---------
     *  Jump Rating
    --------- */
    public int getJump() { return this.jump; }
    public void setJump(double jump) { this.jump = (int) jump; }
    
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
        sb.append(this.getClass().getSimpleName()).append("(").append(getVersion());
        if (isOptiOn()) {
            sb.append(", BW=").append(getBW());
            sb.append(", TL=").append(getTL());
        }
        sb.append('}');
        return sb.toString();
    }

    
}
