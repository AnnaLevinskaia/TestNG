package class03_Listener_Annotation;

import org.testng.annotations.*;

public class Annotations {

    @BeforeTest
    public void beforeTest(){
        System.out.println("I am before test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("I am before class");
    }

    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("I am before Method");
    }
    @Test
    public void AFirstTest(){
        System.out.println("I am A 1 Test");
    }

    @Test
    public void BSecondTest(){
        System.out.println("I am B 2 Test");
    }

    @AfterMethod
    public void AfterMethod(){
        System.out.println("I am after Method");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("I am after class");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("I am after test");
    }

}
