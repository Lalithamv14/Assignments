package assig.week4day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrame {

	public static void main(String[] args) throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  ChromeDriver driver=new ChromeDriver();
	  driver.get("https://jqueryui.com/sortable");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  
	  driver.switchTo().frame(0);
	
	 
	  WebElement item1 = driver.findElement(By.xpath("//ul[@id='sortable']//li[1]"));
		WebElement item2 = driver.findElement(By.xpath("//ul[@id='sortable']//li[2]"));
		WebElement item3 = driver.findElement(By.xpath("//ul[@id='sortable']//li[3]"));
		//WebElement item4 = driver.findElement(By.xpath("//ul[@id='sortable']//li[4]"));
		//WebElement item5 = driver.findElement(By.xpath("//ul[@id='sortable']//li[5]"));
		// item6 = driver.findElement(By.xpath("//ul[@id='sortable']//li[6]"));
		//WebElement item7 = driver.findElement(By.xpath("//ul[@id='sortable']//li[7]"));
		driver.executeScript("arguments[0].scrollIntoView();", item1);
		Actions builder = new Actions(driver);
		builder.dragAndDrop(item2, item3).perform();
	  
	  
	}

}
