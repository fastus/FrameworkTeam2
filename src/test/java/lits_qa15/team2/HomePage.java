package lits_qa15.team2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class HomePage {

	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public LoggedPage login(String login, String password) {
		Reporter.log("opening florium.ua...", true);
		driver.get("https://florium.ua/");

		Reporter.log("performing Login click...", true);
		driver.findElement(By.linkText("Логин")).click();
		
		explicitWait(driver, By.id("login"));
		
		WebElement emailField = driver.findElement(By.id("login"));
		emailField.clear();
		Reporter.log("filling email field...", true);
		emailField.sendKeys(login);


		WebElement pwdField = driver.findElement(By.id("password"));
		Reporter.log("filling password field...", true);
		pwdField.clear();
		pwdField.sendKeys(password);

//		Reporter.log("unchecking remember checkbox...", true);
		
//		driver.findElement(By.className("checkbox")).click();
		Reporter.log("performing signing click...", true);
		driver.findElement(By.id("send2")).click();
		
//		explicitWait(driver, By.linkText("Выход"));
		return new LoggedPage(driver);
	}
	
	public static WebElement explicitWait(WebDriver driver, final By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
}
