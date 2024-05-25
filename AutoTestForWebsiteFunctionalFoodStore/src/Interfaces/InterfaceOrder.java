package Interfaces;

import org.openqa.selenium.WebDriver;

import Commons.CommonFunction;

public class InterfaceOrder {
	public static String XPATH_ADDRESS_TXT			= "//textarea[@id='getAddress']";
	public static String XPATH_NOTE_TXT				= "//textarea[@id='getNote']";
	public static String XPATH_CHECKOUT_BTN			= "//button[@id='btn_checkout']";
	
	public static String XPATH_MESSAGE				= "//div[@class='alert']";

	public static String MESSAGE_SUCCESS 			= "Đơn hàng của bạn đã được tiếp nhận";
	public static String MESSAGE_EMPTY_ADDRESS 		= "Bạn chưa nhập địa chỉ";
	
	public static void openOrderPage(WebDriver driver, String index) throws Exception {
		InterfaceHome.openHomePage(driver);
		InterfaceHome.openProductDetailPage(driver, index);
		InterfaceProductDetail.addToCart(driver, null, true);
		InterfaceProductDetail.openCartManagementPage(driver);
		InterfaceCartManagement.openOrderPage(driver);
	}
	
	public static void order(WebDriver driver, String address, String note, String errorMessage) throws Exception {
		CommonFunction.sendKeys(driver, XPATH_ADDRESS_TXT, address);
		CommonFunction.sendKeys(driver, XPATH_NOTE_TXT, note);
		CommonFunction.clickItem(driver, XPATH_CHECKOUT_BTN);
		
		if (errorMessage == "") {
			CommonFunction.assertTextValue(driver, XPATH_MESSAGE, MESSAGE_SUCCESS);
		}
		else {
			CommonFunction.assertTextValue(driver, XPATH_MESSAGE, errorMessage);
		}
	}
}