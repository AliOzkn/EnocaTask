package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {

    public Driver() {
    }
    public static WebDriver driver;

    public static WebDriver get() {
        String browser = ConfigurationReader.get("browser");
        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "chrome-headless":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    driver = new ChromeDriver(options);
                    break;
            }
        }
        return driver;
    }
    public  static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}