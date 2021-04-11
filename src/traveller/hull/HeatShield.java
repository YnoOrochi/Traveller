/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveller.hull;

/**
 *
 * @author PR3J
 */
public class HeatShield extends Options {

    public HeatShield(int size) {
        super(size);
    }
    
    @Override
    public int getOptTL() {
        if (isOption()) return 6;
        else return 0;
    }
    
    @Override
    public int getOptCost() {
        if (isOption()) return 100000;
        else return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Option(HeatShield=").append(isOption());
        if (getOptTL() != 0) sb.append(", TL=").append(getOptTL());
        if (getOptCost() != 0) sb.append(", Cost=").append(getOptCost());
        sb.append('}');
        return sb.toString();
    }
}
