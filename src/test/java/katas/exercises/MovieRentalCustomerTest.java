package katas.exercises;

import katas.exercises.movieRental.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MovieRentalCustomerTest {
    @Test
    public void test() {
        MovieRentalCustomer customer = new MovieRentalCustomer("Bob");
        customer.addRental(new Rental(new Movie("Jaws", new RegularPrice()), 2));
        customer.addRental(new Rental(new Movie("Golden Eye", new RegularPrice()), 3));
        customer.addRental(new Rental(new Movie("Short New", new NewReleasePrice()), 1));
        customer.addRental(new Rental(new Movie("Long New", new NewReleasePrice()), 2));
        customer.addRental(new Rental(new Movie("Bambi", new ChildrenPrice()), 3));
        customer.addRental(new Rental(new Movie("Toy Story", new ChildrenPrice()), 4));

        String expected = "" +
                "Rental Record for Bob\n" +
                "\tJaws\t2.0\n" +
                "\tGolden Eye\t3.5\n" +
                "\tShort New\t3.0\n" +
                "\tLong New\t6.0\n" +
                "\tBambi\t1.5\n" +
                "\tToy Story\t3.0\n" +
                "Amount owed is 19.0\n" +
                "You earned 7 frequent renter points";

        assertEquals(expected, customer.generateStatement(new TextStatementFormatter()));
    }

    @Test
    public void testHTMLStatement() {
        MovieRentalCustomer customer = new MovieRentalCustomer("Bob");
        customer.addRental(new Rental(new Movie("Jaws", new RegularPrice()), 2));
        customer.addRental(new Rental(new Movie("Golden Eye", new RegularPrice()), 3));
        customer.addRental(new Rental(new Movie("Short New", new NewReleasePrice()), 1));
        customer.addRental(new Rental(new Movie("Long New", new NewReleasePrice()), 2));
        customer.addRental(new Rental(new Movie("Bambi", new ChildrenPrice()), 3));
        customer.addRental(new Rental(new Movie("Toy Story", new ChildrenPrice()), 4));

        String expected = "" +
                "<h1>Rental Record for <em>Bob</em></h1>\n" +
                "<table>\n" +
                "<tr><td>Jaws</td><td>2.0</td></tr>\n" +
                "<tr><td>Golden Eye</td><td>3.5</td></tr>\n" +
                "<tr><td>Short New</td><td>3.0</td></tr>\n" +
                "<tr><td>Long New</td><td>6.0</td></tr>\n" +
                "<tr><td>Bambi</td><td>1.5</td></tr>\n" +
                "<tr><td>Toy Story</td><td>3.0</td></tr>\n" +
                "</table>\n" +
                "<p>Amount owed is <em>19.0</em></p>\n" +
                "<p>You earned <em>7</em> frequent renter points</p>";

        assertEquals(expected, customer.generateStatement(new HtmlStatementFormatter()));

        //System.out.println(customer.generateStatement(new HtmlStatementFormatter()));
    }

    @Test
    public void testFrequentRenterPoints() {
        MovieRentalCustomer customer = new MovieRentalCustomer("Bob");
        customer.addRental(new Rental(new Movie("Jaws", new NewReleasePrice()), 1));
        customer.addRental(new Rental(new Movie("Golden Eye", new NewReleasePrice()), 3));
        customer.addRental(new Rental(new Movie("Short New", new ChildrenPrice()), 2));

        String expected = "Rental Record for Bob\n" +
                "\tJaws\t3.0\n" +
                "\tGolden Eye\t9.0\n" +
                "\tShort New\t1.5\n" +
                "Amount owed is 13.5\n" +
                "You earned 4 frequent renter points";

        assertEquals(expected, customer.generateStatement(new TextStatementFormatter()));
    }

}

