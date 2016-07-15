package game;

import game.players.Alien;
import game.players.Ninja;
import game.util.Statistics;

public class NVA {

    private String name = "";
    private String playerType = "";
    private String weapon = "";
    private String location = "";
    private String special = "";
    private Ninja ninja = new Ninja();
    private Alien alien = new Alien();

    public void setName() {
        System.out.println("What is your name?");
        name = PlayNVA.scanner.nextLine();
        System.out.println("Welcome, "+name);
    }

    public void setPlayerType() {
        while (!(playerType.equalsIgnoreCase("ninja") || playerType.equalsIgnoreCase("alien"))) {
            System.out.println("Are you a Ninja or Alien? [ninja/alien]");
            playerType = PlayNVA.scanner.nextLine();

            if (playerType.equalsIgnoreCase("ninja")) {
                System.out.println("Noble choice, the Ninja is stealthy and fast.");
            } else if (playerType.equalsIgnoreCase("alien")) {
                System.out.println("Powerful choice, the Alien is scary and strong.");
            } else {
                System.out.println("Invalid player type.");
            }
        }
    }

    public void setWeapon() {
        while(!((playerType.equalsIgnoreCase("ninja") && ((weapon.equalsIgnoreCase("blade")) || (weapon.equalsIgnoreCase("star")))) ||
                ((playerType.equalsIgnoreCase("alien") && ((weapon.equalsIgnoreCase("claw")) || (weapon.equalsIgnoreCase("laser"))))))) {
            if (playerType.equalsIgnoreCase("ninja")) {
                System.out.println("Okay ninja, choose your weapon [blade/star]");
            } else {
                System.out.println("Okay alien, choose your weapon [claw/laser]");
            }
            weapon = PlayNVA.scanner.nextLine();
            if (playerType.equalsIgnoreCase("ninja") && weapon.equalsIgnoreCase("blade")) {
                System.out.println("The ninja blade is close range, but deals more damage.");
            } else if (playerType.equalsIgnoreCase("ninja") && weapon.equalsIgnoreCase("star")) {
                System.out.println("The ninja star does less damage, but keeps you at a safer range.");
            } else if (playerType.equalsIgnoreCase("alien") && weapon.equalsIgnoreCase("claw")) {
                System.out.println("The alien claw is  close range, but deals more damage.");
            } else if (playerType.equalsIgnoreCase("alien") && weapon.equalsIgnoreCase("laser")) {
                System.out.println("The alien laser does less damage, but keeps you at a safer range.");
            } else {
                System.out.println("Invalid weapon.");
            }
        }
    }

    public void setLocation() {
        while(!(location.equalsIgnoreCase("forest") || location.equalsIgnoreCase("space"))) {
            System.out.println("Choose your location? [forest/space]");
            location = PlayNVA.scanner.nextLine();
            if(location.equalsIgnoreCase("forest")) {
                System.out.println("The forest gives the ninja a slight stealth advantage.");
            } else if(location.equalsIgnoreCase("space")) {
                System.out.println("Space gives the alien a slight strength advantage.");
            } else {
                System.out.println("Invalid location.");
            }
        }
    }

    public void setSpecial() {
        while(!(special.equalsIgnoreCase("speed") || special.equalsIgnoreCase("power") || special.equalsIgnoreCase("pain"))) {
            System.out.println("Choose your special attack? [speed/power/pain]");
            special = PlayNVA.scanner.nextLine();
            if(special.equalsIgnoreCase("speed")) {
                System.out.println("Speed gives the the player a high chance of making a second hit at 20% damage of the first hit.");
            } else if(special.equalsIgnoreCase("power")) {
                System.out.println("Power gives the the player a medium chance of doing an additional 50% damage on a hit.");
            } else if(special.equalsIgnoreCase("pain")) {
                System.out.println("Pain has a small change of inflicting a permanent penalty on the opponent, decreasing their overall effectiveness by 10%.");
            } else {
                System.out.println("Invalid special.");
            }

        }
    }

    public void startBattle() {
        Statistics stats = new Statistics();
        if(playerType.equalsIgnoreCase("ninja")) {
            ninja.setPlayerName(name);
            ninja.setPlayerWeapon(weapon);
            alien.setPlayerName("Twinkle Toes");
            alien.setPlayerWeapon("laser");
        } else {
            alien.setPlayerName(name);
            alien.setPlayerWeapon(weapon);
            ninja.setPlayerName("Mr Fuzzy Jingles");
            ninja.setPlayerWeapon("star");
        }
        System.out.println(" ");
        System.out.println("**********************************************");
        System.out.println("Time to play!");
        System.out.println(" ");
        while(alien.getHealth() > 0 && ninja.getHealth() > 0) {
            int alienDamageReceived = alien.alienDamageReceivedCalculator(ninja.ninjaDamageGivenCalculator());
            System.out.println(ninja.getPlayerName()+" attacks with the "+ninja.getPlayerWeapon()+" and deals "+alienDamageReceived+" points of damage.");
            int ninjaDamageReceived = ninja.ninjaDamageReceivedCalculator(alien.alienDamageGivenCalculator());
            System.out.println(alien.getPlayerName()+" attacks with the "+alien.getPlayerWeapon()+" and deals "+ninjaDamageReceived+" points of damage.");
            System.out.println(ninja.getPlayerName()+" Heath: "+ninja.getHealth()+"  vs  "+alien.getPlayerName()+" Health: "+alien.getHealth());
            stats.recordAttack(alienDamageReceived, ninjaDamageReceived);

            System.out.println(" ");
//            System.out.println("Press [enter] to take another turn.");
//            String turn = PlayNVA.scanner.nextLine();
            System.out.println(" ");
        }

        System.out.println("**********************************************");
        if(ninja.getHealth() > 0) {
            System.out.println(ninja.getPlayerName()+" Wins!!!");
            System.out.println("Health Remaining: "+ninja.getHealth());
        } else if(alien.getHealth() > 0) {
            System.out.println(alien.getPlayerName()+" Wins!!!");
            System.out.println("Health Remaining: "+alien.getHealth());
        } else {
            System.out.println("Everyone Died!!!");
            System.out.println(ninja.getPlayerName()+" and "+alien.getPlayerName()+" both lose.");
        }
        System.out.println("**********************************************");
        System.out.println("Total attacks: "+stats.getTotalAttacks());
        System.out.println("Total ties: "+stats.getTies());
        System.out.println("Total wins by ninja: "+stats.getNinjaWins());
        System.out.println("Ninja's attack average: "+stats.getNinjaAverageDamageDealt());
        System.out.println("Total wins by alien: "+stats.getAlienWins());
        System.out.println("Alien's attack average: "+stats.getAlienAverageDamageDealt());
        System.out.println("**********************************************");

    }
}
