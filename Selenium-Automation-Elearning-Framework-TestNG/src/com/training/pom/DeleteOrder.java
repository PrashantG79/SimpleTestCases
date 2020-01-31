package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DeleteOrder {
	
private WebDriver driver ;
	
public DeleteOrder(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@id='button-delete']")
	private WebElement delbutton;
	
	public void OrderDel () {
		
		try {
		String id = driver.findElement(By.xpath("//td[contains(text(),'208')]")).getText();
		System.out.println(id);
		driver.findElement(By.xpath("//tr[3]//td[1]//input[1]")).click();
		} catch (Exception e) {
			System.out.println("Order Id is not available so can not Select it for Deletion");
			System.exit(1);
			
		} 
			
	}
	
	public void OrderDelButton() {
		this.delbutton.click();
		Alert simpleAlert=driver.switchTo().alert();
		String alertText =simpleAlert.getText();
		System.out.println("Alert Text is..."+alertText);
		simpleAlert.accept();
	}

}
