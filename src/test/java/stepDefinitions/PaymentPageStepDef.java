package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import pages.PaymentPage;
import utilities.CommonMethods;

import static org.junit.Assert.assertEquals;

public class PaymentPageStepDef extends CommonMethods {
    PaymentPage payp = new PaymentPage();

    String popupMsg;

    @Then("Enters invalid credit card information and clicks complete order button. Verifies that the error message appears.")
    public void entersInvalidCreditCardInformationAndClicksCompleteOrderButtonVerifiesThatTheErrorMessageAppears() throws InterruptedException {
        // Card Holder Name
        find(payp.getCardHolderName()).click();
        find(payp.getCardHolderName()).sendKeys(fakeLetter("?"));
        Thread.sleep(1000);

        // Card Number
        find(payp.getCardNumber()).click();
        find(payp.getCardNumber()).sendKeys("1111111111111111");
        Thread.sleep(1000);

        // CVV
        scrollToElement(driver, find(payp.getCardHolderName()));
        find(payp.getCvv()).click();
        find(payp.getCvv()).sendKeys("111");
        Thread.sleep(1000);

        // Contract
        scrollToElement(driver, find(payp.getCvv()));
        find(payp.getContract()).click();
        Thread.sleep(1000);

        // Complete Order
        find(payp.getCompleteOrderBtn()).click();
        Thread.sleep(1000);

        popupMsg = driver.switchTo().alert().getText();
        System.out.println(popupMsg);
        assertEquals("\u00D6deme bilgileri eksik ya da hatal\u0131", popupMsg);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

    }

    @When("Navigates to the cart again.")
    public void navigatesToTheCartAgain() {
     /* Ödeme sayfasında sayfa otomatik aşağıya kaymakta.
        Sepete geri dönmek için olan buton yukarıda kalıyor. O yüzden javascriptExecutor ile sayfa en yukarıya kaydırıldı. */
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
        find(payp.getGoToCartPageBtn()).click();
    }
}

