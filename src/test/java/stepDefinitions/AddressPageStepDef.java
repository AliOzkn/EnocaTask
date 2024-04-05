package stepDefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import pages.AddressPage;
import utilities.CommonMethods;

import java.util.List;

public class AddressPageStepDef extends CommonMethods {
    AddressPage ap = new AddressPage();
    int randomCityNum;
    int randomStateNum;
    int randomNeighborhoodNum;
    List<WebElement> cities;
    List<WebElement> states;
    List<WebElement> neighborhoods;

    @And("Adds new address on delivery information page and proceeds.")
    public void addsNewAddressOnDeliveryInformationPageAndProceeds() throws InterruptedException {
        find(ap.getAddNewAddressBtn()).click();
        Thread.sleep(1000);

        // Short Address Name
        find(ap.getShortAddressName()).sendKeys(fakeLetter("????"));
        Thread.sleep(1000);

        // City
        find(ap.getCity()).click();
        Thread.sleep(1000);
        cities = findList(ap.getCityOptions());
        randomCityNum = createRandomNumber(cities); // Şehir listesinden random seçim için sayı üretir.
        cities.get(randomCityNum).click();

        // State
        find(ap.getState()).click();
        Thread.sleep(2000);
        states = findList(ap.getStateOptions());
        randomStateNum = createRandomNumber(states); // İlçe listesinden random seçim için sayı üretir.
        scrollToElement(driver, states.get(randomStateNum)); // Ürettiği sayıya denk gelen elemente scroll yapar.
        states.get(randomStateNum).click();

        // Neighborhood
        find(ap.getNeighborhood()).click();
        Thread.sleep(1500);
        neighborhoods = findList(ap.getNeighborhoodOptions());
        randomNeighborhoodNum = createRandomNumber(neighborhoods); // Mahalle listesinden random seçim için sayı üretir.
        scrollToElement(driver, neighborhoods.get(randomNeighborhoodNum)); // Ürettiği sayıya denk gelen elemente scroll yapar.
        neighborhoods.get(randomNeighborhoodNum).click();

        // Full Address
        scrollToElement(driver, find(ap.getFullAddress()));
        find(ap.getFullAddress()).sendKeys(fakeAddress());
        Thread.sleep(1000);
        scrollToElement(driver, find(ap.getSaveAddressBtn()));

        find(ap.getSaveAddressBtn()).click();
        Thread.sleep(4000);

        // Continue Button
        find(ap.getContinueBtn()).click();
        Thread.sleep(1000);
    }
}
