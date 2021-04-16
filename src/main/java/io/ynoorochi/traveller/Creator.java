/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller;

import static java.lang.System.in;
import static io.ynoorochi.traveller.Customization.*;

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
//        System.out.println(a.toString());

//  VER SINTAXE DISSO
//        traveller.hull.options.Options opt;
//        for (traveller.hull.options.Options opt in a.cHull.hullOpt) {
        for (int i = 0; i < 11; i++) {
            System.out.println(a.cHull.hullOpt[i].toString());
        }
        System.out.println(a.mDrive);
        System.out.println(a.jDrive);


        System.out.println("HullSize:" + a.cHull.getHullSize());
        System.out.println(a.cHull.toString());
    }
}
