package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import com.library.utility.BrowserUtil;



public class B28G31_159_StepDefs_MG {


    LoginPage loginPage = new LoginPage();

    DashBoardPage dashBoardPage = new DashBoardPage();

    BookPage bookPage = new BookPage();

    @Given("the {string} on the home page - MG")
    public void the_on_the_home_page_mg(String string) {


    }
    @Given("the user navigates to {string} page - MG")
    public void the_user_navigates_to_page_mg(String string) {

    }
    @When("the librarian click to add book - MG")
    public void the_librarian_click_to_add_book_mg() {

    }
    @When("the librarian enter book name {string} - MG")
    public void the_librarian_enter_book_name_mg(String string) {

    }
    @When("the librarian enter ISBN {string} - MG")
    public void the_librarian_enter_isbn_mg(String string) {

    }
    @When("the librarian enter year {string} - MG")
    public void the_librarian_enter_year_mg(String string) {

    }
    @When("the librarian enter author {string}")
    public void the_librarian_enter_author(String string) {

    }
    @When("the librarian choose the book category {string} - MG")
    public void the_librarian_choose_the_book_category_mg(String string) {

    }
    @When("the librarian click to save changes - MG")
    public void the_librarian_click_to_save_changes_mg() {

    }
    @Then("verify {string} message is displayed - MG")
    public void verify_message_is_displayed_mg(String string) {

    }
    @Then("verify {string} information must match with DB - MG")
    public void verify_information_must_match_with_db_mg(String string) {

    }





}
