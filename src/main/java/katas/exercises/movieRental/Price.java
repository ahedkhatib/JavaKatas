package katas.exercises.movieRental;

public abstract class Price {
    abstract double getCharge(int daysRented);
    int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
