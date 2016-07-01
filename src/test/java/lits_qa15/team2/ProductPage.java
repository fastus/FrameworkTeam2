package lits_qa15.team2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

	private WebDriver driver;
	
	public ProductPage (WebDriver driver) {
		this.driver = driver;
	}
//	(By.xpath("//*[@class="a_product_list"]"))
	public String getPriceText() {
		return driver.findElement(By.xpath("//*[@class='price']")).getText();
	}

}
