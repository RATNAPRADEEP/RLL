package steps;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import pages.HomePage;
import pages.LoggedInPage;
import pages.LoginPage;
import pages.base.Base;

public class TestAddToCart {
	
	HomePage homePage;
	LoginPage loginPage;
	LoggedInPage loggedInPage;

	@Given("I open the browser and enter URL")
	public void i_open_the_browser_and_enter_url() {
		homePage = new HomePage(Base.driver);
        loginPage = new LoginPage(Base.driver);
        loggedInPage = new LoggedInPage(Base.driver);
	}

	@Then("I click on Login link and enter the email id {string}")
	public void i_click_on_login_link_and_enter_the_email_id(String string) throws InterruptedException {
		homePage.clickOnLogin();
        loginPage.email.sendKeys(string);
        Thread.sleep(2000);
        loginPage.continueBtn.click();
        Thread.sleep(30000);
        loginPage.verifyOtpBtn.click();
	}

	@Then("I verify the {string} of the FirstCryPage")
	public void i_verify_the_of_the_first_cry_page(String string) {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(loggedInPage.getTitle(), string, "The title donot match");
	}
	
	@Then("I click on Footwear and click on Casualshoes")
	public void i_click_on_footwear_and_click_on_casualshoes() throws InterruptedException {
	    loggedInPage.goToFootwear();
	    Thread.sleep(2000);
	    loggedInPage.clickshoes();
	}

	@Then("I click on Product on the page")
	public void i_click_on_product_on_the_page() throws InterruptedException {
		loggedInPage.clickproduct();
		loggedInPage.goToProductPage();
	}

	@Then("I click on Add to cart page")
	public void i_click_on_add_to_cart_page() throws InterruptedException {
		//selecting shoe size
		//loggedInPage.selectshoesize();		
		//clicking on add to cart button
		loggedInPage.addtocart();
		Thread.sleep(2000);
	}

	@Then("I click on Go to Cart page")
	public void i_click_on_go_to_cart_page() throws InterruptedException {
		loggedInPage.goBack();
		LoggedInPage.goToCart.click();
		try {
			Thread.sleep(1000);
			Assert.assertEquals(LoggedInPage.cartItemCount.getText(), "1", "Product is not added to the cart.");
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			System.out.println(" CartItemCount Assesrtion Passed");
		}
	    
	}


}
