package pages;

import org.openqa.selenium.By;

public class LoginPage {

    protected By headersMyAccountBtn = By.cssSelector(".nav-buttons>a:nth-of-type(2)>img");
    protected By emailBox = By.cssSelector(".form-group:first-of-type>input");
    protected By passwordBox = By.cssSelector(".form-group:nth-of-type(2)>input");
    protected By loginBtn = By.cssSelector(".buttons>input.login-button");
    protected By accountPageLogOutBtn = By.cssSelector("div.filter-cont>ul>li[class='log-out']");
    protected By dismissCookie = By.xpath("(//div[@class='ot-sdk-row'])[1]/div[2]/div/button[2]");
    protected By welcomeTxt = By.cssSelector("div.cl-account-welcome>h3");

    public By getEmailBox() {
        return emailBox;
    }

    public By getHeadersMyAccountBtn() {
        return headersMyAccountBtn;
    }

    public By getPasswordBox() {
        return passwordBox;
    }

    public By getLoginBtn() {
        return loginBtn;
    }

    public By getAccountPageLogOutBtn() {
        return accountPageLogOutBtn;
    }

    public By getDismissCookie() {
        return dismissCookie;
    }

    public By getWelcomeTxt() {
        return welcomeTxt;
    }
}
