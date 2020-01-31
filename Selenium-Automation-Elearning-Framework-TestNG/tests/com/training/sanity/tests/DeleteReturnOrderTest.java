package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.FilterOrderDetails;
import com.training.pom.FilterReturnList;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class DeleteReturnOrderTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private FilterOrderDetails FilterOrderDetails;
	private com.training.pom.DeleteOrder DeleteOrder;
	private com.training.pom.DeleteReturnOrder DeleteReturnOrder;
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
		DeleteOrder = new com.training.pom.DeleteOrder(driver);
		DeleteReturnOrder = new com.training.pom.DeleteReturnOrder(driver);
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
	public void DelReturnOrder() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		FilterOrderDetails.cartSelect();
		FilterOrderDetails.viewDisplayedOnCartSelect();
		DeleteReturnOrder.returnOrdSelect();
		DeleteReturnOrder.ReturnOrderDel();
		Thread.sleep(3000);
		DeleteReturnOrder.ReturnOrderDelButton();
		screenShot.captureScreenShot("DeleteReturnOrder-ScreenShot");
				
		}

}


