package com.library.steps;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class B28G31_154_StepDefs_NC {
    String actualUserCountId;
    List<String> actualColumnNames;

    @Given("Establish the database connection")
    public void establish_the_database_connection() {


    }
    @When("Execute query to get all IDs from users - NC")
    public void execute_query_to_get_all_i_ds_from_users_nc() {
        String query="select count(id) from users";
        DB_Util.runQuery(query);

        actualUserCountId= DB_Util.getFirstRowFirstColumn();
        System.out.println("actualUserCount = " + actualUserCountId);

    }
    @Then("verify all users has unique ID - NC")
    public void verify_all_users_has_unique_id_nc() {

        String query1="select count(distinct id) from users";
        DB_Util.runQuery(query1);
      String expectedUserCountId = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedUserCountId = " + expectedUserCountId);
        Assert.assertEquals(expectedUserCountId,actualUserCountId);



    }



    @When("Execute query to get all columns - NC")
    public void execute_query_to_get_all_columns_nc() {
        String query="select * from users";
        DB_Util.runQuery(query);
         actualColumnNames=DB_Util.getAllColumnNamesAsList();
        System.out.println(actualColumnNames);

    }
    @Then("verify the below columns are listed in result - NC")
    public void verify_the_below_columns_are_listed_in_result_nc(List<String> dataTable) {

        List<String>  expectedColumnNames=dataTable;


        Assert.assertEquals(actualColumnNames,expectedColumnNames);
    }


}
