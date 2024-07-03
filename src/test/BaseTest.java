package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import main.java.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    //driver should be ThreadLocal for parallel execution
    //this driver will be used in multiple classes so we can generate getter setter  methods for this
    public ThreadLocal<WebDriver>  driver=new ThreadLocal<>();

    public ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;

    //get and set method for driver instance
    public void setDriver(WebDriver driver){
        this.driver.set(driver);
    }

    public WebDriver getDriver(){
        return this.driver.get();
    }

    //initializing the reports
    @BeforeTest
    public void beforeTestMethod(){
        htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+File.separator+"reports"+File.separator+"AutomationReport.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Banking Test Reports");
        htmlReporter.config().setReportName("Automation Testing Results");
        htmlReporter.config().setTheme(Theme.DARK);
        extent=new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("SDET","Ankush");
    }

    //getting browserName parameyter from testNg.xml file
    //we will be Creating test  which ever method is executed, it will Create a test according to the methodName
    @BeforeMethod
    @Parameters(value={"browserName"})
    public void beforeMethodMethod(String browserName, Method testMethod){
        //create a test according to the particular testMethod name
        logger=extent.createTest(testMethod.getName());
        setUpDriver(browserName);
        getDriver().manage().window().maximize();
        getDriver().get(Constants.URL);
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    //getting the results using ITestResult Interface
    @AfterMethod
    public void afterMethodMethod(ITestResult result){
        if(result.getStatus()==ITestResult.SUCCESS){
            String methodName=result.getMethod().getMethodName();
            String logText="Test Case:"+methodName+"Passed";
            Markup m= MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS,m);

        }else if(result.getStatus()==ITestResult.FAILURE){
            String methodName=result.getMethod().getMethodName();
            String logText="TestCase:"+methodName+"Failed";
            Markup m=MarkupHelper.createLabel(logText,ExtentColor.RED);
            logger.log(Status.FAIL,m);
        }else if(result.getStatus()==ITestResult.SKIP){
            String methodName=result.getMethod().getMethodName();
            String logText="TestCase:"+methodName+"Skipped";
            Markup m=MarkupHelper.createLabel(logText,ExtentColor.YELLOW);
            logger.log(Status.SKIP,m);
        }
        getDriver().quit();
    }


    @AfterTest
    public void afterTestMethod(){
        extent.flush();
    }

    public void setUpDriver(String browserName){
        if(browserName.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ File.separator+"drivers"+File.separator+"chromedriver.exe");
            setDriver(new ChromeDriver());
        }else if(browserName.equalsIgnoreCase("Edge")){
            System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+ File.separator+"drivers"+File.separator+"msedgedriver.exe");
            setDriver(new EdgeDriver());
        }else{
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ File.separator+"drivers"+File.separator+"chromedriver.exe");
            setDriver(new ChromeDriver());
        }
    }
}
