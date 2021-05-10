/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship;

/**
 *
 * @author rslima
 */
public class Definitions {
    /* ---------
    *  Customization Enum
    --------- */
    public enum Customization {
        CUSTOMIZED(   1.01),
        OFF_THE_SHELF(0.9);
        
        private final double modf;
        
        private Customization(double modf) {
            this.modf = modf;
        }
        
        public double getCostModf() {
            return this.modf;
        }
    }
}