package com.cydeo.step_definitions;

import com.cydeo.pages.Search;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.Set;

public class search_step_definitions extends Search {

    Search search = new Search();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    String expectedInURL = "https://www.apodiscounter.de/";
    String expectedInTitle = "Online Apotheke apodiscounter.de";
    WebDriver driver= new ChromeDriver();
    String actualTitle = driver.getTitle();

    // Assert.assertTrue(actualTitle.contains(expectedInTitle));
    public static void switchWindowAndVerify(WebDriver driver, String expectedInURL, String expectedInTitle) {

        //Return and store all window handles in a Set.
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String each : allWindowHandles) {

            driver.switchTo().window(each);
            System.out.println("Current URL: " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains(expectedInURL)) {
                break;
            }
        }

        //5. Assert:Title contains “Etsy”

    }

    public static void verifyTitle(WebDriver driver, String expectedTitle) {
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    public static void verifyTitleContains(WebDriver driver, String expectedInTitle) {
        Assert.assertTrue(driver.getTitle().contains(expectedInTitle));
        String actualTitle = Driver.getDriver().getTitle();
        System.out.println("actualTitle = " + actualTitle);
    }

    @When("user enters the home page")
    public void user_enters_the_home_page() {
        Driver.getDriver().get("https://www.apodiscounter.de/");
        Driver.getDriver().getTitle();
        System.out.println("Title: ");
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @When("user clicks search box")
    public void user_clicks_search_box() {
        BrowserUtils.sleep(1);
        search.search_box.click();
        search.accept_btn.click();
    }

    @When("user enters vitamin in search box")
    public void user_enters_vitamin_in_search_box() {
        search.search_box.sendKeys("vitamin");
        search.click_icon.click();
        String actualTitle = driver.getTitle();
        String expectedInTitle = "Online Apotheke apodiscounter.dem";

        Assert.assertEquals(actualTitle, expectedInTitle);
    }

    @And("user scroll down and up")
    public void userScrollDownAndUp() {
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,1750)");
        }
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,-1750)");
        }

    }

    @And("user goes back to home page")
    public void userGoesBackToHomePage() {
        Driver.getDriver().navigate().back();
    }

    @Then("user should see the home page")
    public void userShouldSeeTheHomePage() {
        String expectedTitle = "Home-Ergebnisse";
        String actualTitle = Driver.getDriver().getTitle();
        System.out.println("actualTitle = " + actualTitle);
        Assert.assertEquals(expectedTitle, actualTitle);
    }
}
