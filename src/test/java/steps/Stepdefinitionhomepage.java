package steps;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Stepdefinitionhomepage {
    WebDriver driver;
    @Given("navigate to home page")
    public void navigate_homepage(){
        System.setProperty("webdriver.edge.driver","C:\\Users\\sai.jyoshna.palanati\\Documents\\webdriver\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.automationexercise.com");
        try{
            WebElement closepopup=driver.findElement(By.xpath("//div[@class='continue-prompt-text']"));
            closepopup.click();
        }catch(NoSuchElementException e){
             System.out.println("pop-up not found");

        }
    }

    @When("homepage shows product option")
    public void productOption() {
        WebElement homepageElement = driver.findElement(By.xpath("//a[@href='/products']"));
        Assert.assertTrue(homepageElement.isDisplayed(),"product not displayed");
    }

    @And("User click on products")
    public void products() {
        WebElement cProducts = driver.findElement(By.xpath("//a[@href='/products']"));
        cProducts.click();
    }

    @Then("products page display")
    public void productPage() {
        WebElement header = driver.findElement(By.xpath("//a[@href='/products']"));
        String aText = header.getText();
        Assert.assertFalse(aText.isEmpty(),"text is null");



    }
}




