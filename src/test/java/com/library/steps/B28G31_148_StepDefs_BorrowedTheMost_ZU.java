package com.library.steps;


import com.library.pages.LoginPage;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;



public class B28G31_148_StepDefs_BorrowedTheMost_ZU {


    @Given("Establish the database connection - ZU")
    public void establish_the_database_connection_zu() {
       DB_Util.createConnection();
    }
    String actualGenre;

    @When("I execute query to find most popular book genre - ZU")
    public void i_execute_query_to_find_most_popular_book_genre_zu() {
    DB_Util.runQuery("SELECT bc.name, COUNT(*)\n" +
            "FROM book_borrow bb\n" +
            "         INNER JOIN books b ON bb.book_id = b.id\n" +
            "         INNER JOIN book_categories bc ON b.book_category_id = bc.id\n" +
            "GROUP BY bc.name\n" +
            "ORDER BY count(*) DESC;");

    actualGenre=DB_Util.getFirstRowFirstColumn();
    }



    @Then("verify {string} is the most popular book genre. - ZU")
    public void verify_is_the_most_popular_book_genre_zu(String expectedGenre) {
        Assert.assertEquals(expectedGenre, actualGenre);

        System.out.println("actualGenre = " + actualGenre);
        System.out.println("expectedGenre = " + expectedGenre);
    }

}

