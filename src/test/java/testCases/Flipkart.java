package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {
 //name , link // price for every phone    //  //
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/search?q=iphone%2015&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
		
	 	// printing name of every phone
		List<WebElement> listOfName = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
		System.out.println(listOfName.size());
		for(WebElement ele : listOfName) {
			System.out.println(ele.getText());
		}
		
		//printing prices of iphones
		
		List<WebElement> listOfPrice = driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
		System.out.println(listOfPrice.size());
		for(WebElement ele : listOfPrice) {
			System.out.println(ele.getText());
		}

		//printing links 
		List<WebElement> LinkOfPhones = driver.findElements(By.xpath("//a[@class='CGtC98']"));
		System.out.println(LinkOfPhones.size());
		for(WebElement ele : LinkOfPhones) {
			String hrefAttribute = ele.getAttribute("href");
			System.out.println(hrefAttribute);
		}
	 	
	}

}
