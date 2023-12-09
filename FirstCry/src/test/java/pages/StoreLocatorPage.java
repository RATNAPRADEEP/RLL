package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class StoreLocatorPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//span[@class='anch myacc_2']")
	public WebElement myAccount;
	
	@FindBy(xpath = "(//a[text()='My Profile'])[1]")
	public WebElement myProfile;
	
	@FindBy(xpath = "//*[@id='profile1']/div/div[3]/div[1]/div/span")
	public WebElement profileEmail;
	
	@FindBy(xpath = "//span[contains(text(),'Stores & Preschools')]")
	public WebElement Storesandpreschools;
	
	@FindBy(xpath = "//span[normalize-space()='Find Stores']")
	public static WebElement FindStores;
	


	public StoreLocatorPage(WebDriver driver) {
	    super();
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	public void goToProfile() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(myAccount);
		Thread.sleep(2000);
		action.moveToElement(myProfile);
		action.click().build().perform();
	}
	
	
	public void goToStoresandPreschools() throws InterruptedException {
		 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(1));
		 Thread.sleep(2000);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getProfileEmail() {
		return profileEmail.getText();
	}

	public void StoresandPreschools() {
		Storesandpreschools.click();
	}
	public void clickFindStores() {
		FindStores.click();
	}
}

