package class04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
//    goto syntax HRMS
//    verify that you get invalid credentials on entering wrong username
public class LoginTest {

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

    @Test
    public void LoginWithInvalidCredentials(){
        WebElement username = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        username.sendKeys("Admin");
        WebElement pswr = driver.findElement(By.xpath("//input[@name='txtPassword']"));
        pswr.sendKeys("123456");
        WebElement loginBtn = driver.findElement(By.name("Submit"));
        loginBtn.click();

        WebElement errorMSG = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String actualErrorMsg = errorMSG.getText();
        String expectedErrorMsg = "Invalid credentials";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

    }



    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }
}
