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

public class FilterCustomerListTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private FilterOrderDetails FilterOrderDetails;
	private com.training.pom.FilterCustomerList FilterCustomerList;
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
		FilterCustomerList = new com.training.pom.FilterCustomerList(driver);
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
	public void filterCustomerOrder() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		FilterCustomerList.menuCustSelect();
		FilterCustomerList.custSelect();
		FilterCustomerList.sendinputCust("manipal 1233423");
		FilterOrderDetails.filterClick();
		FilterCustomerList.filterByCustomerName();
		driver.findElement(By.id("input-name")).clear();
		FilterCustomerList.sendinputEmail("kuhu123@gmail.com");
		FilterOrderDetails.filterClick();
		FilterCustomerList.filterByEmailId();
		screenShot.captureScreenShot("FilterCustomerList-ScreenShot");
				
		}
	
}


