package steps;

import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;
import pages.LoggedInPage;
import pages.LoginPage;
import pages.StoreLocatorPage;
import pages.base.Base;

public class TestStoreLocator {
	HomePage homePage;
	LoginPage loginPage;
	LoggedInPage loggedInPage;
	StoreLocatorPage StoreLocatorPage;

	@Given("I oopen the browser and enter URL")
	public void i_open_the_browser_and_enter_url() {
		homePage = new HomePage(Base.driver);
        loginPage = new LoginPage(Base.driver);
        loggedInPage = new LoggedInPage(Base.driver);
        StoreLocatorPage = new StoreLocatorPage(Base.driver);
	}

	@Then("I cclick on Login link and enter the email id {string}")
	public void i_click_on_login_link_and_enter_the_email_id(String string) throws InterruptedException {
		homePage.clickOnLogin();
        loginPage.email.sendKeys(string);
        Thread.sleep(2000);
        loginPage.continueBtn.click();
        Thread.sleep(30000);
        loginPage.verifyOtpBtn.click();
	}

	@Then("I vverify the {string} of the FirstCryPage")
	public void i_verify_the_of_the_first_cry_page(String string) {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(loggedInPage.getTitle(), string, "The title donot match");
	}
	
	@Then("I cclick on Stores&Preschools")
	public void i_click_on_stores_preschools() {
	    StoreLocatorPage.StoresandPreschools();
	}

	@Then("I Ccllick on findstores")
	public void i_cllick_on_findstores() {
	    StoreLocatorPage.clickFindStores();
	   
	}

	    
}

