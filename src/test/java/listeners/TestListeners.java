package listeners;

import org.testng.*;

public class TestListeners implements ITestListener {

    @Override
    public void onStart(ITestContext iTestContext){
        System.out.println("======= START AUTOMATION FRAMEWORK BY EMMA =====================");
    }

    @Override
    public void onFinish(ITestContext iTestContext){

    }

    @Override
    public void onTestStart(ITestResult iTestResult){

    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }
    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }


}
