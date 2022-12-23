package class04;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ImplementationOfListeners implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("The test case has successfully passed"+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("The test case has successfully failed"+result.getTestName());
    }




}
