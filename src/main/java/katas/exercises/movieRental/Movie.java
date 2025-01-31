package katas.exercises.movieRental;

public class Movie {

    /*public static final int CHILDRENS = 2;
    public static final int NEW_RELEASE = 1;
    public static final int REGULAR = 0;*/

    private String _title;
    //private int _priceCode;
    private Price _price;

    public Movie(String title, Price price) {
        _title = title;
        //_priceCode = priceCode;
        _price = price;
    }

    public double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return _price.getFrequentRenterPoints(daysRented);
    }

    /*public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int arg) {
        _priceCode = arg;
    }*/
    public String getTitle() {
        return _title;
    }


}
