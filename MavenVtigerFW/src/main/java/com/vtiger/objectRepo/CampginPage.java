package com.vtiger.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CampginPage {
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement createCampImg;

	public WebElement getCreateCampImg() {
		return createCampImg;
	}
	
}
