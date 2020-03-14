package com.vtiger.testScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vtiger.genericLib.BaseClass;
import com.vtiger.objectRepo.CampInfoPage;
import com.vtiger.objectRepo.CampginPage;
import com.vtiger.objectRepo.CreateNewCampPage;
import com.vtiger.objectRepo.HomePage;

public class CreateCampTest extends BaseClass{
	@Test
	public void createCampgin() throws EncryptedDocumentException, IOException
	{
		HomePage hp = PageFactory.initElements
									(driver, HomePage.class);
		CampginPage cp = PageFactory.initElements
									(driver, CampginPage.class);
		CreateNewCampPage cncp = PageFactory.initElements
								(driver, CreateNewCampPage.class);
		CampInfoPage cip = PageFactory.initElements
									(driver, CampInfoPage.class);
		
		wlib.moveMousePointer(hp.getMoredd());
		hp.getCampaginLink().click();
		cp.getCreateCampImg().click();
		
		cncp.getCampaignNameTxtBox().sendKeys(data.fetchDataFromExcel
															("Sheet1", 1, 0));
		cncp.getSaveBtn().click();
		String actMsg = cip.getSuccessMsg().getText();
		String expMsg = data.fetchDataFromExcel("Sheet1", 1, 1);
		boolean flag = actMsg.contains(expMsg);
		Assert.assertTrue(flag);
		Reporter.log("Campagin Create Successfully" , true);
		
		
	}
}
