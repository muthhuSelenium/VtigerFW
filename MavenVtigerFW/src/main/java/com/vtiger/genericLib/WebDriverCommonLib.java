package com.vtiger.genericLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLib {
	public void waitForVisibilityOfElement(By element)
	{
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	public void acceptAlert()
	{
		BaseClass.driver.switchTo().alert().accept();
	}
	public void moveMousePointer(WebElement element)
	{
		Actions act = new Actions(BaseClass.driver);
		act.moveToElement(element).perform();
	}
	public void selectItemFromList(WebElement list , String itemName)
	{
		Select s = new Select(list);
		s.selectByVisibleText(itemName);
	}
}
