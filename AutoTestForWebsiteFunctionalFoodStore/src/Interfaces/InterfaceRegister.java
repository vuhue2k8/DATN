package Interfaces;

import org.openqa.selenium.WebDriver;

import Commons.CommonFunction;

public class InterfaceRegister {
	public static String XPATH_PHONE_TXT						= "//input[@id='phone_number']";
	public static String XPATH_REGISTER_BTN						= "//button[@id='btn_register']";
	
	public static String XPATH_ERROR_MESSAGE					= "//div[@class='error-mesage']//ul//li";
	public static String XPATH_UNSUCCESS_MESSAGE				= "//div[@class='unsuccess-mesage']//ul//li";
	
	public static String MESSAGE_EMPTY_PHONE 					= "Bạn chưa nhập số điện thoại";
	public static String MESSAGE_REGISTERED_PHONE				= "Số điện thoại này đã đăng kí.";
	public static String MESSAGE_INVALID_PHONE					= "Số điện thoại này không hợp lệ";
	
	public static void registerAccount(WebDriver driver, String phone, String errorMessage) throws Exception {
		CommonFunction.sendKeys(driver, XPATH_PHONE_TXT, phone);
		CommonFunction.clickItem(driver, XPATH_REGISTER_BTN);
		
		if (phone == "") {
			CommonFunction.assertTextValue(driver, XPATH_ERROR_MESSAGE, errorMessage);
		}
		else if (errorMessage == "") {
			CommonFunction.assertElementDisplayed(driver, InterfaceUpdateAccountInfo.XPATH_SAVE_BTN);
		}
		else {
			CommonFunction.assertTextValue(driver, XPATH_UNSUCCESS_MESSAGE, errorMessage);
		}
	}
	
	
}