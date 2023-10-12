import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class researchSteps {
    WebDriver driver = null;
    private Properties properties;
    String projectPath = System.getProperty("user.dir");
    public researchSteps() {
        properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(projectPath + "/src/test/resources/config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Given("I am on the Investopedia Simulator website")
    public void i_am_on_investopedia_simulator_website() {
        driver.get("https://www.investopedia.com/simulator/");
    }

    @When("I log in with valid credentials")
    public void i_log_in_with_valid_credentials() {
        // Implement the login process using Selenium
        String email = properties.getProperty("email");
        String password = properties.getProperty("password");

        driver.findElement(By.name("username")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @Then("I navigate to the Research page")
    public void i_navigate_to_the_research_page() {
        WebElement researchLink = driver.findElement(By.linkText("Research"));
        researchLink.click();
    }

    @When("I search for the company {string}")
    public void i_search_for_the_company(String company) {
        WebElement searchInput = driver.findElement(By.id("search-input"));
        searchInput.sendKeys(company);
        searchInput.sendKeys(Keys.RETURN);
    }
    @Then("I verify that the results contain the keyword {string}")
    public void i_verify_that_the_results_contain_keyword(String keyword) {
        WebElement searchResults = driver.findElement(By.id("search-results"));
        String resultsText = searchResults.getText();
        assert resultsText.contains(keyword);
    }
}
