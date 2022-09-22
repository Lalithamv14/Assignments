package Marathonn;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesfor extends BaseClass{


	@BeforeTest
	public void setfilename()
	{
		filename="salesforceexcel";
	}

		@Test(dataProvider="testData")
	public  void salesForce(String search,String salu,String lname,String searc) throws InterruptedException
	{
		

		//03) Click on the App Launcher (dots)
Thread.sleep(2000);
driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-icon-waffle_container')]")).click();

//04) Click View All
driver.findElement(By.xpath("//button[text()='View All']")).click();
Set<String>windowHandles=driver.getWindowHandles();
List<String>swi=new ArrayList<String>(windowHandles);
driver.switchTo().window(swi.get(0));

//05) Type Individuals on the Search box

	driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(search);

	//06) Click Individuals Link

	driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
	
	//07) Click New
	driver.findElement(By.xpath("//div[@title='New']")).click();
	
	//08) Select Salutation with data (coming from excel) 

	driver.findElement(By.xpath("//a[@class='select']")).sendKeys(salu);
	
	//09) Type Last Name 
	driver.findElement(By.xpath("//input[contains(@class,'lastName compoundBLRadius')]")).sendKeys(lname);
	
	//10) Click Save
	driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
	String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage slds-text-heading--small')]")).getText();
	System.out.println(msg);
	String title=driver.getTitle();
	System.out.println(title);

	//11) Click on the App Launcher (dots)
	Thread.sleep(20000);	
	driver.findElement(By.xpath("//div[@class='slds-r8']/following-sibling::div[1]")).click();
	
	//12) Click View All
driver.findElement(By.xpath("//button[text()='View All']")).click();

//13) Type Customers on the Search box
driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys(searc);
	
//14) Click Customers Link
Thread.sleep(1000);
driver.findElement(By.xpath("//mark[text()='Customers']")).click();
//15) Click New
Thread.sleep(1000);
driver.findElement(By.xpath("//div[@title='New']")).click();

//16) Type the same name provided in step 8 and confirm it appears

	List<WebElement> list = driver.findElements(By.xpath("//div[@class='primaryLabel slds-truncate slds-lookup__result-text']"));
    
    List<String> list1=new ArrayList<String>();
    for(WebElement each : list) {
  	   String text=each.getText();
  	   list1.add(text);
    }
		
	        if(list1.contains(lname)) 
	        {
      	System.out.println("Name exists");}
          else {
      	System.out.println("Name doesnot exists");
}
	
	
	
	}

}
