package com.solvd.automation;

import com.solvd.automation.web.components.ProductCardComponent;
import com.solvd.automation.web.pages.HomePage;
import com.solvd.automation.web.pages.SearchResultsPage;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.UUID;

public class WebTests extends AbstractTest {

    private static final String USER_NAME = R.TESTDATA.get("userName");

    private static final String PASSWORD = R.TESTDATA.get("password");

    private static final String ONE_WORD_SEARCH_INPUT = "сухий";

    @Test
    public void verifySearchFunctionality() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage.enterSearchQuery(ONE_WORD_SEARCH_INPUT);
        SearchResultsPage searchResultsPage = homePage.clickSearchButton();
        List<ProductCardComponent> products = searchResultsPage.getProducts();

        Assert.assertTrue(searchResultsPage.isPageOpened(), "Search results page is not opened");
        Assert.assertEquals(searchResultsPage.getSearchText(), ONE_WORD_SEARCH_INPUT, "Search text field does not contain search query word");
        for (int i = 0; i < 10; i++) {
            ProductCardComponent productCard = products.get(i);
            Assert.assertTrue(productCard.getProductTitle().toLowerCase().contains(ONE_WORD_SEARCH_INPUT.toLowerCase()), "Product card title does not contain search query word");
        }
    }

}
