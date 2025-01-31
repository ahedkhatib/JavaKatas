package katas.exercises.movieRental;

import java.util.List;

public interface StatementFormatter {
    String format(String customerName, List<Rental> rentals, double totalAmount, int frequentRenterPoints);
}
