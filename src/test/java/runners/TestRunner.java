package runners;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = "stepDefinitions",
	    plugin = {
	        "pretty",
	        "html:target/cucumber-reports",
	        "json:target/cucumber.json",
	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/ExtentReports/"
	    },
	    monochrome = true
	)
public class TestRunner extends AbstractTestNGCucumberTests {
    
    @BeforeClass
    public void setup() {
        System.out.println("Starting Test Execution");
    }
    
    @AfterClass
    public void teardown() {
        System.out.println("Test Execution Completed");
    }
    
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}