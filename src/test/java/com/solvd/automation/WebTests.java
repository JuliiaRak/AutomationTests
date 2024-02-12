package com.solvd.automation;

import com.solvd.automation.web.components.ProductCardComponent;
import com.solvd.automation.web.pages.*;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTests extends AbstractTest {

    private static final String EMAIL = R.TESTDATA.get("email");

    private static final String PASSWORD = R.TESTDATA.get("password");

    private static final String ONE_WORD_SEARCH_INPUT = "гігієнічні";

    @Test
    public void verifySearchFunctionality() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage.enterSearchQuery(ONE_WORD_SEARCH_INPUT);
        SearchResultsPage searchResultsPage = homePage.clickSearchButton();
        Assert.assertTrue(searchResultsPage.isPageOpened(), "Search results page is not opened");
        Assert.assertEquals(searchResultsPage.getSearchText(), ONE_WORD_SEARCH_INPUT, "Search text field does not contain search query word");

        List<ProductCardComponent> products = searchResultsPage.getProducts();
        for (ProductCardComponent productCard : products) {
            Assert.assertTrue(productCard.getProductTitle().toLowerCase().contains(ONE_WORD_SEARCH_INPUT.toLowerCase()), "Product card title does not contain search query word");
        }
    }

    @Test
    public void verifyShopsPageOpensCorrectly() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        MapPage mapPage = homePage.clickShopsButton();
        Assert.assertTrue(mapPage.isPageOpened(), "Page with shops map is not opened");

        AllShopsAddressesPage allShopsAddressesPage = mapPage.clickAllShopsButton();
        Assert.assertTrue(allShopsAddressesPage.isPageOpened(), "Page with all shops addresses is not opened");
    }

    @Test
    public void verifyUnregisteredEmailLogInAttempt() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        LogInPage logInPage = homePage.clickLogInButton();
        Assert.assertTrue(logInPage.isPageOpened(), "LogIn page is not opened");

//        logInPage.enterEmail(EMAIL);
//        logInPage.enterPassword(PASSWORD);
//        logInPage.clickLogInButton();
//
//        Assert.assertEquals(logInPage.getErrorMessage(), "Неправильний логін або пароль", "Message with informing about an incorrect login or password did not appear");
    }

}
