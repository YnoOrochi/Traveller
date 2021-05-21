/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ynoorochi.traveller.ship.weapons;

import static io.ynoorochi.traveller.ship.weapons.Definitions.WeaponRanges.*;

/**
 *
 * @author PR3J
 */
public class Definitions {

    /* ---------
     *  Hull MountPoints
    --------- */
    public enum Points {
        FIRMPOINT,
        HARDPOINT;
    }

    /* ---------
     *  Weapon Range
    --------- */
    public enum WeaponRanges {
        Adjacent,
        Short,
        Medium,
        Long,
        VeryLong,
        Special;
    }

    /* ---------
     *  FirmPoint Types
            Mount TL Power Tons Cost
            Fixed Mount - 0 0 MCr0.1
    --------- */
    public enum FirmTypes {
        FIXED("Fixed Mount",   0, 0, 0, 1,  100000),
        TURRT("Single Turret", 7, 1, 1, 1,  200000);

        private final String name;
        private final int tl;
        private final int power;
        private final int weight;
        private final int slots;
        private final double cost;

        private FirmTypes(String name, int tl, int power, int weight, 
                            int slots, double cost){
            this.name = name;
            this.tl = tl;
            this.power = power;
            this.weight = weight;
            this.slots = slots;
            this.cost = cost;
        }

        public String getName() { return name; }
        public int getTl() { return tl; }
        public int getPower() { return power; }
        public int getWeight() { return weight; }
        public int getSlots() { return slots; }
        public double getCost() { return cost; }
    }

    /* ---------
     *  Turret Types
            Mount TL Power Tons Cost
            Fixed Mount - 0 0 MCr0.1
            Single Turret 7 1 1 MCr0.2
            Double Turret 8 1 1 MCr0.5
            Triple Turret 9 1 1 MCr1
    --------- */
    public enum TurretTypes {
        FIXEDM("Fixed Mount",   0, 0, 0, 1,  100000),
        SINGLE("Single Turret", 7, 1, 1, 1,  200000),
        DOUBLE("Double Turret", 8, 1, 1, 2,  500000),
        TRIPLE("Triple Turret", 9, 1, 1, 3, 1000000),
        QUAD  ("Quad Turret",  12, 2, 1, 4, 2000000);

        private final String name;
        private final int tl;
        private final int power;
        private final int weight;
        private final int slots;
        private final double cost;

        private TurretTypes(String name, int tl, int power, int weight, 
                            int slots, double cost){
            this.name = name;
            this.tl = tl;
            this.power = power;
            this.weight = weight;
            this.slots = slots;
            this.cost = cost;
        }

        public String getName() { return name; }
        public int getTL() { return tl; }
        public int getPower() { return power; }
        public int getWeight() { return weight; }
        public int getSlots() { return slots; }
        public double getCost() { return cost; }
    }

    /* ---------
     *  Turret Weapons
            Weapon TL Range Power Damage Cost Traits
            Beam Laser 10 Medium 4 1D MCr0.5 -
            Laser Drill 8 Adjacent 4 4D Cr150000 -
            Missile Rack 7 Special 0 4D MCr0.75 Smart
            Pulse Laser 9 Long 4 2D MCr1 -
            Sandcaster 9 Special 0 Special MCr0.25 -
    --------- */
    public enum TurretWeapons{
        EMPTY("Empty",               0, Special,  0, "-",            0, "-"),
        BEAML("Beam Laser",         10, Medium,   4, "1D",      500000, "-"),
        LDRIL("Laser Drill",         8, Adjacent, 4, "4D",      150000, "-"),
        MRACK("Missile Rack",        7, Special,  0, "4D",      750000, "Smart"),
        PULSE("Pulse Laser",         9, Long,     4, "2D",     1000000, "-"),
        SANDC("Sandcaster",          9, Special,  0, "Special", 250000, "-"),
        SMALL("Small Weapons Mount", 7, Adjacent, 0, "*",         1000, "Anti-personel");

        private final String name;
        private final int tl;
        private final WeaponRanges range;
        private final int power;
        private final String damage;
        private final double cost;
        private final String traits;

        private TurretWeapons(String name, int tl, WeaponRanges range, int power, 
                              String damage, double cost, String traits){
            this.name = name;
            this.tl = tl;
            this.range = range;
            this.power = power;
            this.damage = damage;
            this.cost = cost;
            this.traits = traits;
        }

        public String getName() { return name; }
        public int getTL() { return tl; }
        public WeaponRanges getRange() { return range; }
        public int getPower() { return power; }
        public String getDamage() { return damage; }
        public double getWeight() { return 0; }
        public double getCost() { return cost; }
        public String getTraits() { return traits; }
    }

    /* ---------
     *  AntiPersonel Weapons
            Weapon TL Range Power Damage Cost Traits
                Heavy Machinegun 6 Adjacent 0 6D 4500 Anti-Personnel Only
                Light Autocannon 6 Adjacent 0 4D 10000 Anti-Personnel Only
                Vulcan Machinegun 7 Adjacent 0 6D 12000 Anti-Personnel Only
                Rocket Pod 6 Adjacent 0 4D 8000 Anti-Personnel Only
    --------- */
    public enum APersonelWeapons{
        EMPTY("Empty",             0, Special,  0, "-",      0, "-"),
        HMGUN("Heavy Machinegun",  6, Adjacent, 0, "6D",  4500, "Anti-personel"),
        LACNN("Light Autocannon",  6, Adjacent, 0, "4D", 10000, "Anti-personel"),
        VULCN("Vulcan Machinegun", 7, Adjacent, 0, "6D", 12000, "Anti-personel"),
        ROCKT("Rocket Podt",       6, Adjacent, 0, "4D",  8000, "Anti-personel");

        private final String name;
        private final int tl;
        private final WeaponRanges range;
        private final int power;
        private final String damage;
        private final double cost;
        private final String traits;

        private APersonelWeapons(String name, int tl, WeaponRanges range, int power, 
                              String damage, double cost, String traits){
            this.name = name;
            this.tl = tl;
            this.range = range;
            this.power = power;
            this.damage = damage;
            this.cost = cost;
            this.traits = traits;
        }

        public String getName() { return name; }
        public int getTL() { return tl; }
        public WeaponRanges getRange() { return range; }
        public int getPower() { return power; }
        public String getDamage() { return damage; }
        public double getWeight() { return 0; }
        public double getCost() { return cost; }
        public String getTraits() { return traits; }
    }

    /* ---------
     *  Barbette Weapons
            Weapon TL Range Power Damage Cost Traits
            Fusion Barbette 12 Medium 20 5D MCr4 Radiation
            Gravimetric Distorter 13 Short 10 Special MCr4 -
            Ion Cannon 12 Medium 10 2D x 10 MCr6 Ion
            Missile Barbette 7 Special 0 4D MCr4 Smart
            Particle Barbette 11 Very Long 15 4D MCr8 Radiation
            Plasma Barbette 11 Medium 12 4D MCr5 -
            Tachyon Cannon 14 Long 6 2D MCr5 AP 10
            Torpedo 7 Special 2 6D MCr3 Smart
    --------- */
    public enum BarbetteWeapons {
        EMPTY ("Empty",                  0, Special,   0, "-",             0, "-"),
        FUSION("Fusion Barbette",       12, Medium,   20, "5D",      4000000, "Radiation"),
        GRAVMT("Gravimetric Distorter", 13, Short,    10, "Special", 4000000, "-"),
        IONCNN("Ion Cannon",            12, Medium,   10, "2D x 10", 6000000, "Ion"),
        MISSIL("Missile Barbette",       7, Special,   0, "4D",      4000000, "Smart"),
        PARTCL("Particle Barbette",     11, VeryLong, 15, "4D",      8000000, "Radiation"),
        PLASMA("Plasma Barbette",       11, Medium,   12, "4D",      5000000, "-"),
        TACHON("Tachyon Cannon",        14, Long,      6, "2D",      5000000, "AP 10"),
        TORPED("Torpedo",                7, Special,   2, "6D",      3000000, "Smart");

        private final String name;
        private final int tl;
        private final WeaponRanges range;
        private final int power;
        private final String damage;
        private final double cost;
        private final String traits;

        private BarbetteWeapons(String name, int tl, WeaponRanges range, int power, 
                                String damage, double cost, String traits){
            this.name = name;
            this.tl = tl;
            this.range = range;
            this.power = power;
            this.damage = damage;
            this.cost = cost;
            this.traits = traits;
        }

        public String getName() { return name; }
        public int getTL() { return tl; }
        public WeaponRanges getRange() { return range; }
        public int getPower() { return power; }
        public String getDamage() { return damage; }
        public double getWeight() { return 0; }
        public double getCost() { return cost; }
        public String getTraits() { return traits; }
    }

    /* ---------
     *  Bay Hardpoints
            Mount Tons Hardpoints Crew
            Small 50 1 1
            Medium 100 1 2
            Large 500 5 4
    --------- */
    public enum BayHardpoints {
        Small ( 50, 1, 1),
        Medium(100, 1, 2),
        Large (500, 5, 4);

        private double weight;
        private int points;
        private int crew;

        private BayHardpoints(double weight, int points, int crew) {
            this.weight = weight;
            this.points = points;
            this.crew = crew;
        }

        public double getWeight() { return weight; }
        public int getPoints() { return points; }
        public int getCrew() { return crew; }
    }

    /* ---------
     *  Mass Drive Ammunition
            Bay Tons/Attack Cost/Attack
            Small 2 Cr20000
            Medium 4 Cr40000
            Large 20 Cr200000
    --------- */
    public enum MassDriveAmmo {
        Small ( 2,  20000),
        Medium( 4,  40000),
        Large (20, 200000);

        private final int weight;
        private final double cost;

        private MassDriveAmmo(int weight, double cost) {
            this.weight = weight;
            this.cost = cost;
        }

        public int getWeight() { return weight; }
        public double getCost() { return cost; }
    }

    /* ---------
     *  Bay - Small
            Weapon TL Range Power Damage Cost Traits
            Fusion Gun Bay 12 Medium 50 1DD MCr8 -
            Ion Cannon Bay 12 Medium 20 6D x 10 MCr15 Ion
            Mass Driver Bay 8 Short 15 1DD MCr40 -
            Missile Bay 7 Special 5 4D MCr12 Smart
            Particle Beam Bay 11 Very Long 30 6D MCr20 Radiation
            Railgun Bay 12 Short 10 3D MCr30 Auto 4
            Tachyon Cannon Bay 14 Long 10 4D MCr15 AP 10
            Torpedo Bay 9 Special 2 6D MCr3 Smart
    --------- */
    public enum BaySmallWeapons {
        EMPTY ("Empty",           0, Special,   0, "-",              0, "-"),
        FUSION("Fusion Gun",     12, Medium,   50, "1DD",      8000000, "-"),
        GRAVMT("Ion Cannon",     12, Medium,   20, "6D x 10", 15000000, "Ion"),
        MASSDV("Mass Driver",     8, Short,    15, "1DD",     40000000, "-"),
        IONCNN("Missile",         7, Special,   5, "4D",      12000000, "Smart"),
        PARTCL("Particle Beam",  11, VeryLong, 30, "6D",      20000000, "Radiation"),
        RAILGN("Railgun",        12, Short,    10, "3D",      30000000, "Auto 4"),
        TACHON("Tachyon Cannon", 14, Long,     10, "4D",      15000000, "AP 10"),
        TORPED("Torpedo",         9, Special,   2, "6D",       3000000, "Smart");

        private final String name;
        private final int tl;
        private final WeaponRanges range;
        private final int power;
        private final String damage;
        private final double cost;
        private final String traits;

        private BaySmallWeapons(String name, int tl, WeaponRanges range, int power, 
                                String damage, double cost, String traits){
            this.name = name;
            this.tl = tl;
            this.range = range;
            this.power = power;
            this.damage = damage;
            this.cost = cost;
            this.traits = traits;
        }

        public String getName() { return name; }
        public int getTL() { return tl; }
        public WeaponRanges getRange() { return range; }
        public int getPower() { return power; }
        public String getDamage() { return damage; }
        public double getWeight() { return 0; }
        public double getCost() { return cost; }
        public String getTraits() { return traits; }
    }

    /* ---------
     *  Bay - Medium
            Weapon TL Range Power Damage Cost Traits
            Fusion Gun Bay 12 Medium 80 2DD MCr16 -
            Ion Cannon Bay 12 Medium 30 8D x 10 MCr25 Ion
            Mass Driver Bay 8 Short 25 2DD MCr70 -
            Missile Bay 7 Special 10 4D MCr25 Smart
            Particle Beam Bay 11 Very Long 45 8D MCr40 Radiation
            Railgun Bay 12 Short 15 4D MCr60 Auto 6
            Tachyon Cannon Bay 14 Long 15 6D MCr30 AP 15
            Torpedo Bay 9 Special 5 6D MCr6 Smart
    --------- */
    public enum BayMediumWeapons {
        EMPTY ("Empty",           0, Special,   0, "-",        0, "-"),
        FUSION("Fusion Gun",     12, Medium,   80, "2DD",     16, "-"),
        IONCNN("Ion Cannon",     12, Medium,   30, "8D x 10", 25, "Ion"),
        MASSDV("Mass Driver",     8, Short,    25, "2DD",     70, "-"),
        MISSIL("Missile",         7, Special,  10, "4D",      25, "Smart"),
        PARTCL("Particle Beam",  11, VeryLong, 45, "8D",      40, "Radiation"),
        RAILGN("Railgun",        12, Short,    15, "4D",      60, "Auto 6"),
        TACHON("Tachyon Cannon", 14, Long,     15, "6D",      30, "AP 15"),
        TORPED("Torpedo",         9, Special,   5, "6D",       6, "Smart");

        private final String name;
        private final int tl;
        private final WeaponRanges range;
        private final int power;
        private final String damage;
        private final double cost;
        private final String traits;

        private BayMediumWeapons(String name, int tl, WeaponRanges range, int power, 
                                 String damage, double cost, String traits){
            this.name = name;
            this.tl = tl;
            this.range = range;
            this.power = power;
            this.damage = damage;
            this.cost = cost;
            this.traits = traits;
        }

        public String getName() { return name; }
        public int getTL() { return tl; }
        public WeaponRanges getRange() { return range; }
        public int getPower() { return power; }
        public String getDamage() { return damage; }
        public double getWeight() { return 0; }
        public double getCost() { return cost; }
        public String getTraits() { return traits; }
    }

    /* ---------
     *  Bay - Large
            Weapon TL Range Power Damage Cost Traits
            Fusion Gun Bay 12 Medium 220 2DD MCr50 -
            Mass Driver Bay 8 Short 40 2DD MCr120 -
            Missile Bay 7 Special 50 4D MCr125 Smart
            Particle Beam Bay 11 Very Long 200 8D MCr120 Radiation
            Railgun Bay 12 Short 75 4D MCr90 Auto 6
            Tachyon Cannon Bay 14 Long 50 6D MCr90 AP 15
            Torpedo Bay 9 Special 25 6D MCr30 Smart
    --------- */
    public enum BayLargeWeapons {
        EMPTY ("Empty",           0, Special,    0,  "-",    0, "-"),
        FUSION("Fusion Gun",     12, Medium,   220, "2DD",  50, "-"),
        MASSDV("Mass Driver",     8, Short,     40, "2DD", 120, "-"),
        MISSIL("Missile",         7, Special,   50, "4D",  125, "Smart"),
        PARTCL("Particle Beam",  11, VeryLong, 200, "8D",  120, "Radiation"),
        RAILGN("Railgun",        12, Short,     75, "4D",   90, "Auto 6"),
        TACHON("Tachyon Cannon", 14, Long,      50, "6D",   90, "AP 15"),
        TORPED("Torpedo",         9, Special,   25, "6D",   30, "Smart");

        private final String name;
        private final int tl;
        private final WeaponRanges range;
        private final int power;
        private final String damage;
        private final double cost;
        private final String traits;

        private BayLargeWeapons(String name, int tl, WeaponRanges range, int power, 
                                String damage, double cost, String traits){
            this.name = name;
            this.tl = tl;
            this.range = range;
            this.power = power;
            this.damage = damage;
            this.cost = cost;
            this.traits = traits;
        }

        public String getName() { return name; }
        public int getTL() { return tl; }
        public WeaponRanges getRange() { return range; }
        public int getPower() { return power; }
        public String getDamage() { return damage; }
        public double getWeight() { return 0; }
        public double getCost() { return cost; }
        public String getTraits() { return traits; }
    }

    /* ---------
     *  Railgun Ammunition
            Bay Tons/Attack Cost/Attack
            Small 1 Cr15000
            Medium 2 Cr30000
            Large 10 Cr150000
    --------- */
    public enum RailgunAmmo {
        Small ( 1,  15000),
        Medium( 2,  30000),
        Large (10, 150000);

        private final int weight;
        private final double cost;

        private RailgunAmmo(int weight, double cost) {
            this.weight = weight;
            this.cost = cost;
        }

        public int getWeight() { return weight; }
        public double getCost() { return cost; }
    }

    /* ---------
     *  Spinal Mount Weapons
            Weapon TL Range Base Size Power Damage Cost Max. Size Traits
            Meson 12 Long 7500 tons +1000 +2DD +MCr2000 75000 tons AP ∞, Radiation
            Particle 11 Long 3500 tons +1000 +1DD +MCr1000 28000 tons Radiation
            Railgun 10 Medium 3500 tons +500 +1DD +MCr500 21000 tons —
    --------- */
    public enum SpinalWeapons {
        EMPTY("Empty",     0, Special,   0,     0, "-",             0,     0, "-"),
        MESON("Meson",    12, Long,   7500, +1000, "+2DD", 2000000000, 75000, "AP ∞, Radiation"),
        PARTC("Particle", 11, Long,   3500, +1000, "+1DD", 1000000000, 28000, "Radiation"),
        RAILG("Railgun",  10, Medium, 3500,  +500, "+1DD",  500000000, 21000, "—");

        private final String name;
        private final int tl;
        private final WeaponRanges range;
        private final int bseSize;
        private final int power;
        private final String damage;
        private final double cost;
        private final int maxSize;
        private final String traits;

        private SpinalWeapons(String name, int tl, WeaponRanges range, int base, 
                int power, String damage, double cost, int max, String traits){
            this.name = name;
            this.tl = tl;
            this.range = range;
            this.bseSize = base;
            this.power = power;
            this.damage = damage;
            this.cost = cost;
            this.maxSize = max;
            this.traits = traits;
        }

        public String getName() { return name; }
        public int getTL() { return tl; }
        public WeaponRanges getRange() { return range; }
        public int getBseSize() { return bseSize; }
        public int getPower() { return power; }
        public String getDamage() { return damage; }
        public double getWeight() { return 0; }
        public double getCost() { return cost; }
        public int getMaxSize() { return maxSize; }
        public String getTraits() { return traits; }
    }

    /* ---------
     *  Spinal Mount improvements
            TL Tons Cost
            +1 -10% +10%
            +2 -15% +20%
            +3 -20% +30%
    --------- */
    public enum SpinalImprov {
        TL1(+1, -0.10, +0.10),
        TL2(+2, -0.15, +0.20),
        TL3(+3, -0.20, +0.30);

        private final int tlModf;
        private final double wgtModf;
        private final double costModf;
        
        private SpinalImprov(int tlModf, double wgtModf, double costModf) {
            this.tlModf = tlModf;
            this.wgtModf = wgtModf;
            this.costModf = costModf;
        }

        public int getTlModf() { return tlModf; }
        public double getWgtModf() { return wgtModf; }
        public double getCostModf() { return costModf; }
    }

    /* ---------
     *  Missiles
            Weapon TL Thrust Damage Cost Traits
            Advanced 14 15 5D Cr350000 Smart
            Antimatter 20 15 8D MCr1 Radiation, Smart
            Decoy 9 15 2D Cr350000 Smart
            Fragmentation 8 15 3D Cr200000 Smart
            Jumpbreaker 13 10 - MCr1 Smart
            Long Range 8 15 3D Cr500000 Smart
            Multi-Warhead 8 10 3D Cr750000 Smart
            Nuclear 6 10 6D Cr450000 Radiation, Smart
            Ortillery 7 6 1DD Cr300000 Smart
            Shockwave 7 10 - Cr200000 Smart
            Standard 7 10 4D Cr250000 Smart
    --------- */
    public enum Missiles {
        ADVCD("Advanced",     14, 15, "5D",  350000, "Smart"),
        ANTIM("Antimatter",   20, 15, "8D", 1000000, "Radiation, Smart"),
        DECOY("Decoy",         9, 15, "2D",  350000, "Smart"),
        FRAGM("Fragmentation", 8, 15, "3D",  200000, "Smart"),
        JUMPB("Jumpbreaker",  13, 10, "-",  1000000, "Smart"),
        LONGR("Long Range",    8, 15, "3D",  500000, "Smart"),
        MULTI("Multi-Warhead", 8, 10, "3D",  750000, "Smart"),
        NUCLR("Nuclear",       6, 10, "6D",  450000, "Radiation, Smart"),
        ORTLY("Ortillery",     7,  6, "1DD", 300000, "Smart"),
        SHOCK("Shockwave",     7, 10, "-",   200000, "Smart"),
        STAND("Standard",      7, 10, "4D",  250000, "Smart");

        private final String name;
        private final int tl;
        private final int thrust;
        private final String damage;
        private final double cost;
        private final String traits;

        private Missiles(String name, int tl, int thrust, String damage, 
                         double cost, String traits){
            this.name = name;
            this.tl = tl;
            this.thrust = thrust;
            this.damage = damage;
            this.cost = cost;
            this.traits = traits;
        }

        public String getName() { return name; }
        public int getTL() { return tl; }
        public int getThrust() { return thrust; }
        public String getDamage() { return damage; }
        public int getPower() { return 0; }
        public double getWeight() { return 0; }
        public double getCost() { return cost; }
        public String getTraits() { return traits; }
    }

    /* ---------
     *  Sandcaster Canisters
            Weapon TL Number Cost Traits
            Chaff Canister 8 20 Cr30000 -
            Pebble Canister 7 20 Cr25000 -
            Sand Canister 7 20 Cr25000 -
            Sandcutter Canister 8 20 Cr35000 -
    --------- */
    public enum SandCanisters {
        CHFF("Chaff",      8, 20, 30000, "-"),
        PBBL("Pebble",     7, 20, 25000, "-"),
        SAND("Sand",       7, 20, 25000, "-"),
        SCTT("Sandcutter", 8, 20, 35000, "-");

        private final String name;
        private final int tl;
        private final int qtty;
        private final double cost;
        private final String traits;

        private SandCanisters(String name, int tl, int qtty, double cost, String traits) {
            this.name = name;
            this.tl = tl;
            this.qtty = qtty;
            this.cost = cost;
            this.traits = traits;
        }

        public String getName() { return name; }
        public int getTL() { return tl; }
        public int getQtty() { return qtty; }
        public String getDamage() { return "-"; }
        public int getPower() { return 0; }
        public double getWeight() { return 0; }
        public double getCost() { return cost; }
        public String getTraits() { return traits; }
    }

    /* ---------
     *  Torpedoes
            Weapon TL Thrust Damage Cost Traits
            Advanced 14 15 7D Cr275000 Smart
            Antimatter 20 10 1DD Cr900000 Smart
            Antimatter Bomb-Pumped 21 10 8D Cr800000 AP 10, Radiation, Smart
            Antiradiation 12 10 6D Cr300000 Smart
            Bomb-Pumped 9 10 4D Cr250000 Smart
            EMP 9 10 4D x 10 Cr230000 Ion, Smart
            Multi-Warhead Antimatter 21 10 1DD MCr2 Radiation, Smart
            Multi-Warhead Standard 8 10 4D Cr400000 Smart
            Multi-Warhead Nuclear 8 10 6D Cr600000 Radiation, Smart
            Nuclear 7 10 8D Cr225000 Radiation, Smart
            Ortillery 8 6 3DD MCr1 Smart
            Plasma 12 10 1DD Cr650000 AP 10, Smart
            Standard 7 10 6D Cr150000 Smart
    --------- */
    public enum Torpedoes {
        ADVCD("Advanced",                 14, 15, "7D",      275000, "Smart"),
        ANTIM("Antimatter",               20, 10, "1DD",     900000, "Smart"),
        ANTBP("Antimatter Bomb-Pumped",   21, 10, "8D",      800000, "AP 10, Radiation, Smart"),
        ANRAD("Antiradiation",            12, 10, "6D",      300000, "Smart"),
        BOMBP("Bomb-Pumped",               9, 10, "4D",      250000, "Smart"),
        EMP  ("EMP",                       9, 10, "4D x 10", 230000, "Ion, Smart"),
        MWANT("Multi-Warhead Antimatter", 21, 10, "1DD",    2000000, "Radiation, Smart"),
        MWSTD("Multi-Warhead Standard",    8, 10, "4D",      400000, "Smart"),
        MWNUC("Multi-Warhead Nuclear",     8, 10, "6D",      600000, "Radiation, Smart"),
        NUCLR("Nuclear",                   7, 10, "8D",      225000, "Radiation, Smart"),
        ORTLY("Ortillery",                 8,  6, "3DD",    1000000, "Smart"),
        PLASM("Plasma",                   12, 10, "1DD",     650000, "AP 10, Smart"),
        STAND("Standard",                  7, 10, "6D",      150000, "Smart");

        private final String name;
        private final int tl;
        private final int thrust;
        private final String damage;
        private final double cost;
        private final String traits;

        private Torpedoes(String name, int tl, int thrust, String damage, 
                          double cost, String traits){
            this.name = name;
            this.tl = tl;
            this.thrust = thrust;
            this.damage = damage;
            this.cost = cost;
            this.traits = traits;
        }

        public String getName() { return name; }
        public int getTL() { return tl; }
        public int getThrust() { return thrust; }
        public String getDamage() { return damage; }
        public int getPower() { return 0; }
        public double getWeight() { return 0; }
        public double getCost() { return cost; }
        public String getTraits() { return traits; }
    }

    /* ---------
     *  Point Defense
            Weapon TL Intercept Power Tons Cost
            Type I 10 +1D 10 20 MCr5
            Type II 12 +2D 20 20 MCr10
            Type III 14 +3D 30 20 MCr20
    --------- */
    public enum PointDefenses {
        TYPE1("Type I",   10, "+1D", 10, 20,  5000000, "-"),
        TYPE2("Type II",  12, "+2D", 20, 20, 10000000, "-"),
        TYPE3("Type III", 14, "+3D", 30, 20, 20000000, "-");

        private final String name;
        private final int tl;
        private final String damage;
        private final int power;
        private final double weight;
        private final double cost;
        private final String traits;

        private PointDefenses(String name, int tl, String damage, int power,
                              double weight, double cost, String traits) {
            this.name = name;
            this.tl = tl;
            this.damage = damage;
            this.power = power;
            this.weight = weight;
            this.cost = cost;
            this.traits = traits;
        }

        public String getName() { return name; }
        public int getTL() { return tl; }
        public String getDamage() { return damage; }
        public int getPower() { return power; }
        public double getWeight() { return weight; }
        public double getCost() { return cost; }
        public String getTraits() { return traits; }
    }

    /* ---------
     *  Screen
            Screen TL Power Tons Cost
            Meson Screen 13 30 10 MCr20
            Nuclear Damper 12 20 10 MCr10
    --------- */
    public enum ScreenTypes {
        MESON("Meson Screen",   13, "-", 30, 10, 20000000, "-"),
        NUCDP("Nuclear Damper", 12, "-", 20, 10, 10000000, "-");

        private final String name;
        private final int tl;
        private final String damage;
        private final int power;
        private final double weight;
        private final double cost;
        private final String traits;

        private ScreenTypes(String name, int tl, String dmg, int power, 
                double weight, double cost, String traits) {
            this.name = name;
            this.tl = tl;
            this.damage = dmg;
            this.power = power;
            this.weight = weight;
            this.cost = cost;
            this.traits = traits;
        }

        public String getName() { return name; }
        public int getTL() { return tl; }
        public String getDamage() { return damage; }
        public int getPower() { return power; }
        public double getWeight() { return weight; }
        public double getCost() { return cost; }
        public String getTraits() { return traits; }
    }
}
