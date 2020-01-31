package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.FilterOrderDetails;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class FilterReturnListTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private FilterOrderDetails FilterOrderDetails;
	private com.training.pom.FilterReturnList FilterReturnList;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		FilterOrderDetails = new FilterOrderDetails (driver);
		FilterReturnList = new com.training.pom.FilterReturnList (driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void filterReturnOrd() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		FilterOrderDetails.cartSelect();
		FilterOrderDetails.viewDisplayedOnCartSelect();
		FilterReturnList.returnSelect();
		FilterReturnList.sendReturnId("198");
		FilterOrderDetails.filterClick();
		FilterReturnList.tryAndCheck();
		FilterOrderDetails.custData("Prashant G");
		FilterOrderDetails.filterClick();
		FilterReturnList.returnListFilterByCustName();
		screenShot.captureScreenShot("FilterReturnOrder-ScreenShot");
		
		
		}
	
}


