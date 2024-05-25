package Interfaces;

import org.openqa.selenium.WebDriver;

import Commons.CommonFunction;

public class InterfaceOrderManagement {
	public static String XPATH_ORDER_LINK			= "//body/div[1]/aside[1]/section[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]";
	public static String XPATH_ORDER_TITLE			= "//h3[contains(text(),'Danh sách đơn hàng')]";
	
	public static String XPATH_ORDER_ID				= "//tbody//tr[INDEX]//td//a";
	public static String XPATH_DETAIL_ORDER_TITLE	= "//h3[contains(text(),'Thông tin đơn hàng')]";
	
	public static String XPATH_PENDING_ORDER_LINK	= "//body/div[1]/aside[1]/section[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]";
	public static String XPATH_APPROVAL_BTN			= "//tbody/tr[INDEX]//td[5]//button[1]";
	
	public static String XPATH_CANCEL_BTN			= "//tbody/tr[INDEX]//td[6]//button[1]";
	public static String XPATH_NOTE_TXT				= "//textarea[@id='getNote']";
	public static String XPATH_SAVE_BTN				= "//button[contains(text(),'Lưu lại')]";
	
	public static String XPATH_SHIPPED_ORDER_LINK	= "//body/div[1]/aside[1]/section[1]/ul[1]/li[2]/ul[1]/li[3]/a[1]";
	public static String XPATH_CONFIRM_BTN			= "//tbody/tr[INDEX]//td[6]//button[1]";
	
	public static String XPATH_MSG 					= "//div[@class='swal-text']";
	
	public static String MSG_SUCCESS				= "Đã cập nhật đơn hàng!";
	public static String MSG_CANCEL_SUCCESS			= "Đơn hàng vừa bị hủy!";
	public static String MSG_EMPTY_NOTE				= "Cần có lý do hủy đơn hàng!";
	
	public static void openOrderManagementPage(WebDriver driver) throws Exception {
		CommonFunction.clickItem(driver, XPATH_ORDER_LINK);
		CommonFunction.assertElementDisplayed(driver, XPATH_ORDER_TITLE);
	}
	
	public static void openDetailOrderPage(WebDriver driver, String index) throws Exception {
		CommonFunction.clickItem(driver, XPATH_ORDER_ID.replace("INDEX", index));
		CommonFunction.assertElementDisplayed(driver, XPATH_DETAIL_ORDER_TITLE);
	}
	
	public static void approvalOrder(WebDriver driver, String index) throws Exception {
		CommonFunction.clickItem(driver, XPATH_PENDING_ORDER_LINK);
		CommonFunction.clickItem(driver, XPATH_APPROVAL_BTN.replace("INDEX", index));
		CommonFunction.assertTextValue(driver, XPATH_MSG, MSG_SUCCESS);
	}
	
	public static void cancelOrder(WebDriver driver, String index, String note) throws Exception {
		CommonFunction.clickItem(driver, XPATH_PENDING_ORDER_LINK);
		CommonFunction.clickItem(driver, XPATH_CANCEL_BTN.replace("INDEX", index));
		driver.switchTo().alert().accept();
		CommonFunction.sendKeys(driver, XPATH_NOTE_TXT, note);
		CommonFunction.clickItem(driver, XPATH_SAVE_BTN);
		if (note != "") {
			CommonFunction.assertTextValue(driver, XPATH_MSG, MSG_CANCEL_SUCCESS);
		}
		else {
			CommonFunction.assertAlertMessage(driver, MSG_EMPTY_NOTE);
		}
	}
	
	public static void confirmOrder(WebDriver driver, String index) throws Exception {
		CommonFunction.clickItem(driver, XPATH_SHIPPED_ORDER_LINK);
		CommonFunction.clickItem(driver, XPATH_CONFIRM_BTN.replace("INDEX", index));
		CommonFunction.assertTextValue(driver, XPATH_MSG, MSG_SUCCESS);
	}
}