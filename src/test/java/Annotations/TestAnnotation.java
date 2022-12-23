package Annotations;

import org.testng.annotations.*;

public class TestAnnotation {

    @BeforeSuite
    public void beforeSuit(){
        System.out.println("I am before suit ***");
    }

    @AfterSuite
    public void afetrSuit(){
        System.out.println("I am after suit =)");
    }

    @BeforeTest
    public void BT(){
        System.out.println("I am before test----------");
    }

    @AfterTest
    public void AT(){
        System.out.println("I am after test------------");
    }


}
