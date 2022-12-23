package class02_Assert;

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

public class HardAssertions {

    //check invalid credentials
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
    public void invalidCredentials(){
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("admin");
        WebElement password = driver.findElement(By.xpath("//input[@name='txtPassword']"));
        password.sendKeys("abraa");
        WebElement loginBtn = driver.findElement(By.name("Submit"));
        loginBtn.click();
        //invalid credentials
        //span[text()='Invalid credentials']
        WebElement errorMSG = driver.findElement(By.xpath("//span[text()='Invalid credentials']"));
        String actualError=errorMSG.getText();
        System.out.println(actualError); //or
        String expectedErrorMsg="Invalid credentials";
        if(actualError.equalsIgnoreCase(expectedErrorMsg)){
            System.out.println("The error message is there");
        } else{
            System.out.println("The error message is not there");
        }

        //or is better to use assertion
        Assert.assertEquals(actualError, expectedErrorMsg);

        System.out.println("I am here after 1 assertion");

        //confirm that the error message is displayed
        boolean isDisplayed=errorMSG.isDisplayed();
        System.out.println(isDisplayed);

        //assert will pass if the parameter boolean is true, will fail if false
        Assert.assertTrue(isDisplayed);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }

}
