package com.vtiger.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewCampPage {
	@FindBy(name = "campaignname")
	private WebElement campaignNameTxtBox;
	
	@FindBy(xpath = "//input[@value='  Save  ']")
	private WebElement saveBtn;

	public WebElement getCampaignNameTxtBox() {
		return campaignNameTxtBox;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
}
