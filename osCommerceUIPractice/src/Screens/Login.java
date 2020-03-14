package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	
	private Login() {
		throw new IllegalStateException("Utility class");
	}
	
	public static void writeCredentials(WebDriver driver, String emailAdress, String pw) {
		
		WebElement emailField = driver.findElement(By.cssSelector("input[name='email_address']"));
		emailField.sendKeys(emailAdress);
		WebElement pwField = driver.findElement(By.cssSelector("input[name='password']"));
		pwField.sendKeys(pw);
	}
	
	public static void signInClickBtn(WebDriver driver) {
		WebElement btn = driver.findElement(By.id("tdb1"));
		btn.click();
	}
	
	public static void continueClickBtn(WebDriver driver) {
		WebElement btn = driver.findElement(By.id("tdb6"));
		btn.click();
	}


}
