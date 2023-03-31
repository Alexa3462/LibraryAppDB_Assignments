package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class B28G31_146_StepDefs_Alp {
    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    BookPage bookPage = new BookPage();
    List<String> actualList ;

    @Given("the {string} on the home page")
    public void the_on_the_home_page(String userType) {
        loginPage.login(userType);
    }
    @When("the user navigates to {string} page")
    public void the_user_navigates_to_page(String Books) {
        dashBoardPage.navigateModule(Books);
        BrowserUtil.waitFor(3);


    }
    @When("the user clicks book categories")
    public void the_user_clicks_book_categories() {
       Select select = new Select(bookPage.allCategories);
       List<String> list = new ArrayList<>();
        List<WebElement> options = select.getOptions();
        for (WebElement each : options) {
          list.add(each.getText());

        }
       list.remove("ALL");
        this.actualList= list;
     //   System.out.println(actualList);

    }
    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {


        DB_Util.runQuery("select name  from book_categories");
        List<Map<String, String>> allRowAsListOfMap = DB_Util.getAllRowAsListOfMap();
        List<String> expectedList = new ArrayList<>();
        for (Map<String, String> each : allRowAsListOfMap) {
          expectedList.add(each.get("name"));
        }
      //  System.out.println(expectedList);
        Assert.assertEquals(actualList,expectedList);

        }
    }


