package com.searchModule.Test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.searchModule.Pages.SearchPage;

import tests.BaseTest;

public class SearchTest extends BaseTest {

	@Test
	@Parameters({ "keyword" })
	public void search(String keyword) {
		SearchPage searchPage = new SearchPage(driver);
		searchPage.goTo();
		searchPage.doSearch(keyword);
		searchPage.goToVideos();
		int size = searchPage.getResult();
		Assert.assertTrue(size > 0);
	}

}
