package Interfaces;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import Commons.CommonFunction;

public class InterfaceLogin {
	public static String XPATH_PHONE_TXT 					= "//input[@id='phone']";
	public static String XPATH_PASSWORD_TXT 				= "//input[@id='password']";
	
	public static String XPATH_LOGIN_BTN 					= "//button[@id='btn_login']";
	
	public static String XPATH_ERROR_MSG					= "//div[@class='alert alert-warning login-faile-msg']//ul//li";
	public static String XPATH_ERROR_MSG1					= "//div[@class='alert alert-warning user-incorrect-msg']//ul//li";
	
	public static String MESSAGE_EMPTY_PHONE				= "Bạn chưa nhập số điện thoại";
	public static String MESSAGE_INVALID_PHONE				= "Số điện thoại này không hợp lệ";
	public static String MESSAGE_EMPTY_PASSWORD 			= "Bạn chưa nhập mật khẩu";
	public static String MESSAGE_INCORRECT_FORMAT_PASSWORD	= "Mật khẩu không đúng định dạng";
	public static String MESSAGE_MIN_PASSWORD				= "Mật khẩu cần ít nhất 8 kí tự";
	public static String MESSAGE_MAX_PASSWORD				= "Mật khẩu tối đa 16 kí tự";
	public static String MESSAGE_LOGIN_FAIL					= "Thông tin đăng nhập không chính xác";
	
	public static void login(WebDriver driver, String phone, String password, String errorMessage) throws Exception {
		CommonFunction.sendKeys(driver, XPATH_PHONE_TXT, phone);
		CommonFunction.sendKeys(driver, XPATH_PASSWORD_TXT, password);
		CommonFunction.clickItem(driver, XPATH_LOGIN_BTN);
		
		if (phone == "" || password == "") {
			CommonFunction.assertTextValue(driver, XPATH_ERROR_MSG, errorMessage);
		}
		else if (errorMessage == "") {
			CommonFunction.assertElementDisplayed(driver, InterfaceHome.XPATH_USERNAME_LABEL);
		}
		else {
			CommonFunction.assertTextValue(driver, XPATH_ERROR_MSG1, errorMessage);
		}
	}
}