package com.solvd.automation.web.components;

import com.solvd.automation.web.pages.ProductDetailsPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductCardComponent extends AbstractUIObject {

    @FindBy(xpath = ".//div[@class='product-tile__product-name']//p")
    private ExtendedWebElement productTitle;

    @FindBy(xpath = ".//watson-buy-button[contains(@class, 'pdp-buy-button')]")
    private ExtendedWebElement buyButton;

    public ProductCardComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductTitle() {
        waitUntil(ExpectedConditions.visibilityOf(productTitle.getElement()), 10);
        return productTitle.getText();
    }

    public ProductDetailsPage click() {
        productTitle.click();
        return new ProductDetailsPage(getDriver());
    }

    public void clickBuyButton() {
        buyButton.click();
    }
}
