package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNJExample {
    public static WebDriver driver;

    //pre comditions
    @BeforeMethod(alwaysRun = true)
    public void SetupBrowser(){
        WebDriverManager.chromedriver().setup(); //replace previous version in selenium class
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Continue anyway")).click();

    }
    //post conditions

    @AfterMethod
    public void CloseBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    //Test case1
    @Test(groups = "smoke")
    public void LoginFunctionality(){
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("admin");
        WebElement password = driver.findElement(By.xpath("//input[@name='txtPassword']"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginBtn = driver.findElement(By.name("Submit"));
        loginBtn.click();
    }

    //Test case2
    @Test(alwaysRun = true)
    public void LoginBtnVerifivation(){
        WebElement loginBtn = driver.findElement(By.name("Submit"));
        System.out.println(loginBtn.isDisplayed());
    }

}
