package pages;

import org.openqa.selenium.By;

public class PaymentPage {

    protected By cardHolderName = By.xpath("//div[@class='card-holder']/div[1]/input");
    protected By cardNumber = By.xpath("//div[@class='card-holder']/div[2]/input");
    protected By cvv = By.xpath("//input[@data-val-regex='CVV numaras\u0131n\u0131 girin']");
    protected By contract = By.xpath("//div[@class='text-left']/div/label/span");
    protected By completeOrderBtn = By.id("completeOrderButton");
    protected By goToCartPageBtn = By.cssSelector("div.checkout-nav>ul>li:first-of-type");
    public By getCardHolderName() {
        return cardHolderName;
    }
    public By getCardNumber() {
        return cardNumber;
    }
    public By getCvv() {return cvv;}
    public By getContract() {return contract;}
    public By getCompleteOrderBtn() {return completeOrderBtn;}
    public By getGoToCartPageBtn() {return goToCartPageBtn;}
}
