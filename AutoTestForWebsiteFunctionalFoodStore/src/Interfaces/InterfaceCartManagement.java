package Interfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import Commons.CommonFunction;

public class InterfaceCartManagement {
	public static String XPATH_CHECKOUT_BTN					= "//button[@id='btn_checkout']";
	
	public static final String RECORD_PRODUCTS_XPATH		= "//table[@id='shopping-cart-table']//tbody//tr";
	public static final String REMOVE_BTN_XPATH				= "(//*[@class='btn-remove btn-remove2 remove-cart'])[INDEX]";
	public static final String INCREASE_BTN_XPATH			= "(//*[@class='increase btn-increment'])[INDEX]";
	public static final String DECREASE_BTN_XPATH			= "(//*[@class='decrease btn-decrement'])[INDEX]";
	
	public static final String CART_EMPTY_MSG_XPATH			= "//p[contains(text(),'Giỏ hàng của bạn đang trống. Mời bạn tiếp tục mua ')]";
	
	public static void openOrderPage(WebDriver driver) throws Exception {
		CommonFunction.clickItem1(driver, XPATH_CHECKOUT_BTN);
	}
	
	public static void updateProduct(WebDriver driver, String index, boolean isIncrease) throws Exception {
		if (isIncrease) {
			CommonFunction.clickItem(driver,INCREASE_BTN_XPATH.replace("INDEX", index));
		}
		else {
			CommonFunction.clickItem(driver, DECREASE_BTN_XPATH.replace("INDEX", index));
		}
	}
	
	public static void removeProduct(WebDriver driver, String index) throws Exception {
		int recordBefore = CommonFunction.getXpathCount(driver, RECORD_PRODUCTS_XPATH);
		CommonFunction.clickItem(driver, REMOVE_BTN_XPATH.replace("INDEX", index));
		TimeUnit.SECONDS.sleep(1);
		if (index == "1") {
			CommonFunction.assertElementDisplayed(driver, CART_EMPTY_MSG_XPATH);
		}
		else {
			int recordAfter = CommonFunction.getXpathCount(driver, RECORD_PRODUCTS_XPATH);
			assertEquals(recordBefore - 1, recordAfter);
		}
	}
}