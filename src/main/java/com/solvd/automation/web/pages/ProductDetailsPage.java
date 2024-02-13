package com.solvd.automation.web.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends AbstractPage {

    @FindBy(css = ".pdp-details__name")
    private ExtendedWebElement productTitle;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(productTitle);
    }

    public String getProductTitle() {
        return productTitle.getText();
    }
}
