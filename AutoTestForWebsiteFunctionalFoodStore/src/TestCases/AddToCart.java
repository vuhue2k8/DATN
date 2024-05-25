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
import Interfaces.InterfaceHome;
import Interfaces.InterfaceProductDetail;

public class AddToCart {
	private static WebDriver driver;
	private String folder = this.getClass().getName();;
	private String testcase;
	@Rule public TestName name = new TestName();
	
	@BeforeClass
	public static void setUpForClass() throws Exception {
		driver = CommonFunction.initWebDriver(Constant.URL_TEST);
		InterfaceHome.openProductDetailPage(driver, "1");
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
	public void TEST_01() throws Exception {
		 InterfaceProductDetail.addToCart(driver, null, true);
	}
	
	@Test
	public void TEST_02() throws Exception {
		 InterfaceProductDetail.addToCart(driver, "3", true);
	}
	
	@Test
	public void TEST_03() throws Exception {
		 InterfaceProductDetail.addToCart(driver, "A", false);
	}
	
	@Test
	public void TEST_04() throws Exception {
		 InterfaceProductDetail.addToCart(driver, "@", false);
	}
	
	@Test
	public void TEST_05() throws Exception {
		 InterfaceProductDetail.addToCart(driver, "1 2", false);
	}
	
	@Test
	public void TEST_06() throws Exception {
		 InterfaceProductDetail.addToCart(driver, "", false);
	}
	
	@Test
	public void TEST_07() throws Exception {
		 InterfaceProductDetail.addToCart(driver, "      ", false);
	}
	
	@Test
	public void TEST_08() throws Exception {
		 InterfaceProductDetail.addToCart(driver, "-1", false);
	}
	
	@Test
	public void TEST_09() throws Exception {
		 InterfaceProductDetail.addToCart(driver, "0", false);
	}
	
	@Test
	public void TEST_10() throws Exception {
		 InterfaceProductDetail.addToCart(driver, "+1", true);
	}
	
	@Test
	public void TEST_11() throws Exception {
		 InterfaceProductDetail.addToCart(driver, "1.5", false);
	}
	
	@Test
	public void TEST_12() throws Exception {
		 InterfaceProductDetail.addToCartWithIncreaseBtn(driver);
	}
	
	@Test
	public void TEST_13() throws Exception {
		 InterfaceProductDetail.addToCartWithDecreaseBtn(driver);
	}
}
