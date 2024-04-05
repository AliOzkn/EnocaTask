package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import java.time.Duration;

public class Hooks {
    @Before
    public void tokenDeals() {
        Driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        Driver.get().manage().window().maximize();
        //Driver.get().manage().window().setSize(new Dimension(1920, 1080));
    }

    @After
    public void tearDownScenarios(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] failedScreenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(failedScreenshot, "image/png", "failed_scenario_" + scenario.getName());
        }
        Driver.closeDriver();
    }
}

