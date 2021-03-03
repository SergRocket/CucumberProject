package CucumberFrameWork.steps;

import CucumberFrameWork.featureFiles.AppConfig;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MyStepdefs {
private WebDriverWait wait;
public WebDriver driver;

    @Given("User navigates to login page")
    public void userNavigatesToLoginPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, AppConfig.TIMEOUT);
        driver.get("https://basic-dev8.simplekyc.com/login");
        driver.manage().window().maximize();
        System.out.println("User navigates");
    }

    @And("User enters valid credentias")
    public void userEntersValidCredential() {
        WebElement email = driver.findElement(By.cssSelector("input[name='email']"));
        email.sendKeys(AppConfig.validUsername);
        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        password.sendKeys(AppConfig.validPassword);
        System.out.println("User enters creds");
    }

    @And("User clicks on login button")
    public void userClicksOnLoginButton() {
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        System.out.println("User clicks login");
    }

    @When("User clicked on login button")
    public void userClickedOnLoginButton() {
        WebElement brandImage = driver.findElement(By.cssSelector("a[class='navbar-brand']"));
        wait.until(ExpectedConditions.visibilityOf(brandImage));
        System.out.println("User clicked login button");
    }

    @Then("User must be taken to main page")
    public void userMustBeTakenToMainPage() {
        WebElement spreadSheetWithCompaneys = driver.findElement(By.cssSelector("#page-content"));
        wait.until(ExpectedConditions.visibilityOf(spreadSheetWithCompaneys));
        System.out.println("User is taken to valid page");
        driver.close();
        driver.quit();
    }
}
