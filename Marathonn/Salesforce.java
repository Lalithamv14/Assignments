package Marathonn;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce extends BaseClass
{
	@BeforeTest
	public void setfilename()
	{
		filename="salesexcelqn";
	}

		@Test(dataProvider="testData")
	public  void salesForce(String qun,String data) throws InterruptedException
	{
		


//03) Click on the App Launcher (dots)
			Thread.sleep(2000);
driver.findElement(By.className("slds-r2")).click();

//04) Click View All

driver.findElement(By.xpath("//button[text()='View All']")).click();
Set<String>windowHandles=driver.getWindowHandles();
List<String>swi=new ArrayList<String>(windowHandles);
driver.switchTo().window(swi.get(0));

//05) Type Content on the Search box

driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Content");

//06) Click Content Link
driver.findElement(By.xpath("//mark[text()='Content']")).click();

//07) Click on Chatter Tab
driver.switchTo().defaultContent();
WebElement element=driver.findElement(By.xpath("//span[text()='Chatter']"));
JavascriptExecutor executor = (JavascriptExecutor)driver;
executor.executeScript("arguments[0].click();", element);

//08) Verify Chatter title on the page
String title=driver.getTitle();
System.out.println(title);

//09) Click Question tab
driver.findElement(By.xpath("(//span[@class='title'])[3]")).click();

//10) Type Question with data
driver.findElement(By.tagName("textarea")).sendKeys(qun);

//11) Type Details with data
driver.findElement(By.xpath("//div[contains(@class,'ql-editor ql-blank')]")).sendKeys(data);

//12) Click Ask
driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button_brand')]")).click();

String text= driver.findElement(By.xpath("(//span[@class='uiOutputText'])[3]")).getText();
System.out.println(text);



	}
}
