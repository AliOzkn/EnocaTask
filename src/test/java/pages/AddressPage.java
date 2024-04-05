package pages;

import org.openqa.selenium.By;

public class AddressPage {

    protected By addNewAddressBtn = By.xpath("(//div[@class='add-new-address-button'])[1]");
    protected By shortAddressName = By.xpath("(//input[@placeholder='Adres Kolay Ad\u0131'])[2]");
    protected By city = By.xpath("//select[@id='ShippingNewAddress_CountryId']");
    protected By cityOptions = By.xpath("//select[@id='ShippingNewAddress_CountryId']/option");
    protected By state = By.xpath("//select[@id='ShippingNewAddress_StateProvinceId']");
    protected By stateOptions = By.xpath("//select[@id='ShippingNewAddress_StateProvinceId']/option");
    protected By neighborhood = By.xpath("//select[@id='ShippingNewAddress_NeighborhoodId']");
    protected By neighborhoodOptions = By.xpath("//select[@id='ShippingNewAddress_NeighborhoodId']/option");
    protected By fullAddress = By.xpath("(//textarea[@placeholder='Adres'])[2]");
    protected By saveAddressBtn = By.xpath("(//div[@class='cl-address-edit-section'])[2]/input[@value='Kaydet']");
    protected By continueBtn = By.xpath("(//div[@class='cl-checkout-tab-section-buttons'])[1]/input[@value='Devam Et']");

    public By getAddNewAddressBtn() {
        return addNewAddressBtn;
    }

    public By getShortAddressName() {
        return shortAddressName;
    }

    public By getCity() {
        return city;
    }

    public By getCityOptions() {return cityOptions;}

    public By getState() {
        return state;
    }

    public By getStateOptions() {
        return stateOptions;
    }

    public By getNeighborhood() {return neighborhood;}

    public By getNeighborhoodOptions() {
        return neighborhoodOptions;
    }

    public By getFullAddress() {
        return fullAddress;
    }

    public By getSaveAddressBtn() {
        return saveAddressBtn;
    }

    public By getContinueBtn() {return continueBtn;}
}
