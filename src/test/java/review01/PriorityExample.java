package review01;

import org.testng.annotations.Test;

public class PriorityExample {

    @Test
    public void myFirstTestCase(){
        System.out.println("It is my first case");
    }

    @Test(priority = 1)
    public void mySecondTestCase(){
        System.out.println("It is my second case");
    }
}
