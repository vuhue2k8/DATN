package Interfaces;

import org.openqa.selenium.WebDriver;

import Commons.CommonFunction;

public class InterfaceTransactionHistory {
	public static String XPATH_TRANSACTION_HISTORY_TBL			= "//table[@id='tbl_orders']";
	public static String XPATH_ORDER_ID							= "//tbody//tr[INDEX]//td//a";
	public static String XPATH_DETAIL_TRANSACTION_HISTORY_TBL 	= "//table[@class='data-table']";
	
	public static void openTransactionHistoryPage(WebDriver driver) throws Exception {
		InterfaceHome.openTransactionHistoryPage(driver);
		CommonFunction.assertElementDisplayed(driver, XPATH_TRANSACTION_HISTORY_TBL);
	}
	
	public static void openDetailTransactionHistoryPage(WebDriver driver, String index) throws Exception {
		CommonFunction.clickItem(driver, XPATH_ORDER_ID.replace("INDEX", index));
		CommonFunction.assertElementDisplayed(driver, XPATH_DETAIL_TRANSACTION_HISTORY_TBL);
	}
}
