package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Processes.Helper;

public class SelectProduct {
	
	public static void selectProduct(WebDriver driver, String productName) {
		WebElement product = driver.findElement(By.linkText(productName));
		product.click();
	}
	
	public static double getUnitaryPrice(WebDriver driver) {
		WebElement priceElement = driver.findElement(By.xpath("//div[@id='bodyContent']/form/div/h1"));
		String price = priceElement.getText();
		return Helper.getPriceAsDouble(price);
	}

}
