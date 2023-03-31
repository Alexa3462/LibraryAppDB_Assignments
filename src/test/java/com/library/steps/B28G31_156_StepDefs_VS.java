package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class B28G31_156_StepDefs_VS {

    LoginPage loginPage = new LoginPage();

    DashBoardPage dashBoardPage = new DashBoardPage();

    BookPage bookPage = new BookPage();

    @Given("the {string} on the home page - VS")
    public void the_on_the_home_page_vs(String librarian) {

        loginPage.login(librarian);

    }

    @When("the user navigates to {string} page - VS")
    public void the_user_navigates_to_page_vs(String booksPage) {
        new DashBoardPage().navigateModule(booksPage);
        BrowserUtil.waitFor(1);

    }

    List<String> actualCategoryList;

    @When("the user clicks book categories - VS")
    public void the_user_clicks_book_categories_vs() {
        // bookPage.mainCategoryElement.click();

        actualCategoryList = BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);

        //  System.out.println("actualCategoryList = " + actualCategoryList);
        actualCategoryList.remove(0);

    }
}