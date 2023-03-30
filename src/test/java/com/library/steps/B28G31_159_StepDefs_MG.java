package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import com.library.utility.BrowserUtil;

import java.util.List;
import java.util.Map;


public class B28G31_159_StepDefs_MG {


    LoginPage loginPage = new LoginPage();

    DashBoardPage dashBoardPage = new DashBoardPage();

    BookPage bookPage = new BookPage();

    @Given("the {string} on the home page - MG")
    public void the_on_the_home_page_mg(String userType) {
        loginPage.login(userType);

    }
    @Given("the user navigates to {string} page - MG")
    public void the_user_navigates_to_page_mg(String Books) {
        dashBoardPage.navigateModule(Books);
        BrowserUtil.waitFor(5);
    }
    @When("the librarian click to add book - MG")
    public void the_librarian_click_to_add_book_mg() {

        bookPage.addBook.click();
        BrowserUtil.waitFor(5);
    }
    @When("the librarian enter book name {string} - MG")
    public void the_librarian_enter_book_name_mg(String BookName) {
        bookPage.bookName.sendKeys(BookName);
        BrowserUtil.waitFor(5);
    }
    @When("the librarian enter ISBN {string} - MG")
    public void the_librarian_enter_isbn_mg(String ISBN) {
        bookPage.isbn.sendKeys(ISBN);
    }
    @When("the librarian enter year {string} - MG")
    public void the_librarian_enter_year_mg(String Year) {
        bookPage.year.sendKeys(Year);
    }
    @When("the librarian enter author {string}")
    public void the_librarian_enter_author(String Author) {
        bookPage.author.sendKeys(Author);
    }
    @When("the librarian choose the book category {string} - MG")
    public void the_librarian_choose_the_book_category_mg(String BookCategory) {
        BrowserUtil.selectOptionDropdown(bookPage.categoryDropdown, BookCategory);
        BrowserUtil.waitFor(5);
    }
    @When("the librarian click to save changes - MG")
    public void the_librarian_click_to_save_changes_mg() {
        bookPage.saveChanges.click();
    }
    @Then("verify {string} message is displayed - MG")
    public void verify_message_is_displayed_mg() {
       Assert.assertTrue(bookPage.toastMessage.isDisplayed());

    }
    @Then("verify {string} information must match with DB - MG")
    public void verify_information_must_match_with_db_mg(String expectedBookName) {
        String query = "select name, author, ISBN from books\n"
                + "where name= '"+expectedBookName+"'";
        DB_Util.runQuery(query);

       Map<String, String> rowMap =  DB_Util.getRowMap(1);
       String actualBookName = rowMap.get("name");
     Assert.assertEquals(expectedBookName,actualBookName);


    }


}
