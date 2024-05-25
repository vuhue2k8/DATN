package TestCases;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;

import Commons.CommonFunction;
import Commons.Constant;
import Interfaces.InterfaceHome;
import Interfaces.InterfaceLogin;
import Interfaces.InterfaceOrder;

public class Order {
	private static WebDriver driver;
	private String folder = this.getClass().getName();;
	private String testcase;
	@Rule public TestName name = new TestName();
	
	@BeforeClass
	public static void setUpForClass() throws Exception {
		driver = CommonFunction.initWebDriver(Constant.URL_TEST);
		InterfaceHome.openLoginPage(driver);
		InterfaceLogin.login(driver, Constant.PHONE_NUMBER, Constant.PASSWORD, "");
	}
				
	@Before
	public void setUp() throws Exception {
		InterfaceOrder.openOrderPage(driver, "1");
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
		InterfaceOrder.order(driver, "test", "test", "");
	}
	
	@Test
	public void TEST_02() throws Exception {
		InterfaceOrder.order(driver, "", "test", InterfaceOrder.MESSAGE_EMPTY_ADDRESS);
	}
	
	@Test
	public void TEST_02_1() throws Exception {
		InterfaceOrder.order(driver, "         ", "test", InterfaceOrder.MESSAGE_EMPTY_ADDRESS);
	}
	
	@Test
	public void TEST_03() throws Exception {
		InterfaceOrder.order(driver, "test", "", "");
	}
	
	@Test
	public void TEST_03_1() throws Exception {
		InterfaceOrder.order(driver, "test", "         ", "");
	}
	
	@Test
	public void TEST_04() throws Exception {
		InterfaceOrder.order(driver, "test", "test", "");
	}
	
	@Test
	public void TEST_05() throws Exception {
		InterfaceOrder.order(driver, "test", "test\ntest", "");
	}
}
