package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.Assert;



import java.util.List;

public class Stepdefinitionsearch {
     WebDriver driver;
    @Given("user is on the products page")
    public void user_is_on_the_products_page() {
        System.setProperty("webdriver.edge.driver","C:\\Users\\sai.jyoshna.palanati\\Documents\\webdriver\\msedgedriver.exe");

        driver = new EdgeDriver();

        driver.get("https://www.automationexercise.com/products");

    }



    @When("user enter product name{string}")
    public void user_enter_product_name(String productName) {
        WebElement prodName = driver.findElement(By.xpath("//input[@id='search_product']"));

        prodName.sendKeys(productName);
    }




    @And("user click search button")
    public void user_click_search_button() {


        WebElement searchBtn = driver.findElement(By.xpath("//button[@id='submit_search']"));

        safeClick(driver,searchBtn);

    }
    public void safeClick(WebDriver driver, WebElement element) {
        try {
            element.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            // If an ad blocks it, delete ads and retry
            removeAds(driver);
            element.click();
        }
    }

    public void removeAds(WebDriver driver) {
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("document.querySelectorAll('.adsbygoogle, iframe[src*=\"googlesyndication\"]').forEach(el => el.remove());");
    }

    @Then("user sees search results")
    public void user_sees_search_results() {

        List<WebElement> resultsContainer = driver.findElements(By.cssSelector("#submit_search"));
        org.testng.Assert.assertFalse(resultsContainer.isEmpty(),"product not found");
        org.testng.Assert.assertTrue(resultsContainer.get(0).isDisplayed(),"product  displayed");
    }
}