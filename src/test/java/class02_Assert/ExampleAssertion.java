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
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class ExampleAssertion {

    //verify that login btn is displayed and close the browser
    //verify that login btn is enable

    WebDriver driver;

    @BeforeMethod
    public void launchTheWebsite(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Continue anyway")).click();

    }

    @Test
    public void LoginBtnIsDisplayed() {
        WebElement loginBtn = driver.findElement(By.name("Submit"));
        boolean isDisplayed = loginBtn.isDisplayed();
        //Assert.assertTrue(isDisplayed); hard assertion

        SoftAssert soft=new SoftAssert();
        soft.assertTrue(isDisplayed);
        boolean isEnabled=loginBtn.isEnabled();
        soft.assertTrue(isEnabled);
        soft.assertAll();

    }

    //@Test  // test will be executing even if 1 faild because they are independing.
    //if in 1 we use hard assert 2 will be executed because they are independing

    @Test(dependsOnMethods = {"LoginBtnIsDisplayed"}) //or do it dependened of test1
    public void testing(){
        System.out.println("I am test2");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }


}
