/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.accomodations;

/**
 *
 * @author PR3J
 */
public class Rooms {
    /* ---------
     *  Create Basic Rooms
    --------- */
    public LowBerth lBerth = new LowBerth();
    public EmergencyLowBerth eBerth = new EmergencyLowBerth();
    public Cabins cabins = new Cabins();
    public Staterooms sRooms = new Staterooms();
    public DoubleRooms dRooms = new DoubleRooms();
    public HighStaterooms hRooms = new HighStaterooms();
    public LuxuryStaterooms lRooms = new LuxuryStaterooms();
    public CommonAreas common = new CommonAreas();
    public AccelerationBenches aBench = new AccelerationBenches();
    public AccelerationSeats aSeats = new AccelerationSeats();
    public Barracks barrack = new Barracks();
    public Brig brig = new Brig();
    public MultiEnvironment mEnvro = new MultiEnvironment();
    public Biosphere bSphre = new Biosphere();
    public Stables stable = new Stables();
    
    /* ---------
     *  Create Aditional Rooms
    --------- */
    public Armories armory = new Armories();
    public BriefingRoom briefg = new BriefingRoom();
    public ConcealedCompartment cnceal = new ConcealedCompartment();
    public ConstructionDeck ctDeck = new ConstructionDeck();
    public GamingRoom gaming = new GamingRoom();
    public GravScreen gravSc = new GravScreen();
    public Laboratory labtry = new Laboratory();
    public Library librry = new Library();
    public MedicalBay medbay = new MedicalBay();
    public PsyonStateroom psyons = new PsyonStateroom();

    /* ---------
    *  Rooms list
    --------- */
    private final RoomItems[] rooms = {
        lBerth, eBerth, cabins, sRooms, dRooms, hRooms, lRooms, common,
        aBench, aSeats, barrack, brig, mEnvro, bSphre, stable, armory,
        briefg, cnceal, ctDeck, gaming, gravSc, labtry, librry, medbay,
        psyons
    };
    
    public RoomItems[] getRooms() {
        return this.rooms;
    }
    
    /* ---------
    *  Rooms best Tech Level
    --------- */
    public int getTL() { 
        int tl = 0;
        for (var room : getRooms() ) {
            tl = Math.max(tl, room.getTL());
        }
        return tl;
    }

    /* ---------
    *  Total Rooms Weight
    --------- */
    public double getWeight() { 
        double aux = 0;
        for (var room : getRooms() ) {
            aux += room.getWeight();
        }
        return aux;
    }

    /* ---------
    *  Total Rooms Power
    --------- */
    public int getPower() { 
        int aux = 0;
        for (var room : getRooms() ) {
            aux += room.getPower();
        }
        return aux;
    }

    /* ---------
    *  Total Rooms Life Support
    --------- */
    public int getLifeSupport() { 
        int aux = 0;
        for (var room : getRooms() ) {
            aux += room.getLifeSupport();
        }
        return aux;
    }

    /* ---------
    *  Total Rooms Cost
    --------- */
    public int getPassengers() { 
        int aux = 0;
        for (var room : getRooms() ) {
            aux += room.getPassengers();
        }
        return aux;
    }

    /* ---------
    *  Total Rooms Cost
    --------- */
    public double getCost() { 
        double aux = 0;
        for (var room : getRooms() ) {
            aux += room.getCost();
        }
        return aux;
    }

    /* ---------
    *  Option Get Name
    --------- */
    public String getName() {
        return this.getClass().getSimpleName();
    }
    
    /* ---------
     *  toString
    --------- */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append("{");
        sb.append("TL=").append(getTL());
        sb.append(", Weight=").append(getWeight());
        sb.append(", Power=").append(getPower());
        sb.append(", Life Support=").append(getLifeSupport());
        sb.append(", Passengers=").append(getPassengers());
        sb.append(", Cost=").append(getCost());
        sb.append("}\n");
        for (var room : getRooms()) 
            sb.append("    ").append(room.toString()).append("\n");
        return sb.toString();
    }
}
