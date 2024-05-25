package TestCases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
import Interfaces.InterfaceMyAccount;

public class UpdateAccountInfo {
	private static WebDriver driver;
	private String folder = this.getClass().getName();;
	private String testcase;
	@Rule public TestName name = new TestName();
	// Get current time
	private static LocalDateTime currentDateTime = LocalDateTime.now();
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@BeforeClass
	public static void setUpForClass() throws Exception {
		driver = CommonFunction.initWebDriver(Constant.URL_TEST);
		InterfaceHome.openLoginPage(driver);
		InterfaceLogin.login(driver, Constant.PHONE_NUMBER, Constant.PASSWORD, "");
		InterfaceHome.openMyAccountPage(driver);
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
		InterfaceMyAccount.updateAccountInfo(driver, "test", "01/01/2000", "Nam", "HN", "");
	}
	
	@Test
	public void TEST_02() throws Exception {
		InterfaceMyAccount.updateAccountInfo(driver, "", "01/01/2000", "Nam", "HN", InterfaceMyAccount.MESSAGE_EMPTY_NAME);
	}
	
	@Test
	public void TEST_02_1() throws Exception {
		InterfaceMyAccount.updateAccountInfo(driver, "         ", "01/01/2000", "Nam", "HN", InterfaceMyAccount.MESSAGE_EMPTY_NAME);
	}
	
	@Test
	public void TEST_02_2() throws Exception {
		InterfaceMyAccount.updateAccountInfo(driver, "test@123", "01/01/2000", "Nam", "HN", "");
	}
	
	@Test
	public void TEST_03() throws Exception {
		InterfaceMyAccount.updateAccountInfo(driver, "test test test test test test test test test test", "01/01/2000", "Nam", "HN", "");
	}
	
	@Test
	public void TEST_04() throws Exception {
		InterfaceMyAccount.updateAccountInfo(driver, "test test test test test test test test test test ", "01/01/2000", "Nam", "HN", "");
	}
	
	@Test
	public void TEST_05() throws Exception {
		InterfaceMyAccount.updateAccountInfo(driver, "test test test test test test test test test test tt", "01/01/2000", "Nam", "HN", InterfaceMyAccount.MESSAGE_MAX_NAME);
	}
	
	@Test
	public void TEST_06() throws Exception {
		InterfaceMyAccount.updateAccountInfo(driver, "test", "", "Nam", "HN", InterfaceMyAccount.MESSAGE_EMPTY_BIRTHDAY);
	}
	
	@Test
	public void TEST_07() throws Exception {
		InterfaceMyAccount.updateAccountInfo(driver, "test", "01a/01b/2000c", "Nam", "HN", "");
	}
	
	@Test
	public void TEST_08() throws Exception {
		InterfaceMyAccount.updateAccountInfo(driver, "test", "01@/01#/2000$", "Nam", "HN", "");
	}
	
	@Test
	public void TEST_09() throws Exception {
		LocalDateTime beforeCurrentDate = currentDateTime.minusDays(1);
		InterfaceMyAccount.updateAccountInfo(driver, "test", beforeCurrentDate.format(formatter), "Nam", "HN", "");
	}
	
	@Test
	public void TEST_10() throws Exception {
		InterfaceMyAccount.updateAccountInfo(driver, "test", currentDateTime.format(formatter), "Nam", "HN", "");
	}
	
	@Test
	public void TEST_11() throws Exception {
		LocalDateTime afterCurrentDate = currentDateTime.plusDays(1);
		InterfaceMyAccount.updateAccountInfo(driver, "test", afterCurrentDate.format(formatter), "Nam", "HN", InterfaceMyAccount.MESSAGE_INVALID_BIRTHDAY);
	}
	
	@Test
	public void TEST_12() throws Exception {
		InterfaceMyAccount.updateAccountInfo(driver, "test", "01/01/2000", "Nam", "HN", "");
	}
	
	@Test
	public void TEST_13() throws Exception {
		InterfaceMyAccount.updateAccountInfo(driver, "test", "01/01/2000", "Nam", "", InterfaceMyAccount.MESSAGE_EMPTY_ADDRESS);
	}
	
	@Test
	public void TEST_13_1() throws Exception {
		InterfaceMyAccount.updateAccountInfo(driver, "test", "01/01/2000", "Nam", "         ", InterfaceMyAccount.MESSAGE_EMPTY_ADDRESS);
	}
}
