package com.searchmodule.tests;

import com.searchmodule.pages.SearchPage;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class SearchTest extends BaseTest {

    @Test
    @Parameters({"searchTxt"})
    public void search(@Optional("java") String searchTxt) {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo();
        searchPage.doSearch(searchTxt);
        searchPage.goToVideos();
        int size = searchPage.getResult();

        Assert.assertTrue(size > 0);
    }
}
