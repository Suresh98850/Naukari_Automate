package Fastwinning;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Tradingmoney {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://fastwin-trade.in/#/fastparity");
		driver.manage().window().maximize();
		driver.findElement(By.id("emob")).sendKeys("9490453422");
		driver.findElement(By.id("epass")).sendKeys("Suresh@1998");
		driver.findElement(By.id("lnxG")).click();
		Thread.sleep(3000);
		//driver.findElement(By.tagName("img")).click();
		
	Actions act=new Actions(driver);
	act.moveByOffset(100, 300).click().build().perform();
	List<WebElement>list= driver.findElements(By.tagName("img"));
	list.get(4).click();
	//driver.switchTo().alert().dismiss();
//		act.sendKeys(Keys.ENTER);

	}

}
