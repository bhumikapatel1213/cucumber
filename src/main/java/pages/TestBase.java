package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static WebDriver driver;
	
	public static void initDriver() {
		System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void clickOnButton(WebElement ele) { 
		  try {
		  ele.click(); 
		  }catch(Exception e) {
		   e.printStackTrace();
		  }  
		 }
		 	
	public void takeScreenshot(WebDriver driver) {
		  
		  TakesScreenshot ts =  (TakesScreenshot)driver;
		  File sourceFile = ts.getScreenshotAs(OutputType.FILE);  
		  String curentDirectory = System.getProperty("user.dir");
		  
		  SimpleDateFormat formatter = new SimpleDateFormat("MMddyy_HHmmss");
		  Date date = new Date();
		  String label = formatter.format(date);
		  
		  try {
		   FileUtils.copyFile(sourceFile, new File(curentDirectory + "/screenshot/" + label + ".png"));
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		  
		 }
}
