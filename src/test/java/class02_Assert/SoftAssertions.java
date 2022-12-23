package class02_Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertions {

    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void launchTheWebsite(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Continue anyway")).click();

    }


    @Test(groups = "regression")
    public void invalidCredentials() {
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("admin");
        WebElement password = driver.findElement(By.xpath("//input[@name='txtPassword']"));
        password.sendKeys("abraa");
        WebElement loginBtn = driver.findElement(By.name("Submit"));
        loginBtn.click();
        //invalid credentials
        //span[text()='Invalid credentials']
        WebElement errorMSG = driver.findElement(By.xpath("//span[text()='Invalid credentials']"));
        String actualErrorMsg = errorMSG.getText();
        String expectedErrorMsg = "Invalid credentials";

        //we need to call soft assertion from SoftAssert by declaring an instance
        SoftAssert soft=new SoftAssert();
        soft.assertEquals(actualErrorMsg, expectedErrorMsg);
        System.out.println("I am here after 1st assertion");

        //check if the webElement error message isDisplayed
        boolean isDisplayed=errorMSG.isDisplayed();
        soft.assertTrue(isDisplayed);

        //assert all the assertions that have been made
        soft.assertAll();


    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }


}
