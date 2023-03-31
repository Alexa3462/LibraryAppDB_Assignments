package com.library.steps;

import com.library.pages.BasePage;
import com.library.pages.BookPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class B28G31_157_SM_StepDefs_SM {

    LoginPage LP = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    BookPage bookPage = new BookPage();

    String nameOfTheBook = "";

    //This method will log in based on the type of user provided
    //It utilizes the login method from the LoginPage
    @Given("the {string} on the home page - SM")
    public void the_on_the_home_page_sm(String TypeOfUserToLogInAs) {
        LP.login(TypeOfUserToLogInAs);

    }

    //This method will navigate to one of the 3 modules
    // It uses a method from the DashBoardPage which extends the BasePage which is abstract
    @Given("the user navigates to {string} page -SM")
    public void the_user_navigates_to_page_sm(String NavigateToModule) {
        dashBoardPage.navigateModule(NavigateToModule);

    }
    @When("the user searches for {string} book - SM")
    public void the_user_searches_for_book_sm(String bookToSearch) {
        bookPage.search.sendKeys(bookToSearch);
        nameOfTheBook = bookToSearch;
    }
    @When("the user clicks edit book button -SM")
    public void the_user_clicks_edit_book_button_sm() {
        BrowserUtil.waitForClickablility(bookPage.editBook(nameOfTheBook), 3);
        bookPage.editBook(nameOfTheBook).click();
    }
    @Then("book information must match the Database -SM")
    public void book_information_must_match_the_database_sm() {
        DB_Util.runQuery("select * from books where name='"+nameOfTheBook+"'");
        BrowserUtil.waitForClickablility(bookPage.saveChanges,3);

        String ExpectedBookName = DB_Util.getCellValue(1, 2); // Value from DB
        String ActualBookName = bookPage.bookName.getAttribute("value"); // Value from UI
        Assert.assertEquals(ExpectedBookName, ActualBookName);

        String ExpectedIsbn = DB_Util.getCellValue(1, 3);
        String ActualIsbn = bookPage.isbn.getAttribute("value");
        Assert.assertEquals(ExpectedIsbn, ActualIsbn);

        String ExpectedYear = DB_Util.getCellValue(1, 4);
        String ActualYear = bookPage.year.getAttribute("value");
        Assert.assertEquals(ExpectedYear, ActualYear);

        String ExpectedAuthor = DB_Util.getCellValue(1, 5);
        String ActualAuthor = bookPage.author.getAttribute("value");
        Assert.assertEquals(ExpectedAuthor, ActualAuthor);

    }



}
