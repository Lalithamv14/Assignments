package SeriveNow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class OrderingMobile {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://dev116151.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//2. Login with valid credentials username as admin and password as India@123
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		driver.findElement(By.id("sysverb_login")).click();
		
//3. Click-AllEnter Service catalog in filter navigator and press enter 
		Shadow shadow= new Shadow(driver);
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//div[@id='all']").click();
		//shadow.findElementByXPath("//span[@class='chevron-container']").click();
		shadow.findElementByXPath("//span[text()='Service Catalog']").click();
		
//4. Click on  mobiles
		WebElement eleframe=shadow.findElementByXPath(("//iframe[@title='Main Content']"));
         driver.switchTo().frame(eleframe);
		 driver.findElement(By.xpath("(//div[@class='homepage_category_only']//table)[8]")).click();
		
//5.Select Apple iphone6s
		 driver.switchTo().defaultContent();
		 WebElement eleframe1=shadow.findElementByXPath(("//iframe[@id='gsft_main']"));
         driver.switchTo().frame(eleframe1);
         driver.findElement(By.xpath("//strong[text()='iPhone 6s']")).click();
         
	//6.Update color field to rose gold and storage field to 128GB	
         driver.switchTo().defaultContent();
		 WebElement eleframe2=shadow.findElementByXPath(("//iframe[@id='gsft_main']"));
         driver.switchTo().frame(eleframe2);
         WebElement select=driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
         Select color=new Select(select);
         color.selectByIndex(3);
         driver.switchTo().defaultContent();
		 WebElement eleframe3=shadow.findElementByXPath(("//iframe[@id='gsft_main']"));
         driver.switchTo().frame(eleframe3);
         WebElement select1=driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[2]"));
         Select size=new Select(select1);
         size.selectByIndex(2);
         
   //7.Select  Order now option
         driver.switchTo().defaultContent();
		 WebElement eleframe4=shadow.findElementByXPath(("//iframe[@id='gsft_main']"));
         driver.switchTo().frame(eleframe4);
         driver.findElement(By.xpath("//table[@id='qty']/tbody[1]/tr[8]/td[1]/button[1]")).click();
        
         
    //8.Verify order is placed and copy the request number
         driver.switchTo().defaultContent();
    	 WebElement eleframe5=shadow.findElementByXPath(("//iframe[@id='gsft_main']"));
         driver.switchTo().frame(eleframe5);
         String order=driver.findElement(By.xpath("//span[text()='Thank you, your request has been submitted']")).getText();
         System.out.println("Status of the order : " +order);
         if(order.contains("Thank you"))
         {
        	 System.out.println("order is placed");
         }
         else
         {
        	 System.out.println("order is not place");
         }
         String req = driver.findElement(By.xpath("//a[@class='linked requestItemUrl']//b[1]")).getText();
         System.out.println("Request number : " +req);
         Thread.sleep(2000);
         driver.close();
         
         
         
         
         
         
         
         
         
         
         
       
}}
