package com.vtiger.genericLib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.objectRepo.HomePage;
import com.vtiger.objectRepo.LoginPage;


public class BaseClass {

	public FileData data = new FileData();
	public static WebDriver driver = null;
	@BeforeSuite
	public void configBS()
	{
		System.out.println("-----DB Connection Start-----");
	}
	@BeforeClass
	public void configBC() throws IOException
	{
		String browser = data.fetchDataFromProperty("browser");
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	public WebDriverCommonLib wlib = new WebDriverCommonLib();
	/*This method is used to perform login operation
	 * 
	 * @author=Uday
	 * @inputs=username,password
	 * 
	 */
	
	@BeforeMethod
	public void configBM() throws IOException
	{
	//	LoginPOMClass login = new LoginPOMClass(driver);
		driver.get(data.fetchDataFromProperty("url"));
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.getUn().sendKeys(data.fetchDataFromProperty("un"));
		login.getPwd().sendKeys(data.fetchDataFromProperty("pwd"));
		login.getLoginbtn().click();
	}
	@AfterMethod
	public void configAM()
	{
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		wlib.moveMousePointer(hp.getLogoutBtn());
		hp.getSignOutLink().click();
	}
	@AfterClass
	public void configAC()
	{
		driver.quit();
	}
	@AfterSuite
	public void configAS()
	{
		System.out.println("-----DB Connection End-----");
	}

}
