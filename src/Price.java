import java.util.Random;

public class Price {

    private int PriceValue;

    public Price(int minPrice, int maxPrice) {
        setPriceValue(createPrice(minPrice, maxPrice));
    }

    public int createPrice(int min, int max){
        Random rn = new Random();
        int randomNumber = rn.nextInt(max - min + 1) + min;
        return randomNumber;
    }

    public int getPriceValue() {
        return PriceValue;
    }

    public void setPriceValue(int priceValue) {
        PriceValue = priceValue;
    }
}
