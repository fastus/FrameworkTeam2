package lits_qa15.team2;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import lits_qa15.team2.WebDriverFactory;

public class TestPage {
	private WebDriver driver;

	@BeforeMethod
	@Parameters({ "browserName" })
	public void setUp(String browserName){
		driver = WebDriverFactory.getInstance(browserName);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@DataProvider (name = "user1")
	public Object[][] floriumUsers() {
		return new Object[][] { 
								{ "fastest956@gmail.com", "1t2t3456789tt"}
							  };
	}
	@DataProvider (name = "user2")
	public Object[][] floriumUsers2() {
		return new Object[][] { 
								{ "fastest956@gmail.com", "1t2t3456789t"}
							  };
	}
	
	@AfterMethod
    public void tearDown() {
    	if (driver != null) {
			WebDriverFactory.killDriverInstance();
		}
    }
	
//	@Test (dataProvider = "user1")
//	public void testLogin1 (String login, String password){
//		HomePage home = new HomePage(driver);
//		LoggedPage logPage = home.login(login, password);
//		Assert.assertTrue(logPage.getLogoutText().contains("Выход"));
//	}
//	@Test (dataProvider = "user2")
//	public void testLogin2 (String login, String password){
//		HomePage home = new HomePage(driver);
//		LoggedPage logPage = home.login(login, password);
//		Assert.assertTrue(logPage.getLogoutText().contains("Выход"));
//	}
	@Test (dataProvider = "user1")
	public void testSearch (String login, String password){
		HomePage home = new HomePage(driver);
		LoggedPage logPage = home.login(login, password);
		ResultPage result = logPage.searchText("Тюльпаны");
		result.maximize();
		Reporter.log("performing image click...", true);
		ProductPage prodPage = result.clickOnImage("tulipa-miranda-1.jpg");
				
		Assert.assertTrue(prodPage.getPriceText().contains("грн"));
	}
}
