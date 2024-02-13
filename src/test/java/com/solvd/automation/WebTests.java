package com.solvd.automation;

import com.solvd.automation.web.components.ProductCardComponent;
import com.solvd.automation.web.pages.*;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class WebTests extends AbstractTest {

    private static final String EMAIL = R.TESTDATA.get("email");

    private static final String PASSWORD = R.TESTDATA.get("password");

    private static final String ONE_WORD_SEARCH_INPUT = "гігієнічні";

    @Test(description = "Check the existence and proper work of the search field")
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

    @Test(description = "Check that after clicking on a 'Магазини' button, page with the addresses of all shops opens")
    public void verifyShopsPageOpensCorrectly() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        MapPage mapPage = homePage.getHeader().clickShopsButton();
        Assert.assertTrue(mapPage.isPageOpened(), "Page with shops map is not opened");

        AllShopsAddressesPage allShopsAddressesPage = mapPage.clickAllShopsButton();
        Assert.assertTrue(allShopsAddressesPage.isPageOpened(), "Page with all shops addresses is not opened");
    }

    @Test(description = "Attempt to log in with unregistered email must be failed and url should be changed")
    public void verifyUnregisteredEmailLogInAttempt() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        LogInPage logInPage = homePage.getHeader().clickLogInButton();
        Assert.assertTrue(logInPage.isPageOpened(), "LogIn page is not opened");

        //logInPage.enterEmail(EMAIL);
        logInPage.enterPassword(PASSWORD);
        String oldUrl = getDriver().getCurrentUrl();
        Assert.assertTrue(logInPage.clickLogInButtonIfPresent(), "Login button can not be clicked");
        Assert.assertNotEquals(getDriver().getCurrentUrl(), oldUrl, "Url did not changed");
    }

    @Test(description = "Check that all advertisements display essential information that is visible to the user.")
    public void verifyInformationOfProductDisplaysCorrectly() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        //int productIndex = new Random().nextInt(homePage.getProducts().size());
        int productIndex = 1;
        ProductCardComponent productCardComponent = homePage.getProducts().get(productIndex);
        String productCardComponentTitle = productCardComponent.getProductTitle();
        Assert.assertFalse(productCardComponentTitle.isEmpty());

        ProductDetailsPage productDetailsPage = productCardComponent.click();
        Assert.assertTrue(productDetailsPage.isPageOpened(), "Product details page is not opened");
        String productDetailsPageTitle = productDetailsPage.getProductTitle();
        Assert.assertFalse(productDetailsPage.getProductTitle().isEmpty());
        Assert.assertEquals(productCardComponentTitle, productDetailsPageTitle, "Product card title is not the same as product title on product details page");
    }

    @Test(description = "Check whether the product is added to the cart")
    public void verifyProductCorrectlyAddedToCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        //int productIndex = new Random().nextInt(homePage.getProducts().size());
        int productIndex = 1;
        ProductCardComponent productCardComponent = homePage.getProducts().get(productIndex);
        String productCardComponentTitle = productCardComponent.getProductTitle();
        productCardComponent.clickBuyButton();
        Assert.assertFalse(productCardComponentTitle.isEmpty());

        CartPage cartPage = homePage.clickCartButton();
        String cartProductName = cartPage.getCartProductName();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened");
        Assert.assertEquals(productCardComponentTitle, cartProductName, "Product name in cart is not the same as product name on home page");
    }
}