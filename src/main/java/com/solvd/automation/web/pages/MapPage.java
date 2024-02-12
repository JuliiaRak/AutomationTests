package com.solvd.automation.web.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MapPage extends AbstractPage {

    @FindBy(xpath = "//h1[text()='Карта магазинiв']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//div[contains(@class, 'store-locator-search__form-input--right')]//a[contains(@class, 'store-locator-search__form-input-link')]")
    private ExtendedWebElement allShopsButton;

    public MapPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(title);
    }

    public AllShopsAddressesPage clickAllShopsButton(){
        waitUntil(ExpectedConditions.visibilityOf(allShopsButton.getElement()), 10);
        allShopsButton.click();
        return new AllShopsAddressesPage(getDriver());
    }
}
