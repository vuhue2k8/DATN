package Interfaces;

import org.openqa.selenium.WebDriver;

import Commons.CommonFunction;

public class InterfaceHome {
	public static String XPATH_HOME_LINK 				= "//a[@id='link-home']";
	public static String XPATH_LOGIN_LINK 				= "//a[@id='link-login']";
	public static String XPATH_REGISTER_LINK 			= "//a[@id='link-register']";
	public static String XPATH_CONTACT_LINK				= "//a[@id='link-contact']";
	
	public static String XPATH_SEARCH_LINK				= "//a[@id='link-search']";
	
	public static String XPATH_USERNAME_LABEL			= "//a[@id='username']";
	public static String XPATH_MY_ACCOUNT_LINK			= "//a[@id='link-my-account']";
	public static String XPATH_TRANSACTION_HISTORY_LINK	= "//a[@id='link-transaction-history']";
	public static String XPATH_LOGOUT_LINK				= "//a[@id='link-logout']";
		
	public static String XPATH_PRODUCT_LINK				= "((//div[@class='item last'])[INDEX]//div//div//div//a)[2]";
	
	public static String XPATH_CART_LINK				= "//a[@class='em-amount-js-topcart em-amount-topcart']";
		
	public static void openHomePage(WebDriver driver) throws Exception {
		CommonFunction.clickItem(driver, XPATH_HOME_LINK);
	}
	
	public static void openCartPage(WebDriver driver) throws Exception {
		CommonFunction.clickItem(driver, XPATH_CART_LINK);
	}
	
	public static void openRegisterPage(WebDriver driver) throws Exception {
		CommonFunction.clickItem(driver, XPATH_REGISTER_LINK);
	}
	
	public static void openLoginPage(WebDriver driver) throws Exception {
		CommonFunction.clickItem(driver, XPATH_LOGIN_LINK);
	}
	
	public static void openProductDetailPage(WebDriver driver, String index) throws Exception {
		CommonFunction.clickItem(driver, XPATH_PRODUCT_LINK.replace("INDEX", index));
	}
	
	public static void openMyAccountPage(WebDriver driver) throws Exception {
		CommonFunction.clickItem(driver, XPATH_USERNAME_LABEL);
		CommonFunction.clickItem(driver, XPATH_MY_ACCOUNT_LINK);
	}
	
	public static void openTransactionHistoryPage(WebDriver driver) throws Exception {
		CommonFunction.clickItem(driver, XPATH_USERNAME_LABEL);
		CommonFunction.clickItem(driver, XPATH_TRANSACTION_HISTORY_LINK);
	}

	public static void logout(WebDriver driver) throws Exception {
		CommonFunction.clickItem(driver, XPATH_USERNAME_LABEL);
		CommonFunction.clickItem(driver, XPATH_LOGOUT_LINK);
		CommonFunction.assertElementDisplayed(driver, XPATH_LOGIN_LINK);
	}
	
	public static void openContactPage(WebDriver driver) throws Exception {
		CommonFunction.clickItem(driver, XPATH_CONTACT_LINK);
	}
}