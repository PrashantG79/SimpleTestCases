package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FilterReturnList {
private WebDriver driver; 
	
	public FilterReturnList(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
	}

	@FindBy(partialLinkText="Returns")
	private WebElement returnOrd;

	@FindBy(id="input-return-id")
	private WebElement returnId; 


	public void returnSelect() {
		this.returnOrd.click();
	}

	public void sendReturnId(String returnId) {
		this.returnId.clear();
		this.returnId.sendKeys(returnId);
	}


	public void tryAndCheck() {
		try {
		String expectedReturnID="198";
		String actualReturnID=driver.findElement(By.xpath("//td[contains(text(),'198')]")).getText();
		Assert.assertEquals(actualReturnID, expectedReturnID);
		System.out.println("Given Return ID and Order details are matching");
		}
		catch (NoSuchElementException e) {
			System.out.println("Given Return ID and Order details are not matching");
		}
		finally {
			this.returnId.clear();
		}
	}



	public void returnListFilterByCustName () {
	
		
	String before="//div[@id='container']//tbody//tr[";
	String after ="]/td[4]";
		
	String custName ="Prashant G";
	int count = driver.findElements(By.xpath("//div[@id='container']//tbody//tr")).size();
	System.out.println(count);
	
//	String name = driver.findElement(By.xpath("//div[@id='container']//tbody//tr[1]//td[4]")).getText();
//	System.out.println(name);
	
	int i=1;
	for(i=1;i<=count;i++) {
		String customerName=driver.findElement(By.xpath("//div[@id='container']//tbody//tr[1]//td[4]")).getText();
		//String customerName=driver.findElement(By.xpath("before + i + after")).getText();
		System.out.println(customerName);
		
		if(customerName.equalsIgnoreCase(custName)) {
			System.out.println("List is matching with the given Customer Name " +customerName);
		}else {
			System.out.println("List is not matching with the given Customer Name");
		}
	
	}	
	
}



}
