package katas.exercises.movieRental;

import java.util.List;

public class HtmlStatementFormatter implements StatementFormatter {
    @Override
    public String format(String customerName, List<Rental> rentals, double totalAmount, int frequentRenterPoints) {
        StringBuilder result = new StringBuilder();
        result.append("<h1>Rental Record for <em>").append(customerName).append("</em></h1>\n");
        result.append("<table>\n");

        for (Rental rental : rentals) {
            result.append("<tr><td>").append(rental.getMovie().getTitle()).append("</td>")
                    .append("<td>").append(rental.getMovie().getCharge(rental.getDaysRented())).append("</td></tr>\n");
        }

        result.append("</table>\n");
        result.append("<p>Amount owed is <em>").append(totalAmount).append("</em></p>\n");
        result.append("<p>You earned <em>").append(frequentRenterPoints).append("</em> frequent renter points</p>");

        return result.toString();
    }
}
