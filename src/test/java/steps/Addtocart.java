package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Addtocart {
    WebDriver driver;

    @Given("navigate to product page")
    public void products_page() {
        driver = new EdgeDriver();
        driver.get("https://www.automationexercise.com/products");

    }


    @When("user see the product")
    public void user_see_the_product() {
        WebElement productname = driver.findElement(By.xpath("(//p[text()='Blue Top'])[1]"));
        org.testng.Assert.assertTrue( productname.isDisplayed(),"Products are visible");
    }

    @When("click on add to cart")
    public void click_on_add_to_cart() {

        WebElement addToCartBtn = driver.findElement(By.xpath("//div[@class='modal-content']//a[@href='/view_cart']//u"));
        addToCartBtn.click();

    }
    /*public void safeClick(WebDriver driver, WebElement element) {
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
    }*/


    @Then("product display in the cart successfully")
    public void product_display_in_the_cart_successfully() {
        driver.get("https://www.automationexercise.com/view_cart");
        WebElement cartItem = driver.findElement(By.xpath("//a[@href='/view_cart']"));
        org.testng.Assert.assertTrue(cartItem.isDisplayed(), "Product  display in cart");


    }
}