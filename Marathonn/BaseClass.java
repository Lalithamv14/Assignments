package Marathonn;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import DataIntegration.ReadExcelFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public ChromeDriver driver;
	public String filename;
	@Parameters({"url","username","password"})
		@BeforeMethod
		
		 public void precondition(String url,String username,String password)
		 {
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			//02) Login to Salesforce with your username and password
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("Login")).click();

			
		}
	@AfterMethod
		public void postCondition()
		{
			driver.close();
		}
	@DataProvider
	public String[][] testData() throws IOException
	{
		String[][] readData = ReadExcelFile.readData(filename);
		return readData;
		
	}
	}




