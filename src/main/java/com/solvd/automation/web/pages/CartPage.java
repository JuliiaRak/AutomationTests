package com.solvd.automation.web.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

    @FindBy(css = ".cart-checkout-total")
    private ExtendedWebElement createOrderButton;

    @FindBy(css = ".cart-product-name")
    private ExtendedWebElement cartProductName;

    public CartPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(createOrderButton);
    }

    public String getCartProductName() {
        return cartProductName.getText();
    }
}
