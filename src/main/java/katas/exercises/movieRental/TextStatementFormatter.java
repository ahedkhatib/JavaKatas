package katas.exercises.movieRental;

import java.util.List;

public class TextStatementFormatter implements StatementFormatter {
    @Override
    public String format(String customerName, List<Rental> rentals, double totalAmount, int frequentRenterPoints) {
        StringBuilder result = new StringBuilder();
        result.append("Rental Record for ").append(customerName).append("\n");

        for (Rental rental : rentals) {
            result.append("\t").append(rental.getMovie().getTitle())
                    .append("\t").append(rental.getMovie().getCharge(rental.getDaysRented()))
                    .append("\n");
        }

        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");

        return result.toString();
    }
}
