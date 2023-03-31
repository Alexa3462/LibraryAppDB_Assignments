package com.library.steps;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class B28G31_158_StepDefs_AM {

    String mostPopularGenre;

    @Given("Establish the database connection - AM")
    public void establish_the_database_connection_am() {
        DB_Util.createConnection();
    }

    @When("I execute query to find most popular book genre - AM")
    public void i_execute_query_to_find_most_popular_book_genre() {

        DB_Util.runQuery("select bc.name,count(*) from book_borrow bb\n" +
                "                                 inner join books b on bb.book_id = b.id\n" +
                "                                 inner join book_categories bc on b.book_category_id=bc.id\n" +
                "group by name\n" +
                "order by 2 desc;");

        mostPopularGenre = DB_Util.getCellValue(1,1);

    }
    @Then("verify {string} is the most popular book genre. - AM")
    public void verify_is_the_most_popular_book_genre(String expectedPopular) {
        Assert.assertEquals(expectedPopular, mostPopularGenre);
    }



}
