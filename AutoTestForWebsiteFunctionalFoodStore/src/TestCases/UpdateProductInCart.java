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

public class UpdateProductInCart {
	private static WebDriver driver;
	private String folder = this.getClass().getName();;
	private String testcase;
	@Rule public TestName name = new TestName();
	
	@BeforeClass
	public static void setUpClass() throws Exception {
		driver = CommonFunction.initWebDriver(Constant.URL_TEST);
		// Thêm sản phẩm vào giỏ hàng
		InterfaceHome.openProductDetailPage(driver, "1");
		InterfaceProductDetail.addToCart(driver, null, true);
		InterfaceProductDetail.openCartManagementPage(driver);
	}
	
	@After
	public void tearDown() throws Exception {
		testcase = name.getMethodName();
		CommonFunction.captureScreen(driver, folder, testcase);
		CommonFunction.refreshScreen(driver);
	}
	
	@AfterClass
	public static void tearDownForClass() throws Exception {
		CommonFunction.shutDownDriver(driver);
	}
	
	@Test
	public void TEST_14() throws Exception {
		InterfaceCartManagement.updateProduct(driver, "1", true);
	}

	@Test
	public void TEST_15() throws Exception {
		InterfaceCartManagement.updateProduct(driver, "1", false);
	}
}