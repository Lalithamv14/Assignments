package assig.week4day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag {

	public static void main(String[] args) throws InterruptedException {
		
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver=new ChromeDriver();
			driver.get("https://www.leafground.com/drag.xhtml");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			Actions act=new Actions(driver);
			
			//draggable columns
			WebElement source=driver.findElement(By.xpath("//th[@id='form:j_idt94:j_idt95']"));

			WebElement target=driver.findElement(By.xpath("//th[@id='form:j_idt94:j_idt99']"));
			act.dragAndDrop(source, target).perform();
			String message=driver.findElement(By.xpath("//span[text()='Columns reordered']")).getText();
			System.out.println(message);
		
	//draggable rows
			WebElement row4 = driver.findElement(By.xpath("//tbody[@id='form:j_idt111_data']/tr[5]/td[1]"));
			//WebElement row5 = driver.findElement(By.xpath("//tbody[@id='form:j_idt111_data']/tr[6]/td[1]"));
			WebElement row6 = driver.findElement(By.xpath("//tbody[@id='form:j_idt111_data']/tr[7]/td[1]"));
			act.dragAndDrop(row6, row4).perform();
			String msg = driver.findElement(By.xpath("//span[text()='Row moved']")).getText();
			System.out.println(msg);

			Thread.sleep(200);
			
			//Image resized
	WebElement testleafImg = driver.findElement(By.xpath("//img[@class='shadow-1 ui-resizable']"));
		act.scrollToElement(testleafImg).perform();
		act.moveByOffset(60, 0).perform();
		String msg1=driver.findElement(By.xpath("//span[@class='ui-growl-image ui-growl-image-info']")).getText();
		System.out.println(msg1);
		
		//range Slider
		WebElement slider=driver.findElement(By.xpath("//div[contains(@class,'ui-slider-range ui-corner-all')]/following-sibling::span[1]"));
		Actions move=new Actions(driver);
		move.moveToElement(slider).clickAndHold().moveByOffset(20,0).release().perform();
		WebElement Slide=driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle ui-corner-all')]/following-sibling::span[1]"));
		move.moveToElement(Slide).clickAndHold(Slide).moveByOffset(50, -60).release().perform();
		
		
	   
	}

}
