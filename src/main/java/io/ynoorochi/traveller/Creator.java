/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller;

import io.ynoorochi.traveller.ship.SpaceShip;
import static io.ynoorochi.traveller.ship.Customization.*;

/**
 *
 * @author PR3J
 */
public class Creator {

    /*
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
//        System.out.println(a.toString());

//  VER SINTAXE DISSO
//        traveller.hull.options.Options opt;
//        for (traveller.hull.options.Options opt in a.hull.hullOpt) {
        final var opts = a.hull.hullOpt;

        for (var opt : opts) {
            System.out.println(opt.toString());
        }

        System.out.println(a.mDrive);
        System.out.println(a.jDrive);
        System.out.println(a.pwrPlant);


        System.out.println("HullSize:" + a.hull.getHullSize());
        System.out.println("HullCost:" + a.hull.getCost());
        System.out.println(a.hull.toString());
    }
}
