package class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations {

    //first test case
    @Test
    public void BFirstTestCase(){
        System.out.println("I am first test case");
    }

    @Test
    public void ASecondTestCase(){
        System.out.println("I am second test case");
    }
    @Test
    public void ThirdTestCase(){
        System.out.println("I am third test case");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am beforeMethod");
    }

    @AfterMethod
    public void AfterMethod(){
        System.out.println("I am after method");
    }


}
