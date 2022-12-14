package SeriveNow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class NewProposal {

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
		
//3. Click All and Enter Proposal in filter navigator and press enter 
	
		Shadow shadow= new Shadow(driver);
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//div[@id='all']").click();
		WebElement prop=shadow.findElementByXPath("//input[@id='filter']");
		prop.sendKeys("proposal",Keys.ENTER);
		shadow.findElementByXPath("//div[@id='all']").click();
		prop.sendKeys(Keys.ENTER);

	//4. Click- new  and  fill mandatory fields and click 'Submit' Button.
			driver.switchTo().defaultContent();
			WebElement eleframe=shadow.findElementByXPath(("//iframe[@title='Main Content']"));
	        driver.switchTo().frame(eleframe);
			driver.findElement(By.id("sysverb_new")).click();
			driver.findElement(By.xpath("//span[@class='icon icon-lightbulb']")).click();
			Set<String>windowHandles=driver.getWindowHandles();
			List<String>swi=new ArrayList<String>(windowHandles);
			driver.switchTo().window(swi.get(1));
			driver.findElement(By.linkText("Issue with a web page")).click();
			driver.switchTo().window(swi.get(0));
			WebElement eleframe1=shadow.findElementByXPath(("//iframe[@title='Main Content']"));
	        driver.switchTo().frame(eleframe1);
			
			driver.findElement(By.id("sysverb_insert")).click();
			
	//5. Verify the successful creation of new Proposal"
			driver.switchTo().defaultContent();
			WebElement eleframe2=shadow.findElementByXPath(("//iframe[@title='Main Content']"));
	        driver.switchTo().frame(eleframe2);
		    driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Issue with a web page",Keys.ENTER);
		    String text=driver.findElement(By.xpath("(//td[text()='Issue with a web page'])[2]")).getText();
		    System.out.println("New Proposal : " +text);
		    if(text.contains("Issue with a web page"))
		    {
		    	System.out.println("Proposal " +text+ " is created newly");
		    }
		    else
		    {
		    	System.out.println("Proposal " +text+ "is not created newly");
		    }
	        Thread.sleep(2000);
		
	}
	}

	
