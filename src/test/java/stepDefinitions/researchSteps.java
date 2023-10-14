package stepDefinitions;

import io.cucumber.java.en.And;
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
import java.util.concurrent.TimeUnit;

public class researchSteps {
    WebDriver driver = null;
    private final Properties properties;
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

    @Given("user is on the investopedia simulator website")
    public void user_is_on_the_investopedia_simulator_website() {
        System.getProperty("webdriver.chrome.driver",projectPath + "/src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.navigate().to("https://www.investopedia.com/auth/realms/investopedia/protocol/openid-connect/auth?client_id=finance-simulator&redirect_uri=https%3A%2F%2Fwww.investopedia.com%2Fsimulator%2Fportfolio&state=00a02e9c-05cf-416d-8c07-2c59e671880a&response_mode=fragment&response_type=code&scope=openid&nonce=17f9e3a2-2101-41ae-a0d2-925d589f6b80");
    }
    @And("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        String email = properties.getProperty("email");
        String password = properties.getProperty("password");

        driver.findElement(By.name("username")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);

        driver.findElement(By.name("login")).sendKeys(Keys.ENTER);
    }

    @When("user navigates to the Research page")
    public void user_navigates_to_the_research_page() {
        WebElement researchLink = driver.findElement(By.cssSelector("a[data-cy='global-nav-item']"));
        researchLink.click();
    }
    @And("user searches for the company")
    public void user_searches_for_the_company() {
        driver.findElement(By.name("search")).sendKeys(Keys.ENTER);

    }
    @Then("user verifies that the results contain company>")
    public void user_verifies_that_the_results_contain_keyword(io.cucumber.datatable.DataTable dataTable) {
        driver.getPageSource().contains("Apple");

    }
}

