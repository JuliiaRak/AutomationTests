package com.solvd.automation.web.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AllShopsAddressesPage extends AbstractPage {

    @FindBy(css = ".owl-stage")
    private ExtendedWebElement lettersTape;

    public AllShopsAddressesPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(lettersTape);

    }
}
