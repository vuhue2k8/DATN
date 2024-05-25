package Interfaces;

import org.openqa.selenium.WebDriver;
import Commons.CommonFunction;

public class InterfaceLoginAdmin {
	public static String XPATH_EMAIL_TXT 					= "//input[@id='email']";
	public static String XPATH_PASSWORD_TXT 				= "//input[@id='password']";
	
	public static String XPATH_LOGIN_BTN 					= "//button[contains(text(),'Đăng nhập')]";
		
	public static void login(WebDriver driver, String email, String password) throws Exception {
		CommonFunction.sendKeys(driver, XPATH_EMAIL_TXT, email);
		CommonFunction.sendKeys(driver, XPATH_PASSWORD_TXT, password);
		CommonFunction.clickItem(driver, XPATH_LOGIN_BTN);
	}
}
