package class03_Listener_Annotation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

//    Test Scenario:
//    navigate to syntax HRMS
//    login into the webiste using the following credentials and check for correct errors
//    a.username ="Admin"  , password="12345"  ---> Error Message ="Invalid credentials"
//    b.username= "ABCD"   , password ="Hum@nhrm123" -->Error Message ="Invalid credentials"
//    c.username= ""   ,   password ="Hum@nhrm123"   -->Error Message ="Username cannot be empty"
//    d.username= "Admin" ,password= ""  -->Error Message= "Password cannot be empty"

public class dataProvider {
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

    @DataProvider(name="credentials")
    public Object[][] data(){
        Object[][] login={
                {"Admin","12345","Invalid credentials"},
                {"ABCD","Hum@nhrm123","Invalid credentials"},
                {"Admin","","Password cannot be empty"},
                {"","Hum@nhrm123","Username cannot be empty"}
        };
        return login;
    }

    @Test(dataProvider = "credentials")
    public void LoginWithInvalidCredentials(String userName, String password, String expextedErrorMsg){
        WebElement username = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        username.sendKeys(userName);
        WebElement pswr = driver.findElement(By.xpath("//input[@name='txtPassword']"));
        pswr.sendKeys(password);
        WebElement loginBtn = driver.findElement(By.name("Submit"));
        loginBtn.click();

        WebElement errorMSG = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String actualErrorMsg = errorMSG.getText();
        //String expectedErrorMsg = "Invalid credentials";
        Assert.assertEquals(actualErrorMsg, expextedErrorMsg);

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
