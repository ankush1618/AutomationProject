package test;

import main.java.utils.ExcelDataProvider;
import org.testng.annotations.Test;

public class SampleDataProviderTest extends BaseTest{

    @Test(dataProvider = "userData",dataProviderClass = ExcelDataProvider.class)
    public void loginTest(String userName, String password) {
        // Your test logic using row data
        //sends driver instance to the Event classes

        logger.info("Logging in with username: " + userName + " and password: " + password);

    }

}
