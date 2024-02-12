package com.solvd.automation.web.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends AbstractPage {

    @FindBy(xpath = "//h4[text()='Вхід']")
    private ExtendedWebElement logInTitle;

    @FindBy(xpath = "//input[@name='j_username']")
    //@FindBy(xpath = "//watson-pretty-form-email")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//input[@name='j_password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//watson-button[@class='btn--login_submit']")
    private ExtendedWebElement logInButton;

    @FindBy(css = ".global-message__text")
    private ExtendedWebElement errorMessage;

    public LogInPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logInTitle);
    }

    public void enterEmail(String email) {
        emailField.type(email);
    }

    public void enterPassword(String password) {
        passwordField.type(password);
    }

    public void clickLogInButton(){
        logInButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
