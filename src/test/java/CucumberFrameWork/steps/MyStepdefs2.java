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
import org.testng.Assert;


public class MyStepdefs2 {
    private WebDriverWait wait;
    private WebDriver driver;

    @Given("User navigates to log page")
    public void userNavigatesToLogPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, AppConfig.TIMEOUT);
        driver.get("https://basic-dev8.simplekyc.com/login");
        driver.manage().window().maximize();
        System.out.println("User navigates to logPage");
    }

    @And("User enters valid creds")
    public void userEntersValidCreds() {
        WebElement email = driver.findElement(By.cssSelector("input[name='email']"));
        email.sendKeys(AppConfig.validUsername);
        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        password.sendKeys(AppConfig.validPassword);
        System.out.println("User enters credentials");
    }

    @And("User clicks on log button")
    public void userClicksOnLogButton() {
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        System.out.println("User clicks on log button");
    }

    @And("User taken to main page")
    public void userTakenToMainPage() {
        WebElement brandImage = driver.findElement(By.cssSelector("a[class='navbar-brand']"));
        wait.until(ExpectedConditions.visibilityOf(brandImage));
        System.out.println("User taken to main page");
    }

    @And("User click logout button")
    public void userClickLogoutButton() {
        WebElement accountMenu = driver.findElement(By.cssSelector("span[class='grey-119']"));
        wait.until(ExpectedConditions.visibilityOf(accountMenu));
        accountMenu.click();
        WebElement logoutButton = driver.findElement(By.cssSelector("span[class*='glyphicon-log-out']"));
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();
        System.out.println("User click on logout button");
    }

    @When("User clicked on logout button")
    public void userClickedOnLogoutButton() {
        WebElement credentialsInputBlock = driver.findElement(By.cssSelector("form[role='form']"));
        wait.until(ExpectedConditions.visibilityOf(credentialsInputBlock));
        System.out.println("User clicked on logout button");
    }

    @Then("User must be taken to login page")
    public void userMustBeTakenToLoginPage() {
        WebElement credentialsInputBlock = driver.findElement(By.cssSelector("form[role='form']"));
        boolean afterLogoutPageIsOpen = credentialsInputBlock.isDisplayed();
        Assert.assertTrue(afterLogoutPageIsOpen);
        System.out.println("User taken to login page");
        driver.close();
        driver.quit();
    }
}
