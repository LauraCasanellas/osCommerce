package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Processes.Helper;

public class ShoppingCart {

	public static void clickAddToCartBtn(WebDriver driver) {
		WebElement btn = driver.findElement(By.id("tdb4"));
		btn.click();
	}

	public static void updatePriceClickBtn(WebDriver driver) {
		WebElement btn = driver.findElement(By.xpath("//button[@id='tdb4']/span[2]"));
		btn.click();
	}

	public static double getTotalPrice(WebDriver driver) {
		String totalPrice = driver.findElement(By.xpath("//div[@id='bodyContent']/form/div/div/table/tbody/tr/td[2]/strong")).
				getText();
		return Helper.getPriceAsDouble(totalPrice);
	}

	public static int getItemsForProduct(WebDriver driver) {
		String items = driver.findElement(By.xpath("//div[@id='columnRight']/div/table")).getText();
		Integer.parseInt(items.substring(0, 1));
		return Integer.parseInt(items.substring(0, 1));
	}

	public static void setQuantityField(WebDriver driver, String quantity) {
		WebElement quantityField = driver.findElement(By.cssSelector("input[name='cart_quantity[]']"));
		quantityField.clear();
		quantityField.sendKeys(quantity);
	}
	
	public static void clickCheckoutBtn(WebDriver driver) {
		WebElement btn = driver.findElement(By.id("tdb5"));
		btn.click();
	}


}