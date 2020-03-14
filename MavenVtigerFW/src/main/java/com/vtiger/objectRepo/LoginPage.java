package com.vtiger.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	@FindBy(name = "user_name")
	private WebElement un;
	
	@FindBy(name = "user_password")
	private WebElement pwd;
	
	@FindBy(id = "submitButton")
	private WebElement loginbtn;
	
	@FindBy(xpath = "//div[contains(text(),'valid username and password.')]")
	private WebElement errorMsg;
	
	
	public WebElement getUn() {
		return un;
	}

	public WebElement getErrorMsg() {
		return errorMsg;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
}
