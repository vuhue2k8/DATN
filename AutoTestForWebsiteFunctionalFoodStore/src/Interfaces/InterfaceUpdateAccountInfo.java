package Interfaces;

import org.openqa.selenium.WebDriver;

import Commons.CommonFunction;

public class InterfaceUpdateAccountInfo {
	public static String XPATH_NAME_TXT							= "//input[@id='name']";
	public static String XPATH_BIRTHDAY_TXT						= "//input[@id='birthday']";
	public static String XPATH_GENDER_SELECT					= "//select[@id='gender']";
	public static String XPATH_ADDRESS_TXT						= "//input[@id='address']";
	public static String XPATH_PASSWORD_TXT						= "//input[@id='password']";
	public static String XPATH_RE_PASSWORD_TXT					= "//input[@id='re_password']";
	public static String XPATH_SAVE_BTN							= "//button[@id='btn_save']";

	public static String XPATH_ERROR_MESSAGE					= "//div[@class='error-mesage']//ul//li";
	public static String XPATH_SUCCESS_MESSAGE					= "//div[@class='success-mesage']//ul//li";
	public static String XPATH_UNSUCCESS_MESSAGE				= "//div[@class='unsuccess-mesage']//ul//li";
	
	public static String MESSAGE_UPDATE_ACCOUNT_INFO_SUCCESS 	= "Thông tin tài khoản được cập nhật thành công";
	public static String MESSAGE_EMPTY_NAME 					= "Bạn chưa nhập tên";
	public static String MESSAGE_MAX_NAME		 				= "Họ tên vượt quá 50 kí tự";
	public static String MESSAGE_EMPTY_BIRTHDAY					= "Bạn chưa nhập thông tin ngày sinh";
	public static String MESSAGE_INVALID_BIRTHDAY				= "Ngày sinh không hợp lệ";
	public static String MESSAGE_EMPTY_ADDRESS 					= "Bạn chưa nhập địa chỉ";
	public static String MESSAGE_EMPTY_PASSWORD 				= "Bạn chưa nhập mật khẩu";
	public static String MESSAGE_INCORRECT_FORMAT_PASSWORD		= "Mật khẩu không đúng định dạng";
	public static String MESSAGE_MIN_PASSWORD					= "Mật khẩu cần ít nhất 8 kí tự";
	public static String MESSAGE_MAX_PASSWORD					= "Mật khẩu tối đa 16 kí tự";
	public static String MESSAGE_EMPTY_RE_PASSWORD 				= "Bạn chưa nhập lại mật khẩu";
	public static String MESSAGE_INCORRECT_FORMAT_RE_PASSWORD	= "Mật khẩu nhập lại không đúng định dạng";
	public static String MESSAGE_MIN_RE_PASSWORD				= "Mật khẩu nhập lại cần ít nhất 8 kí tự";
	public static String MESSAGE_MAX_RE_PASSWORD				= "Mật khẩu nhập lại tối đa 16 kí tự";
	public static String MESSAGE_UNMATCHING_PASSWORD			= "Mật khẩu không khớp";
	
	public static void updateAccountInfo(WebDriver driver, String name, String birthday, String gender, String address, String password, String rePassword, String errorMessage) throws Exception {
		CommonFunction.sendKeys(driver, XPATH_NAME_TXT, name);
		CommonFunction.inputDate(driver, birthday);
		if (gender != "Nữ") {
			CommonFunction.selectListBox(driver, XPATH_GENDER_SELECT, gender);
		}
		CommonFunction.sendKeys(driver, XPATH_ADDRESS_TXT, address);
		CommonFunction.sendKeys(driver, XPATH_PASSWORD_TXT, password);
		CommonFunction.sendKeys(driver, XPATH_RE_PASSWORD_TXT, rePassword);
		CommonFunction.clickItem(driver, XPATH_SAVE_BTN);
		
		if (errorMessage == "") {
			CommonFunction.assertTextValue(driver, XPATH_SUCCESS_MESSAGE, MESSAGE_UPDATE_ACCOUNT_INFO_SUCCESS);
		}
		else if (errorMessage == MESSAGE_UNMATCHING_PASSWORD) {
			CommonFunction.assertTextValue(driver, XPATH_UNSUCCESS_MESSAGE, errorMessage);
		}
		else {
			CommonFunction.assertTextValue(driver, XPATH_ERROR_MESSAGE, errorMessage);
		}
	}
}