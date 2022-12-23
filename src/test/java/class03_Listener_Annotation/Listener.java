package class03_Listener_Annotation;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("the test case has past");
    }

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("the test case has failed");
    }



}
