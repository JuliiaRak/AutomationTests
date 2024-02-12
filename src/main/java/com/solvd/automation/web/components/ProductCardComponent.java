package com.solvd.automation.web.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductCardComponent extends AbstractUIObject {

    @FindBy(xpath = " .//div[@class='product-tile__product-name']//p")
    private ExtendedWebElement productTitle;

    public ProductCardComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductTitle() {
        return productTitle.getText();
    }
}
