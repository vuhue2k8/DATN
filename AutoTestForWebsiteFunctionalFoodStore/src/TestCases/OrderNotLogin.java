package TestCases;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;

import Commons.CommonFunction;
import Commons.Constant;
import Interfaces.InterfaceCartManagement;
import Interfaces.InterfaceHome;
import Interfaces.InterfaceProductDetail;

public class OrderNotLogin {
	private static WebDriver driver;
	private String folder = this.getClass().getName();;
	private String testcase;
	@Rule public TestName name = new TestName();
	
	@BeforeClass
	public static void setUpForClass() throws Exception {
		driver = CommonFunction.initWebDriver(Constant.URL_TEST);
	}
					
	@After
	public void tearDown() throws Exception {
		testcase = name.getMethodName();
		CommonFunction.captureScreen(driver, folder, testcase);
	}
	
	@AfterClass
	public static void tearDownForClass() throws Exception {
		CommonFunction.shutDownDriver(driver);
	}

	@Test
	public void TEST_01_0() throws Exception {
		CommonFunction.clickItem(driver, InterfaceHome.XPATH_PRODUCT_LINK.replace("INDEX", "1"));
		CommonFunction.clickItem(driver, InterfaceProductDetail.XPATH_ADD_TO_CART_BTN);
		CommonFunction.clickItem(driver, InterfaceProductDetail.XPATH_ORDER_NOW_BTN);
		CommonFunction.clickItem1(driver, InterfaceCartManagement.XPATH_CHECKOUT_BTN);
		CommonFunction.assertTextValue(driver, "//div[@class='swal-text']", "Vui lòng đăng nhập để mua hàng");
	}
}
