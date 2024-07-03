package main.java.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//Retry Analyzer class will be managed by the suiteListener class
public class RetryAnalyzer implements IRetryAnalyzer {
    int count=0;
    int retryCount=2;
    @Override
    public boolean retry(ITestResult iTestResult) {
        while(count<retryCount){
            count++;
            return true;
        }
        return false;
    }
}
