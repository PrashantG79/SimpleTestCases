package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteReturnOrder {
	private WebDriver driver ;
	
	public DeleteReturnOrder(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//button[@class='btn btn-danger']")
		private WebElement delReturnOrdButton;
		
		@FindBy(partialLinkText="Returns")
		private WebElement returnOrdSel;

		public void returnOrdSelect() {
			this.returnOrdSel.click();
		}
		
		public void ReturnOrderDel () {
			
			try {
			String id = driver.findElement(By.xpath("//td[contains(text(),'197')]")).getText();
			System.out.println(id);
			driver.findElement(By.xpath("//tr[2]/td[1]/input[1]")).click();
			} catch (Exception e) {
				System.out.println("Return Order Id is not available so can not Select it for Deletion");
				System.exit(1);
			} 
				
		}
		
		public void ReturnOrderDelButton() {
			this.delReturnOrdButton.click();
			Alert simpleAlert=driver.switchTo().alert();
			String alertText =simpleAlert.getText();
			System.out.println("Alert Text is..."+alertText);
			simpleAlert.accept();
			System.out.println("Return Order is Deleted");
		}

	}
