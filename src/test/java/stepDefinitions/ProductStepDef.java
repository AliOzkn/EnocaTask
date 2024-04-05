package stepDefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import pages.ProductPage;
import utilities.CommonMethods;

import java.util.List;

public class ProductStepDef extends CommonMethods {
    ProductPage pp = new ProductPage();
    List<WebElement> enabledSizes;
    int randomNum;

    @And("Randomly selects one of the Jeans, Women, Men categories.")
    public void randomlySelectsOnOfTheJeansWomenMenCategories() {
        randomNum = createRandomNumber();
        findList(pp.getCategories()).get(randomNum).click();
    }

    @And("On the product page, selects the order as ascending by price.")
    public void onTheProductsPageSelectsTheOrderAsAscendingByPrice() throws InterruptedException {
        find(pp.getSortBtn()).click();
        find(pp.getPriceLowToHigh()).click();
        Thread.sleep(1000);
    }

    @And("Selects first product.")
    public void selectsFirstProduct() {
        find(pp.getFirstProduct()).click();
    }

    @And("Randomly selects one of the size options on the product detail page that opens, adds the product to the cart and goes to the cart.")
    public void randomlySelectsOneOfTheSizeOptionsOnTheProductDetailPageThatOpensAddsTheProductToTheCartAndGoesToTheCart() throws InterruptedException {
        /* Bazı ürünlerde beden seçeneği yok.
           O yüzden ilk if koşulunda "eğer beden seçeneği kutusu görünmüyorsa" mevcut ürünü direkt sepete ekleyip devam etme durumu ele alındı. */
        if (!find(pp.getSizeOptionBox()).isDisplayed()) {
            find(pp.getAddToCartBtn()).click();
            Thread.sleep(1000);
            find(pp.getGoToCartBtn()).click();
            Thread.sleep(1000);
        } else {
         /* Beden seçeneği kutusunun göründüğü durumda
            bu seçenekleri "enabledSizes" webelement listesine atar.*/
            find(pp.getSizeOptionBox()).click();
            Thread.sleep(1000);
            enabledSizes = findList(pp.getSizeOptions());
         /* Eğer seçili ürün için stokta
            beden seçeneği/seçenekleri mevcutsa aşağıdaki if koşulu çalışır.*/
            if (!enabledSizes.isEmpty()) {
                randomNum = createRandomNumber(enabledSizes);
                scrollToElement(driver, enabledSizes.get(randomNum));
                Thread.sleep(1000);
                enabledSizes.get(randomNum).click();
                Thread.sleep(2000);
                scrollToElement(driver, find(pp.getSizeOptionBox()));
                find(pp.getAddToCartBtn()).click();
                Thread.sleep(1000);
                find(pp.getGoToCartBtn()).click();
                Thread.sleep(1000);
            } else {
                System.out.println("There is no size options available.");
            }
        }
    }
}
