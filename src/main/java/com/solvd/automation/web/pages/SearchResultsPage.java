package com.solvd.automation.web.pages;

import com.solvd.automation.web.components.ProductCardComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends AbstractPage {

    @FindBy(css = ".search-page__title")
    private ExtendedWebElement title;

    @FindBy(css = ".search-page__title-text")
    private ExtendedWebElement searchText;

    @FindBy(xpath = "//div[contains(@class, 'plp-product-grid__item')]")
    private List<ProductCardComponent> products;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(title);
    }

    public String getSearchText() {
        return searchText.getText();
    }

    public List<ProductCardComponent> getProducts(){
        return products;
    }
}
