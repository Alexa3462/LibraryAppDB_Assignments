package com.library.steps;

import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class B28G31_160_StepDefs_EL {

    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();

    String actualBorrowedBooksNumber;


    @Given("the {string} is on the home page")
    public void the_is_on_the_home_page(String userType) {
        loginPage.login(userType);
    }

    @When("the librarian gets borrowed books number")
    public void the_librarian_gets_borrowed_books_number() {
        BrowserUtil.waitForVisibility(dashBoardPage.borrowedBooksNumber,2);
        actualBorrowedBooksNumber = dashBoardPage.borrowedBooksNumber.getText();
    }

    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {

        DB_Util.runQuery("select count(*) from book_borrow where is_returned=0;");

        String expectedBorrowedBookNumbers= DB_Util.getFirstRowFirstColumn();

        System.out.println("expectedBorrowedBookNumbers = " + expectedBorrowedBookNumbers);
        System.out.println("actualBorrowedBooksNumber = " + actualBorrowedBooksNumber);

        Assert.assertEquals(expectedBorrowedBookNumbers,actualBorrowedBooksNumber);
    }

}
