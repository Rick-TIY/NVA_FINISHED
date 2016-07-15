package game.players;

public abstract class Player {

    private int health = 1000;
    private String playerName;
    private String playerWeapon;

    public int getHealth() {
        return health;
    }

    public void removeHealth(int hit) {
        health -= hit;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerWeapon() {
        return playerWeapon;
    }

    public void setPlayerWeapon(String playerWeapon) {
        this.playerWeapon = playerWeapon;
    }
}
