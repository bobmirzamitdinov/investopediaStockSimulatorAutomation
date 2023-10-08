package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginSteps {

    WebDriver driver = null;
    @Given("user is on login page")
    public void user_is_on_login_page() {
        System.out.println("12");
        throw new io.cucumber.java.PendingException();
    }
    @When("user enters username and password")
    public void user_enters_username_and_password() {
        System.out.println("123");
        throw new io.cucumber.java.PendingException();
    }
    @When("clicks on login button")
    public void clicks_on_login_button() {
        System.out.println("1234");
        throw new io.cucumber.java.PendingException();
    }
    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
        System.out.println("12345");
        throw new io.cucumber.java.PendingException();
    }
}
