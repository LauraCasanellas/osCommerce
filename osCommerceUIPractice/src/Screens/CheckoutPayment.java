package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPayment {
	
	private CheckoutPayment() {
		throw new IllegalStateException("Utility class");
	}

	public static void selectCashOnDeliveryOption(WebDriver driver) {
		WebElement cashOnDelivery = driver.findElement(By.xpath("(//input[@name='payment'])[6]"));
		cashOnDelivery.click();
	}

	public static void continueClickBtn(WebDriver driver) {
		WebElement btn = driver.findElement(By.id("tdb6"));
		btn.click();
	}

	public static void payNowClickBtn(WebDriver driver) {
		WebElement btn = driver.findElement(By.id("tdb5"));
		btn.click();
	}

	public static String getSucessMsg(WebDriver driver) {
		WebElement msgField = driver.findElement(By.xpath("//div[@id='bodyContent']/h1"));
		return msgField.getText();
	}

}