package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilterCustomerList {
	private WebDriver driver; 
	public FilterCustomerList(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@id='menu-customer']//a[@class='parent']")
	private WebElement menuCust; 
	
	@FindBy(partialLinkText="Customers")
	private WebElement cust;
	
	@FindBy(id="input-name")
	private WebElement inputCustomer; 
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement inputEmail; 
	
	
	public void menuCustSelect() {
		this.menuCust.click();
	}
	
	public void custSelect() {
		this.cust.click();
	}
	
	public void sendinputCust(String inputCustomer) {
		this.inputCustomer.clear();
		this.inputCustomer.sendKeys(inputCustomer);
	}
	
	public void sendinputEmail(String inputEmail) {
		this.inputEmail.clear();
		this.inputEmail.sendKeys(inputEmail);
	}
	
	public void filterByCustomerName () {
		
		//String before="//div[@id='container']//tbody/tr[";
		//String after ="]/td[2]";
		String customerName = "";		
		String custName ="manipal 1233423";
		int count = driver.findElements(By.xpath("//div[@id='container']//tbody/tr")).size();
		System.out.println(count);
		
		int i=1;
		for(i=1;i<=count;i++) {
			customerName=driver.findElement(By.xpath("//div[@id='container']//tbody/tr[1]/td[2]")).getText();
			//String customerName=driver.findElement(By.xpath("before + i + after")).getText();
			//System.out.println(customerName);
		}
			if(customerName.equalsIgnoreCase(custName)) {
				System.out.println("List is matching with the given Customer Name " +customerName);
			}else {
				System.out.println("List is not matching with the given Customer Name");
			}
	}
	
	public void filterByEmailId () {
			
		//String before="//div[@id='container']//tbody/tr[";
		//String after ="]/td[3]";
		String emailID = "";		
		String email ="kuhu123@gmail.com";
		int count = driver.findElements(By.xpath("//div[@id='container']//tbody/tr")).size();
		System.out.println(count);
		
		int i=1;
		for(i=1;i<=count;i++) {
			emailID=driver.findElement(By.xpath("//div[@id='container']//tbody/tr[1]/td[3]")).getText();
			//String customerName=driver.findElement(By.xpath("before + i + after")).getText();
			System.out.println(emailID);
		}
			if(emailID.equalsIgnoreCase(email)) {
				System.out.println("List is matching with the given Email ID " +emailID);
			}else {
				System.out.println("List is not matching with the given Email ID");
			}
	}
	
	
	
	
}
