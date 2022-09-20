package Marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonBag {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//03) Type "Bags" in the Search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags");
		
		//04) Choose the third displayed item in the result 
	driver.findElement(By.xpath("//span[text()=' for women']")).click();
	Thread.sleep(200);
	
	//05) Print the total number of results (like 20000)
	String results = driver.findElement(By.xpath("//span[text()='1-48 of over 70,000 results for']")).getText();
System.out.println("Total number of results: " +results);

//06) Select the first 2 brands in the left menu
driver.findElement(By.xpath("(//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left'])[3]")).click();
driver.findElement(By.xpath("(//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left'])[4]")).click();

String results1 = driver.findElement(By.xpath("//div[contains(@class,'a-section a-spacing-small')]//span")).getText();
System.out.println("Total number of results after: " +results1);

//07) Confirm the results have got reduced (use step 05 for compare)
if(results==results1)
{
	System.out.println("Results not reduced");
}
else
{
	System.out.println("Results got reduced");
}

//08) Choose New Arrivals (Sort)

driver.findElement(By.xpath("//span[text()='Featured']")).click();
driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();

//09) Print the first resulting bag info (name, discounted price)

String brand = driver.findElement(By.xpath("(//span[text()='Generic'])[2]")).getText();
System.out.println("Bag name :" + brand);
String  bagprice= driver.findElement(By.xpath("//span[text()='531']")).getText();
System.out.println("BAG PRICE: " +bagprice);

//10) Confirm the color of the 'Deal of the day' is in kind of Red
System.out.println("There is no Deal of the Day");

//12) Confirm the price on previous and this page are same 
driver.findElement(By.xpath("//span[text()='531']")).click();

Set<String>whandle=driver.getWindowHandles();
List<String>swi=new ArrayList<String>(whandle);
driver.switchTo().window(swi.get(1));
String pri = driver.findElement(By.xpath("(//span[text()='531'])[2]")).getText();
System.out.println(pri);

if(bagprice.equals(pri))
{
	System.out.println("Price are same");
}

else
{
	System.out.println("Price are not same");
}
//Take a screen shot of the product displayed
	File source=driver.getScreenshotAs(OutputType.FILE);
	File dest=new File("./Image/shot.jpg");
	FileUtils.copyFile(source, dest);



















	}

}
