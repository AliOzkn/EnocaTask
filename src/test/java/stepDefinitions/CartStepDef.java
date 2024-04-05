package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.CartPage;
import pages.LoginPage;
import utilities.CommonMethods;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartStepDef extends CommonMethods {
    CartPage cp = new CartPage();
    LoginPage lp = new LoginPage();
    List<WebElement> products;
    String errorMsg;
    int quantity;

    @When("Navigates to the cart and checks is there any product and clears it if there is.")
    public void navigatesToTheCartAndChecksIsThereAnyProductAndClearsItIfThereIs() throws InterruptedException {
        find(cp.getHeadersCartBtn()).click();
        // Eğer ilk girişte sepet boşsa ilk if koşulu çalışır.
        if (findList(cp.getProductsInCart()).isEmpty()) {
            System.out.println("Your cart is empty.");
        /* Eğer ilk girişte sepet doluysa, tüm ürünleri bir WebElement List'e atar
           ve bu ürünleri silmek için, Listenin size'ı kadar for döngüsü gerçekleşir. */
        } else if (!findList(cp.getProductsInCart()).isEmpty()) {
            products = findList(cp.getProductsInCart());
            for (int i = 0; i < products.size(); i++) {
                find(cp.getProductDeleteBtn()).click();
                find(cp.getSecondDeleteBtn()).click();
                Thread.sleep(1000);
            }
        }
    }

    @And("Selects the I want gift wrapping option.")
    public void selectsTheIWantGiftWrappingOption() {
        find(cp.getGiftPackageOption()).click();
    }

    @Then("Enters a random code to the promotion code field and verifies that the error message appears.")
    public void entersARandomCodeToThePromotionCodeFieldAndVerifiesThatTheErrorMessageAppears() throws InterruptedException {
        find(cp.getDiscountCode()).click();
        find(cp.getDiscountCode()).sendKeys(fakeNumber("####"));
        find(cp.getDiscountCodeConfirmBtn()).click();
        Thread.sleep(800);
        errorMsg = find(cp.getDiscountCodeErrorMsg()).getText();
        System.out.println(errorMsg);
        assertEquals("Girdi\u011Finiz kupon kodu sipari\u015Finize uygulanamad\u0131", errorMsg);
    }

    @When("Clicks on the buy button.")
    public void clicksOnTheBuyButton() {
        find(cp.getBuyBtn()).click();
    }

    @Then("Increases the quantity of product by one and verifies that the quantity increased.")
    public void increasesTheQuantityOfProductByOneAndVerifiesThatTheQuantityIncreased() {
        find(cp.getIncreaseProductQuantityBtn()).click();
        quantity = Integer.parseInt(find(cp.getProductQuantity()).getAttribute("value")); // Ürün adeti, elementin "value" attribute'unda yazmakta. Assertion için bu attribute değeri alındı.
        assertTrue(quantity > 1);
    }

    @And("Logout successfully and closes browser.")
    public void logoutSuccessfullyAndClosesBrowser() {
        find(lp.getHeadersMyAccountBtn()).click();
        find(lp.getAccountPageLogOutBtn()).click();
    }
}


