package game;

import java.util.Scanner;

public class PlayNVA {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        NVA nva = new NVA();
        System.out.println("Lets play a game.");
        nva.setName();
        nva.setPlayerType();
        nva.setWeapon();
        nva.setLocation();
        nva.setSpecial();
        nva.startBattle();
    }
}
