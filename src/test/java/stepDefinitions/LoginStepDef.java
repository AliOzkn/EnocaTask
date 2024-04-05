
package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.LoginPage;
import utilities.CommonMethods;
import utilities.ConfigurationReader;
import utilities.Driver;

import static org.junit.Assert.assertTrue;

public class LoginStepDef extends CommonMethods {
    LoginPage lp = new LoginPage();

    @Given("User navigates to the lee.com.tr website.")
    public void userNavigatesToTheLeeComTrWebsite(){
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @And("Rejects cookies.")
    public void rejectsCookies() {
        find(lp.getDismissCookie()).click();
    }
    @And("Login with valid email and password values.")
    public void loginWithValidEmailAndPasswordValues() throws InterruptedException {
        // Login
        find(lp.getHeadersMyAccountBtn()).click();
        find(lp.getEmailBox()).click();
        find(lp.getEmailBox()).sendKeys(ConfigurationReader.get("email"));
        find(lp.getPasswordBox()).click();
        find(lp.getPasswordBox()).sendKeys(ConfigurationReader.get("password"));
        find(lp.getLoginBtn()).click();
        System.out.println("Logged In Successfully.");

        // My Account Page Welcome Text
        Thread.sleep(1000);
        find(lp.getHeadersMyAccountBtn()).click();
        assertTrue(find(lp.getWelcomeTxt()).getText().contains("Merhaba"));
    }

}
