/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveller.hull.options;

import traveller.hull.Definitions.CoatOptions;
import static traveller.hull.Definitions.CoatOptions.*;

/**
 *
 * @author PR3J
 */
public class Coating extends Options {
    
    /* ---------
    *  Option constructor
    --------- */
    public Coating(int size) {
        super(size);
    }
    
    /* ---------
    *  Coating Options
    --------- */
    private CoatOptions coat = NONE;

    public CoatOptions getCoat() {
        return coat;
    }

    public void setCoat(CoatOptions coat) {
        this.coat = coat;
    }

    /* ---------
    *  have special coating?
    --------- */
    @Override
    public boolean isOption() {
        return this.coat != NONE;
    }
    
    /* ---------
    *  Tech Level
    --------- */
    @Override
    public int getOptTL() {
        return this.coat.getCoatTL();
    }
    
    /* ---------
    *  Option Specific Cost
    --------- */
    @Override
    public int getOptCost() {
        return this.coat.getCoatCost();
    }

    /* ---------
    *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Option(Coating=").append(this.coat.getCoatType());
        if (getOptTL() != 0) sb.append(", TL=").append(getOptTL());
        if (getOptCost() != 0) sb.append(", Cost=").append(getOptCost());
        sb.append('}');
        return sb.toString();
    }
}
