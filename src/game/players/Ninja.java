package game.players;

import game.util.RandInt;

public class Ninja extends Player {

    private int bladeMaxDamage = 5;
    private int bladeRangeProtection = 2;
    private int starMaxDamage = 3;
    private int starRangeProtection = 4;
    private int maxHitsPerRole = 4;
    private int accuracy = 4;

    public int ninjaDamageGivenCalculator() {
        int damage = 0;
        if(getPlayerWeapon().equalsIgnoreCase("blade")) {
            damage = getRandomBladeDamage() * getRandomHitsPerRole() * getRandomAccuracy();
        } else {
            damage = getRandomStarDamage() * getRandomHitsPerRole() * getRandomAccuracy();
        }
        return damage;
    }

    public int ninjaDamageReceivedCalculator(int rawDamageDealt) {
        int damage = 1;
        int protection = 0;
        if(getPlayerWeapon().equalsIgnoreCase("blade")) {
            protection = getRandomBladeProtection() * getRandomAccuracy();
        } else {
            protection = getRandomStarProtection() * getRandomAccuracy();
        }
        if(rawDamageDealt > protection) {
            damage = rawDamageDealt - protection;
        }
        this.removeHealth(damage);
        return damage;
    }

    private int getRandomBladeDamage() {
        int damage = RandInt.randomInt(1,bladeMaxDamage);
        return damage;
    }

    private int getRandomStarDamage() {
        int damage = RandInt.randomInt(1,starMaxDamage);
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

    private int getRandomBladeProtection() {
        int damage = RandInt.randomInt(1,bladeRangeProtection);
        return damage;
    }

    private int getRandomStarProtection() {
        int damage = RandInt.randomInt(1,starRangeProtection);
        return damage;
    }
}
