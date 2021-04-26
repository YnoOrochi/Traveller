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
public class Software {
    /* ---------
     *  Constructor
    --------- */
    private int maxBW = 5;
    private double jump = 0;
    
    public Software(int maxBW, double jump) {
        this.maxBW = maxBW;
        this.jump = jump;
    }

    /* ---------
    *  Default Softwares
    --------- */
    private JumpControl jCtrl = new JumpControl(maxBW, jump);
    
    /* ---------
    *  Other Softwares
    --------- */
    private FireControl fCtrl = new FireControl(maxBW);
    
    
    /* ---------
    *  Softwares list
    --------- */
    private final BaseSW[] softwares = {
        jCtrl, fCtrl 
    };
    
    public BaseSW[] getSoftwares() {
        return softwares;
    }
    
    /* ---------
    *  Bandwidth
    --------- */
    public int getTotBW() { 
        int bw = 0;
        for (var soft : getSoftwares() ) {
            bw += soft.getBW();
        }
        return bw;
    }

    /* ---------
    *  Tech Level
    --------- */
    public int getTL() { 
        int tl = 0;
        for (var soft : getSoftwares() ) {
            tl = Math.max(tl, soft.getTL());
        }
        return tl;
    }

    /* ---------
    *  Bandwidth
    --------- */
    public int getCost() { 
        int cost = 0;
        for (var soft : getSoftwares() ) {
            cost += soft.getCost();
        }
        return cost;
    }

    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sensors {");
        sb.append("TL=").append(getTL());
        sb.append(", Cost=").append(getCost());
        sb.append(", Total Bandwidth=").append(getTotBW());
        sb.append("}\n");
        for (var soft : getSoftwares()) 
            sb.append("    ").append(soft.toString()).append("\n");
        return sb.toString();
    }
}
