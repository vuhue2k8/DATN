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
import Interfaces.InterfaceContact;
import Interfaces.InterfaceHome;

public class SendContact {
	private static WebDriver driver;
	private String folder = this.getClass().getName();;
	private String testcase;
	@Rule public TestName name = new TestName();
	
	@BeforeClass
	public static void setUpForClass() throws Exception {
		driver = CommonFunction.initWebDriver(Constant.URL_TEST);
	}
		
	@Before
	public void setUp() throws Exception {
		InterfaceHome.openContactPage(driver);
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
		InterfaceContact.sendContact(driver, "test", "test@gmail.com", "test", "");
	}

	@Test
	public void TEST_02() throws Exception {
		InterfaceContact.sendContact(driver, "", "test@gmail.com", "test", InterfaceContact.MESSAGE_EMPTY_NAME);
	}
	
	@Test
	public void TEST_02_1() throws Exception {
		InterfaceContact.sendContact(driver, "         ", "test@gmail.com", "test", InterfaceContact.MESSAGE_EMPTY_NAME);
	}
	
	@Test
	public void TEST_02_2() throws Exception {
		InterfaceContact.sendContact(driver, "test@123", "test@gmail.com", "test", "");
	}
	
	@Test
	public void TEST_03() throws Exception {
		InterfaceContact.sendContact(driver, "test test test test test test test test test test", "test@gmail.com", "test", "");
	}
	
	@Test
	public void TEST_04() throws Exception {
		InterfaceContact.sendContact(driver, "test test test test test test test test test test ", "test@gmail.com", "test", "");
	}
	
	@Test
	public void TEST_05() throws Exception {
		InterfaceContact.sendContact(driver, "test test test test test test test test test test t", "test@gmail.com", "test", InterfaceContact.MESSAGE_MAX_NAME);
	}
	
	@Test
	public void TEST_06() throws Exception {
		InterfaceContact.sendContact(driver, "test", "", "test", InterfaceContact.MESSAGE_EMPTY_EMAIL);
	}
	
	@Test
	public void TEST_07() throws Exception {
		InterfaceContact.sendContact(driver, "test", "testgmail.com", "test", InterfaceContact.MESSAGE_INVALID_EMAIL);
	}
	
	@Test
	public void TEST_07_1() throws Exception {
		InterfaceContact.sendContact(driver, "test", "         ", "test", InterfaceContact.MESSAGE_EMPTY_EMAIL);
	}
	
	@Test
	public void TEST_07_2() throws Exception {
		InterfaceContact.sendContact(driver, "test", " test@gmail.com ", "test", "");
	}
	
	@Test
	public void TEST_07_3() throws Exception {
		InterfaceContact.sendContact(driver, "test", "test test@gmail.com", "test", InterfaceContact.MESSAGE_INVALID_EMAIL);
	}
	
	@Test
	public void TEST_07_4() throws Exception {
		InterfaceContact.sendContact(driver, "test", "testgmail.com", "test", InterfaceContact.MESSAGE_INVALID_EMAIL);
	}
	
	@Test
	public void TEST_07_5() throws Exception {
		InterfaceContact.sendContact(driver, "test", "test@gmailcom", "test", InterfaceContact.MESSAGE_INVALID_EMAIL);
	}
	
	@Test
	public void TEST_07_6() throws Exception {
		InterfaceContact.sendContact(driver, "test", "test@gmail.", "test", InterfaceContact.MESSAGE_INVALID_EMAIL);
	}
	
	@Test
	public void TEST_08() throws Exception {
		InterfaceContact.sendContact(driver, "test", "test@gmail.com", "", InterfaceContact.MESSAGE_EMPTY_CONTENT);
	}
	
	@Test
	public void TEST_09() throws Exception {
		InterfaceContact.sendContact(driver, "test", "test@gmail.com", "test", "");
	}
	
	@Test
	public void TEST_10() throws Exception {
		InterfaceContact.sendContact(driver, "test", "test@gmail.com", "test\ntest", "");
	}
}
