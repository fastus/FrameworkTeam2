package lits_qa15.team2;

import org.openqa.selenium.WebDriver;

public class ResultPage {

	private WebDriver driver;

	public ResultPage(WebDriver driver) {
		this.driver = driver;
	}
	public void maximize(){
		driver.manage().window().maximize();
	}
	
	public ProductPage clickOnImage(String imageName){
	SikuliImageRecognition imageRecognition = new SikuliImageRecognition();
	imageRecognition.clickOnImage(imageName);
	return new ProductPage(driver);
	}
}
