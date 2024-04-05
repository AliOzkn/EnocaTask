package utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommonMethods extends Driver {
    static Faker faker;
    int count;

    int getListSize(List<WebElement> element) {
        return count = element.size();
    }

    public int createRandomNumber(List<WebElement> element) {
        return CommonMethods.fakeNumberBetweenARange(0, getListSize(element));
    }

    public int createRandomNumber() {
        return CommonMethods.fakeNumberBetweenARange(0, 3);
    }

    public static WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public static List<WebElement> findList(By locator) {
        return driver.findElements(locator);
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static int fakeNumberBetweenARange(int a, int b) {
        faker = new Faker();
        return faker.number().numberBetween(a, b);
    }

    public String fakeNumber(String str) {
        faker = new Faker();
        return faker.numerify(str);
    }

    public String fakeLetter(String str) {
        faker = new Faker();
        return faker.letterify(str);
    }

    public static String fakeAddress() {
        faker = new Faker();
        return faker.address().fullAddress();
    }


}

