package stepDefinitions;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    public static ExtentReports extent;
    public static ExtentTest test;

    @Before
    public void setupReport() {
        if (extent == null) {  // Ensure it initializes only once
            ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReports.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
    }

    @After
    public void tearDown() {
        if (extent != null) {
            extent.flush();
        }
    }
}
