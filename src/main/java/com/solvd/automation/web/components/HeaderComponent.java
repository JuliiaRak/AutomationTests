package com.solvd.automation.web.components;

import com.solvd.automation.web.pages.LogInPage;
import com.solvd.automation.web.pages.MapPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends AbstractUIObject {

    @FindBy(xpath = ".//a[@title='Магазини']")
    private ExtendedWebElement shopsButton;

    @FindBy(xpath = ".//img[contains(@class, 'header__login__icon')]")
    private ExtendedWebElement logInButton;

    public HeaderComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public MapPage clickShopsButton(){
        shopsButton.click();
        return new MapPage(getDriver());
    }

    public LogInPage clickLogInButton(){
        logInButton.click();
        return new LogInPage(getDriver());
    }
}
