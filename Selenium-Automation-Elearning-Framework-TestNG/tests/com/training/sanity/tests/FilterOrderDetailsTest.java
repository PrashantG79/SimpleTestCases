package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.FilterOrderDetails;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class FilterOrderDetailsTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private FilterOrderDetails FilterOrderDetails;
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
	public void filterOrder() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		FilterOrderDetails.cartSelect();
		FilterOrderDetails.viewDisplayedOnCartSelect();
		FilterOrderDetails.orderSelect();
		FilterOrderDetails.sendOrderId("188");
		FilterOrderDetails.filterClick();
		FilterOrderDetails.tryCheck();
		driver.findElement(By.id("input-order-id")).clear();
		
		FilterOrderDetails.custData("manzoor mehadi");
		
		FilterOrderDetails.filterClick();
		FilterOrderDetails.filterByCustName();
		screenShot.captureScreenShot("FilterOrderDetails-Screenshot");	
		}
	
	
	
	
}


