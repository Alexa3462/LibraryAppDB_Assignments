package com.library.steps;

import com.library.pages.BasePage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class B28G31_157_SM_StepDefs_SM {

    LoginPage LP = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();

    //This method will log in based on the type of user provided
    //It utilizes the login method from the LoginPage
    @Given("the {string} on the home page - SM")
    public void the_on_the_home_page_sm(String TypeOfUserToLogInAs) {
        LP.login(TypeOfUserToLogInAs);
    }
    @Given("the user navigates to {string} page -SM")
    public void the_user_navigates_to_page_sm(String NavigateToModule) {
        dashBoardPage.navigateModule(NavigateToModule);

    }
    @When("the user searches for {string} book - SM")
    public void the_user_searches_for_book_sm(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user clicks edit book button -SM")
    public void the_user_clicks_edit_book_button_sm() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("book information must match the Database -SM")
    public void book_information_must_match_the_database_sm() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
