package main.java.utils;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import test.BaseTest;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static test.BaseTest.logger;

public class SuiteListener implements ITestListener, IAnnotationTransformer {
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    //taking screenshot
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        String fileName=System.getProperty("user.dir")+ File.separator+"screenshots"+File.separator+iTestResult.getMethod().getMethodName();
        //to get the instance of same driver
        Object currentInstance=iTestResult.getInstance();
        File src= ((TakesScreenshot) ((BaseTest)currentInstance).getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src,new File(fileName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Add screenshot to extent report
        try {
            logger.fail("Test Case Failed showing Screenshot Attached: ", MediaEntityBuilder.createScreenCaptureFromPath(fileName+".png").build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        iTestAnnotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}
