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
import Interfaces.InterfaceLogin;
import Interfaces.InterfaceTransactionHistory;

public class ViewTransactionHistory {
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
		 InterfaceTransactionHistory.openTransactionHistoryPage(driver);
	}
	
	@Test
	public void TEST_02() throws Exception {
		 InterfaceTransactionHistory.openDetailTransactionHistoryPage(driver, "1");
	}
}
