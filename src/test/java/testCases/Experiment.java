package testCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Experiment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.flipkart.com/search?q=iphone%2015&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
		
		driver.findElement(By.xpath("//div[@class='KzDlHZ']")).click();
		
		Set<String> winIds = driver.getWindowHandles();
		List<String> winList = new ArrayList(winIds);
		String parent = winList.get(0);
		String child = winList.get(1);
		driver.switchTo().window(child); 
		driver.findElement(By.xpath("//a[@class='CDDksN']")).click();
	}

}
