package game.players;

import game.util.RandInt;

public class Alien extends Player {

    private int clawMaxDamage = 18;
    private int clawRangeProtection = 6;
    private int laserMaxDamage = 4;
    private int laserRangeProtection = 14;
    private int maxHitsPerRole = 4;
    private int accuracy = 3;

    public int alienDamageGivenCalculator() {
        int damage = 0;
        if(getPlayerWeapon().equalsIgnoreCase("claw")) {
            damage = getRandomClawDamage() * getRandomHitsPerRole() * getRandomAccuracy();
        } else {
            damage = getRandomLaserDamage() * getRandomHitsPerRole() * getRandomAccuracy();
        }
        return damage;
    }

    public int alienDamageReceivedCalculator(int rawDamageDealt) {
        int damage = 1;
        int protection = 0;
        if(getPlayerWeapon().equalsIgnoreCase("claw")) {
            protection = getRandomClawProtection() * getRandomAccuracy();
        } else {
            protection = getRandomLaserProtection() * getRandomAccuracy();
        }
        if(rawDamageDealt > protection) {
            damage = rawDamageDealt - protection;
        }
        this.removeHealth(damage);
        return damage;
    }

    private int getRandomClawDamage() {
        int damage = RandInt.randomInt(1,clawMaxDamage);
        return damage;
    }

    private int getRandomLaserDamage() {
        int damage = RandInt.randomInt(1,laserMaxDamage);
        return damage;
    }

    private int getRandomHitsPerRole() {
        int damage = RandInt.randomInt(1,maxHitsPerRole);
        return damage;
    }

    private int getRandomAccuracy() {
        int damage = RandInt.randomInt(1,accuracy);
        return damage;
    }

    private int getRandomClawProtection() {
        int damage = RandInt.randomInt(1,clawRangeProtection);
        return damage;
    }

    private int getRandomLaserProtection() {
        int damage = RandInt.randomInt(1,laserRangeProtection);
        return damage;
    }
}
