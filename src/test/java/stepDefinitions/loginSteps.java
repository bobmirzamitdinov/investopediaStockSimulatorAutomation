package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class loginSteps {

    WebDriver driver = null;
    private Properties properties;
    String projectPath = System.getProperty("user.dir");
    public loginSteps() {
        properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(projectPath + "/src/test/resources/config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Given("browser is open")
    public void browser_is_open() {

        System.getProperty("webdriver.chrome.driver",projectPath + "/src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();
    }
    @And("user is on login page")
    public void user_is_on_login_page() {
        driver.navigate().to("https://www.investopedia.com/auth/realms/investopedia/protocol/openid-connect/auth?client_id=finance-simulator&redirect_uri=https%3A%2F%2Fwww.investopedia.com%2Fsimulator%2Fportfolio&state=00a02e9c-05cf-416d-8c07-2c59e671880a&response_mode=fragment&response_type=code&scope=openid&nonce=17f9e3a2-2101-41ae-a0d2-925d589f6b80");
    }
    @When("user enters email address and password")
    public void user_enters_email_address_and_password() {
        String email = properties.getProperty("email");
        String password = properties.getProperty("password");

        driver.findElement(By.name("username")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
    }
    @And("clicks on sign in button")
    public void clicks_on_sign_in_button() {
        driver.findElement(By.name("login")).sendKeys(Keys.ENTER);
    }
    @Then("user is navigated to the portfolio page")
    public void user_is_navigated_to_the_portfolio_page() {
        driver.getPageSource().contains("OVERVIEW");
        driver.close();
        driver.quit();
    }
}
