package Interfaces;

import org.openqa.selenium.WebDriver;

import Commons.CommonFunction;

public class InterfaceContact {
	public static String XPATH_NAME_TXT							= "//input[@id='name']";
	public static String XPATH_EMAIL_TXT						= "//input[@id='email']";
	public static String XPATH_CONTENT_TXT						= "//textarea[@id='content']";
	public static String XPATH_CONTACT_BTN						= "//button[@id='btn_contact']";
	
	public static String XPATH_ERROR_MESSAGE					= "//div[@class='error-message-contact']//ul//li";
	public static String XPATH_SUCCESS_MESSAGE					= "//div[@class='alert success-message-contact']//ul//li";
	
	public static String MESSAGE_SUCCESS						= "Cám ơn bạn đã liên hệ với chúng tôi. Chúc bạn sức khỏe và thành công";
	public static String MESSAGE_EMPTY_NAME 					= "Bạn chưa nhập tên";
	public static String MESSAGE_MAX_NAME		 				= "Họ tên vượt quá 50 kí tự";
	public static String MESSAGE_EMPTY_EMAIL					= "Bạn chưa nhập email";
	public static String MESSAGE_INVALID_EMAIL					= "Email không đúng định dạng";
	public static String MESSAGE_EMPTY_CONTENT					= "Bạn chưa nhập nội dung";
	
	public static void sendContact(WebDriver driver, String name, String email, String content, String errorMessage) throws Exception {
		CommonFunction.sendKeys(driver, XPATH_NAME_TXT, name);
		CommonFunction.sendKeys(driver, XPATH_EMAIL_TXT, email);
		CommonFunction.sendKeys(driver, XPATH_CONTENT_TXT, content);
		CommonFunction.clickItem(driver, XPATH_CONTACT_BTN);
		
		if (errorMessage == "") {
			CommonFunction.assertTextValue(driver, XPATH_SUCCESS_MESSAGE, MESSAGE_SUCCESS);
		}
		else {
			CommonFunction.assertTextValue(driver, XPATH_ERROR_MESSAGE, errorMessage);
		}
	}
}