package com.solvd.automation.web.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(css = ".header__logo__image")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//input[@data-option-create='Пошук']")
    private ExtendedWebElement searchInputField;

    @FindBy(xpath = "//watson-font-icon[@class='search']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//a[@title='Магазини']")
    private ExtendedWebElement shopsButton;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logo);
    }

    public void enterSearchQuery(String searchQuery) {
        searchInputField.type(searchQuery);
    }

    public SearchResultsPage clickSearchButton(){
        searchButton.click();
        return new SearchResultsPage(getDriver());
    }

    public MapPage clickShopsButton(){
        shopsButton.click();
        return new MapPage(getDriver());
    }
}
