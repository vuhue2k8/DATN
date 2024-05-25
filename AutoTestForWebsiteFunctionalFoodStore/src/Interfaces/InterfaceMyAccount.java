package Interfaces;

import org.openqa.selenium.WebDriver;

import Commons.CommonFunction;

public class InterfaceMyAccount {
	public static String XPATH_NAME_TXT							= "//input[@id='getName']";
	public static String XPATH_BIRTHDAY_TXT						= "//input[@id='birthday']";
	public static String XPATH_GENDER_SELECT					= "//select[@id='gender']";
	public static String XPATH_ADDRESS_TXT						= "//input[@id='getAddress']";
	public static String XPATH_SAVE_BTN							= "//button[@id='btn_save']";

	public static String XPATH_ERROR_MESSAGE					= "//div[@class='alert alert-danger error-mesage']//ul//li";
	public static String XPATH_SUCCESS_MESSAGE					= "//div[@class='alert alert-success success-mesage']//ul//li";
	
	public static String MESSAGE_SUCCESS 						= "Thông tin tài khoản được cập nhật thành công";
	public static String MESSAGE_EMPTY_NAME 					= "Bạn chưa nhập tên";
	public static String MESSAGE_MAX_NAME		 				= "Họ tên vượt quá 50 kí tự";
	public static String MESSAGE_EMPTY_BIRTHDAY					= "Bạn chưa nhập ngày sinh";
	public static String MESSAGE_INVALID_BIRTHDAY				= "Ngày sinh không hợp lệ";
	public static String MESSAGE_EMPTY_ADDRESS 					= "Bạn chưa nhập địa chỉ";
	
	public static void updateAccountInfo(WebDriver driver, String name, String birthday, String gender, String address, String errorMessage) throws Exception {
		CommonFunction.sendKeys(driver, XPATH_NAME_TXT, name);
		CommonFunction.inputDate(driver, birthday);
		if (gender != "Nữ") {
			CommonFunction.selectListBox(driver, XPATH_GENDER_SELECT, gender);
		}
		CommonFunction.sendKeys(driver, XPATH_ADDRESS_TXT, address);
		CommonFunction.clickItem(driver, XPATH_SAVE_BTN);
		
		if (errorMessage == "") {
			CommonFunction.assertTextValue(driver, XPATH_SUCCESS_MESSAGE, MESSAGE_SUCCESS);
		}
		else {
			CommonFunction.assertTextValue(driver, XPATH_ERROR_MESSAGE, errorMessage);
		}
	}
}