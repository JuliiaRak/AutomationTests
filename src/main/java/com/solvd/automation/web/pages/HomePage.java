package com.solvd.automation.web.pages;

import com.solvd.automation.web.components.HeaderComponent;
import com.solvd.automation.web.components.ProductCardComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(css = ".header__logo__image")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//input[@data-option-create='Пошук']")
    private ExtendedWebElement searchInputField;

    @FindBy(xpath = "//watson-font-icon[@class='search']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//header")
    private HeaderComponent header;

    @FindBy(xpath = "//div[@class='product-tile__content']")
    private List<ProductCardComponent> products;

    @FindBy(xpath = "//watson-font-icon[@icon='bag']")
    private ExtendedWebElement cartButton;

    @FindBy(css = ".light-header__element-quantity")
    private ExtendedWebElement productsInCartNumber;

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

    public CartPage clickCartButton(){
        waitUntil(ExpectedConditions.visibilityOf(productsInCartNumber.getElement()), 10);
        cartButton.click();
        return new CartPage(getDriver());
    }

    public HeaderComponent getHeader() {
        return header;
    }

    public List<ProductCardComponent> getProducts(){
        return products;
    }
}
