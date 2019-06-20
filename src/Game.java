public class Game {

    private Player [] players;
    private Price price;

    public Game(int numberOfPlayers, int minPrice, int maxPrice) {
        setPlayers(new Player[numberOfPlayers]);
        setPrice(new Price(minPrice, maxPrice));
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
