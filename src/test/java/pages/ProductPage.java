package pages;

import org.openqa.selenium.By;

public class ProductPage {
    protected By categories = By.cssSelector("ul.nav-menu>li");
    protected By sortBtn = By.cssSelector("select#products-orderby");
    protected By priceLowToHigh = By.cssSelector("select#products-orderby>option:nth-of-type(2)");
    protected By firstProduct = By.cssSelector("div.cl-product-grid>div:first-of-type>div:first-of-type");
    protected By sizeOptionBox = By.cssSelector("select#size-select");
    protected By sizeOptions = By.cssSelector("select#size-select>option.sk-enabled-size");
    protected By addToCartBtn = By.cssSelector("button[id*='add-to-cart-button']");
    protected By goToCartBtn = By.cssSelector("div[class*='go-to-cart-button']");
    public By getGoToCartBtn() {
        return goToCartBtn;
    }
    public By getAddToCartBtn() {return addToCartBtn;}
    public By getSizeOptions() {return sizeOptions;}
    public By getCategories() {
        return categories;
    }
    public By getSortBtn() {return sortBtn;}
    public By getFirstProduct() {
        return firstProduct;
    }
    public By getSizeOptionBox() {
        return sizeOptionBox;
    }
    public By getPriceLowToHigh() {return priceLowToHigh;}
}
