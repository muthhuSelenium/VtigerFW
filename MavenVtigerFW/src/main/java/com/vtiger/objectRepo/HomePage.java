package com.vtiger.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	@FindBy(linkText = "More")
	private WebElement moredd;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaginLink;

	@FindBy(xpath = "//span[text()=' Administrator']/../following-sibling::td")
	private WebElement logoutBtn;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;

	public WebElement getMoredd() {
		return moredd;
	}

	public WebElement getCampaginLink() {
		return campaginLink;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
}
