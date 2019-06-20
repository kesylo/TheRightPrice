public class Player {

    private String playerName;
    private int [] attempts;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /*public void setAttempts(int index, int attempt) {
        this.attempts[index] = attempt;
    }*/
}
