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
import Interfaces.InterfaceLoginAdmin;
import Interfaces.InterfaceOrderManagement;

public class OrderManagement {
	private static WebDriver driver;
	private String folder = this.getClass().getName();;
	private String testcase;
	@Rule public TestName name = new TestName();
	
	@BeforeClass
	public static void setUpForClass() throws Exception {
		driver = CommonFunction.initWebDriver(Constant.URL_ADMIN_TEST);
		InterfaceLoginAdmin.login(driver, Constant.EMAIL_ADMIN, Constant.PASSWORD_ADMIN);
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
	public void TEST_01() throws Exception {
		InterfaceOrderManagement.openOrderManagementPage(driver);
	}
	
	@Test
	public void TEST_02() throws Exception {
		InterfaceOrderManagement.openDetailOrderPage(driver, "1");
	}
	
	@Test
	public void TEST_03() throws Exception {
		InterfaceOrderManagement.approvalOrder(driver, "1");
	}
	
	@Test
	public void TEST_04() throws Exception {
		InterfaceOrderManagement.cancelOrder(driver, "1", "note");
	}
	
	@Test
	public void TEST_05() throws Exception {
		InterfaceOrderManagement.cancelOrder(driver, "1", "");
	}
	
	@Test
	public void TEST_06() throws Exception {
		InterfaceOrderManagement.confirmOrder(driver, "1");
	}
}
