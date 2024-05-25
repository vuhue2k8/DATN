package Interfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.openqa.selenium.WebDriver;
import Commons.CommonFunction;

public class InterfaceSearch {
	public static String XPATH_SEARCH_TXT 				= "//input[@id='search']";
	public static String XPATH_SEARCH_BTN 				= "(//button[@id='btn-search'])[2]";
	
	public static String XPATH_SEARCH_PRODUCT_LINK		= "//a[@id='link-result-search-product']";

	public static void searchProduct(WebDriver driver, String keyword, boolean isSuccess) throws Exception {
		CommonFunction.sendKeys(driver, XPATH_SEARCH_TXT, keyword);
		CommonFunction.clickItem(driver, XPATH_SEARCH_BTN);
		int resultSearch = CommonFunction.getXpathCount(driver, XPATH_SEARCH_PRODUCT_LINK);
		
		if (isSuccess) {
			assertNotEquals(0, resultSearch);
		}
		else {
			assertEquals(0, resultSearch);
		}
	}
}