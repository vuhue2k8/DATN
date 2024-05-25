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

public class Login {
	private static WebDriver driver;
	private String folder = this.getClass().getName();;
	private String testcase;
	@Rule public TestName name = new TestName();
	
	@Before
	public void setUp() throws Exception {
		driver = CommonFunction.initWebDriver(Constant.URL_TEST);
		InterfaceHome.openLoginPage(driver);
	}
			
	@After
	public void tearDown() throws Exception {
		testcase = name.getMethodName();
		CommonFunction.captureScreen(driver, folder, testcase);
		CommonFunction.shutDownDriver(driver);
	}
	
	@Test
	public void TEST_01() throws Exception {
		 InterfaceLogin.login(driver, Constant.PHONE_NUMBER, Constant.PASSWORD, "");
	}

	@Test
	public void TEST_02() throws Exception {
		 InterfaceLogin.login(driver, "", Constant.PASSWORD, InterfaceLogin.MESSAGE_EMPTY_PHONE);
	}
	
	@Test
	public void TEST_03() throws Exception {
		 InterfaceLogin.login(driver, "0963852741", Constant.PASSWORD, InterfaceLogin.MESSAGE_LOGIN_FAIL);
	}
	
	@Test
	public void TEST_04() throws Exception {
		 InterfaceLogin.login(driver, "096385274a", Constant.PASSWORD, InterfaceLogin.MESSAGE_INVALID_PHONE);
	}
	
	@Test
	public void TEST_05() throws Exception {
		 InterfaceLogin.login(driver, "096385274@", Constant.PASSWORD, InterfaceLogin.MESSAGE_INVALID_PHONE);
	}
	
	@Test
	public void TEST_06() throws Exception {
		 InterfaceLogin.login(driver, "0963 852 741", Constant.PASSWORD, InterfaceLogin.MESSAGE_INVALID_PHONE);
	}
	
	@Test
	public void TEST_07() throws Exception {
		 InterfaceLogin.login(driver, "096385274", Constant.PASSWORD, InterfaceLogin.MESSAGE_INVALID_PHONE);
	}
	
	@Test
	public void TEST_08() throws Exception {
		 InterfaceLogin.login(driver, "1234567890", Constant.PASSWORD, InterfaceLogin.MESSAGE_INVALID_PHONE);
	}
	
	@Test
	public void TEST_09() throws Exception {
		 InterfaceLogin.login(driver, "09876543211", Constant.PASSWORD, InterfaceLogin.MESSAGE_INVALID_PHONE);
	}
	
	@Test
	public void TEST_10() throws Exception {
		 InterfaceLogin.login(driver, Constant.PHONE_NUMBER, "", InterfaceLogin.MESSAGE_EMPTY_PASSWORD);
	}
	
	@Test
	public void TEST_11() throws Exception {
		 InterfaceLogin.login(driver, Constant.PHONE_NUMBER, "Test1234@", InterfaceLogin.MESSAGE_INCORRECT_FORMAT_PASSWORD);
	}
	
	@Test
	public void TEST_12() throws Exception {
		 InterfaceLogin.login(driver, Constant.PHONE_NUMBER, "Test 1234", InterfaceLogin.MESSAGE_INCORRECT_FORMAT_PASSWORD);
	}
	
	@Test
	public void TEST_13() throws Exception {
		 InterfaceLogin.login(driver, Constant.PHONE_NUMBER, "Test123", InterfaceLogin.MESSAGE_MIN_PASSWORD);
	}
	
	@Test
	public void TEST_14() throws Exception {
		 InterfaceLogin.login(driver, Constant.PHONE_NUMBER, Constant.PASSWORD, "");
	}
	
	@Test
	public void TEST_15() throws Exception {
		 InterfaceLogin.login(driver, Constant.PHONE_NUMBER2, Constant.PASSWORD2, "");
	}
	
	@Test
	public void TEST_16() throws Exception {
		 InterfaceLogin.login(driver, Constant.PHONE_NUMBER2, "Test1234Test12345", InterfaceLogin.MESSAGE_MAX_PASSWORD);
	}
	
	@Test
	public void TEST_17() throws Exception {
		 InterfaceLogin.login(driver, Constant.PHONE_NUMBER, "Test1235", InterfaceLogin.MESSAGE_LOGIN_FAIL);
	}
}
