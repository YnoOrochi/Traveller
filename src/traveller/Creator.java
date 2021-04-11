/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traveller;

import static traveller.Customization.OFF_THE_SHELF;

/**
 *
 * @author PR3J
 */
public class Creator {

    /**
     * Auxiliar methods
     */

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        SpaceShip a = new SpaceShip("A", "tst", 100, OFF_THE_SHELF);
        
//        a.changeCost(2345678);
//        a.changePower(50);
//        a.changeTon(33);
//        System.out.println(a.getHull().getHP());
        System.out.println(a.hull.hullOpt[3].toString());
        System.out.println(a.toString());
    }
    
}
