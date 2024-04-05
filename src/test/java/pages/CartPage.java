package pages;

import org.openqa.selenium.By;

public class CartPage {
    protected By headersCartBtn = By.cssSelector(".nav-buttons>a:nth-of-type(3)>img");
    protected By productsInCart = By.cssSelector("div.cl-product-card");
    protected By productDeleteBtn = By.cssSelector("div.cl-product-card:first-of-type>div:last-of-type>div:first-of-type>button");
    protected By secondDeleteBtn = By.cssSelector("div.cl-remove-basket-buttons>button:first-of-type");
    protected By giftPackageOption = By.cssSelector("div[class*='cl-product-card-info']>label>span");
    protected By discountCode = By.cssSelector("#discountcouponcode");
    protected By discountCodeConfirmBtn = By.cssSelector("#applydiscountcouponcode");
    protected By discountCodeErrorMsg = By.cssSelector("div.toast-message>div>span");
    protected By buyBtn = By.cssSelector("div.cl-totals-container>div>div>button");
    protected By increaseProductQuantityBtn = By.cssSelector("div.cl-product-quantity-input-container>div:last-of-type");
    protected By productQuantity = By.cssSelector("div.cl-product-quantity-input-container>input");

    public By getHeadersCartBtn() {
        return headersCartBtn;
    }
    public By getProductsInCart() {
        return productsInCart;
    }
    public By getProductDeleteBtn() {
        return productDeleteBtn;
    }
    public By getSecondDeleteBtn() {
        return secondDeleteBtn;
    }
    public By getGiftPackageOption() {return giftPackageOption;}
    public By getDiscountCode() {return discountCode;}
    public By getDiscountCodeConfirmBtn() {return discountCodeConfirmBtn;}
    public By getDiscountCodeErrorMsg() {return discountCodeErrorMsg;}
    public By getBuyBtn() {return buyBtn;}
    public By getIncreaseProductQuantityBtn() {return increaseProductQuantityBtn;}
    public By getProductQuantity() {return productQuantity;}
}
