package Interfaces;

import org.openqa.selenium.WebDriver;

import Commons.CommonFunction;

public class InterfaceProductDetail {
	public static String XPATH_QUANTITY_TXT				= "//input[@id='qty']";
	public static String XPATH_DECREASE_BTN				= "//button[@class='decrease']";
	public static String XPATH_INCREASE_BTN				= "//button[@class='increase']";
	public static String XPATH_ADD_TO_CART_BTN			= "//button[@id='product-addtocart-button']";
	
	public static String XPATH_MESSAGE					= "//div[@class='swal-text']";
	public static String XPATH_CONTINUE_SHOPPING_BTN	= "//*[@class='swal-button swal-button--cancel']";
	public static String XPATH_ORDER_NOW_BTN			= "//button[contains(text(),'Gửi đơn hàng ngay!')]";
	
	public static String MESSAGE_SUCCESS				= "Sản phẩm của bạn đã được thêm vào giỏ hàng";
	public static String MESSAGE_UNSUCCESS				= "Số lượng sản phẩm không hợp lệ";
	
	public static void openProductDetailPage(WebDriver driver, String index) throws Exception {
		InterfaceHome.openProductDetailPage(driver, index);
		CommonFunction.assertElementDisplayed(driver, XPATH_ADD_TO_CART_BTN);
	}
	
	public static void addToCart(WebDriver driver, String quantity, boolean isSuccess) throws Exception {
		if (quantity != null) {
			CommonFunction.sendKeys(driver, XPATH_QUANTITY_TXT, quantity);
		}
		CommonFunction.clickItem(driver, XPATH_ADD_TO_CART_BTN);
		
		if (isSuccess) {
			CommonFunction.assertTextValue(driver, XPATH_MESSAGE, MESSAGE_SUCCESS);
		}
		else {
			CommonFunction.assertTextValue(driver, XPATH_MESSAGE, MESSAGE_UNSUCCESS);
		}
	}
	
	public static void closeDialog(WebDriver driver) throws Exception {
		CommonFunction.clickItem(driver, XPATH_CONTINUE_SHOPPING_BTN);
	}
	
	public static void addToCartWithIncreaseBtn(WebDriver driver) throws Exception {
		CommonFunction.clickItem(driver, XPATH_INCREASE_BTN);
		CommonFunction.clickItem(driver, XPATH_ADD_TO_CART_BTN);
		CommonFunction.assertTextValue(driver, XPATH_MESSAGE, MESSAGE_SUCCESS);
	}
	
	public static void addToCartWithDecreaseBtn(WebDriver driver) throws Exception {
		CommonFunction.clickItem(driver, XPATH_INCREASE_BTN);
		CommonFunction.clickItem(driver, XPATH_DECREASE_BTN);
		CommonFunction.clickItem(driver, XPATH_ADD_TO_CART_BTN);
		CommonFunction.assertTextValue(driver, XPATH_MESSAGE, MESSAGE_SUCCESS);
	}
	
	public static void openCartManagementPage(WebDriver driver) throws Exception {
		CommonFunction.clickItem(driver, XPATH_ORDER_NOW_BTN);
	}
}