package class01;

import org.testng.annotations.Test;

public class EnableDisable {
    @Test(enabled=false)
    public void ATest(){
        System.out.println("I am B test");
    }

    @Test
    public void BTest(){
        System.out.println("I am B test");
    }

    @Test
    public void CTest(){
        System.out.println("I am C test");
    }
}
