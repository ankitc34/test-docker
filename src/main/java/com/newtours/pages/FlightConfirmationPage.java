package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmationPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//font[contains(text(),'Confirmation')]")
	private WebElement FlightConfirmationHeader;
	
	@FindBy(xpath = "(//font[contains(text(),'USD')])[2]")
	private WebElement price;
	
	@FindBy(linkText = "SIGN-OFF")
	private WebElement signOffLink;
	
	public FlightConfirmationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
		
	}
	
	public String getPrice() {
		this.wait.until(ExpectedConditions.visibilityOf(this.FlightConfirmationHeader));
		System.out.println(this.FlightConfirmationHeader.getText());
		System.out.println(this.price.getText());
		String price = this.price.getText();
		this.signOffLink.click();
		return price;
	}
	
	
}
