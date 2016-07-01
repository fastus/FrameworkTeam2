package lits_qa15.team2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoggedPage {

	private WebDriver driver;
	
	public LoggedPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public ResultPage searchText (String text){
		WebElement search = driver.findElement(By.id("search"));
		search.sendKeys(text);
		search.sendKeys(Keys.ENTER);
		return new ResultPage(driver);
	}
	public String getLogoutText() {
		return driver.findElement(By.linkText("Выход")).getText();
	}
}
