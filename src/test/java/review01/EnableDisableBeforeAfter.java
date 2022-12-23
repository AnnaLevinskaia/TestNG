package review01;

import org.testng.annotations.*;

public class EnableDisableBeforeAfter {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after method");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("I am before class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("I am after class");
    }


    @Test
    public void testOne(){
        System.out.println("My first test");
    }

    @Test(enabled = false)
    public void testSecond(){
        System.out.println("My second test");
    }

    @Test(dependsOnMethods = {"testOne"})
    public void testThird(){
        System.out.println("My third test");
    }
}
