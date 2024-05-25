package TestCases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

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
import Interfaces.InterfaceRegister;
import Interfaces.InterfaceUpdateAccountInfo;

public class Register {
	private static WebDriver driver;
	private String folder = this.getClass().getName();;
	private String testcase;
	@Rule public TestName name = new TestName();
	// Get current time
	private static LocalDateTime currentDateTime = LocalDateTime.now();
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	// Phone number
	private static StringBuilder phoneNumber;
		
	@Before
	public void setUp() throws Exception {
		driver = CommonFunction.initWebDriver(Constant.URL_TEST);
		InterfaceHome.openRegisterPage(driver);
		
        Random random = new Random();
        
        // Tạo ngẫu nhiên một số điện thoại gồm 10 chữ số (không tính mã quốc gia)
        phoneNumber = new StringBuilder("0"); // Mã quốc gia (ở đây là Việt Nam)
        for (int i = 0; i < 9; i++) {
            int randomInt = random.nextInt(10); // Số từ 0 đến 9
            phoneNumber.append(randomInt);
        }
	}
	
	@After
	public void tearDown() throws Exception {
		testcase = name.getMethodName();
		CommonFunction.captureScreen(driver, folder, testcase);
		CommonFunction.shutDownDriver(driver);
	}
	
	@Test
	public void TEST_01() throws Exception {
		InterfaceRegister.registerAccount(driver, "0963852741", "");
	}

	@Test
	public void TEST_02() throws Exception {
		InterfaceRegister.registerAccount(driver, "", InterfaceRegister.MESSAGE_EMPTY_PHONE);
	}
		
	@Test
	public void TEST_03() throws Exception {
		InterfaceRegister.registerAccount(driver, Constant.PHONE_NUMBER, InterfaceRegister.MESSAGE_REGISTERED_PHONE);
	}
	
	@Test
	public void TEST_04() throws Exception {
		InterfaceRegister.registerAccount(driver, "0987654abc", InterfaceRegister.MESSAGE_INVALID_PHONE);
	}
	
	@Test
	public void TEST_05() throws Exception {
		InterfaceRegister.registerAccount(driver, "0987@#$321", InterfaceRegister.MESSAGE_INVALID_PHONE);
	}
	
	@Test
	public void TEST_06() throws Exception {
		InterfaceRegister.registerAccount(driver, " 0987 654 321 ", InterfaceRegister.MESSAGE_INVALID_PHONE);
	}
	
	@Test
	public void TEST_07() throws Exception {
		InterfaceRegister.registerAccount(driver, "098765432", InterfaceRegister.MESSAGE_INVALID_PHONE);
	}
	
	@Test
	public void TEST_08() throws Exception {
		InterfaceRegister.registerAccount(driver, "1472583690", InterfaceRegister.MESSAGE_INVALID_PHONE);
	}
	
	@Test
	public void TEST_09() throws Exception {
		InterfaceRegister.registerAccount(driver, "09876543210", InterfaceRegister.MESSAGE_INVALID_PHONE);
	}
	
	@Test
	public void TEST_10() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test", "01/01/2000", "Nam", "HN", "Test1234", "Test1234", "");
	}
	
	@Test
	public void TEST_11() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "", "01/01/2000", "Nam", "HN", "Test1234", "Test1234", InterfaceUpdateAccountInfo.MESSAGE_EMPTY_NAME);
	}
	
	@Test
	public void TEST_11_1() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "         ", "01/01/2000", "Nam", "HN", "Test1234", "Test1234", InterfaceUpdateAccountInfo.MESSAGE_EMPTY_NAME);
	}
	
	@Test
	public void TEST_11_2() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test@123", "01/01/2000", "Nam", "HN", "Test1234", "Test1234", "");
	}
	
	@Test
	public void TEST_12() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test test test test test test test test test test", "01/01/2000", "Nam", "HN", "Test1234", "Test1234", "");
	}
	
	@Test
	public void TEST_13() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test test test test test test test test test test ", "01/01/2000", "Nam", "HN", "Test1234", "Test1234", "");
	}
	
	@Test
	public void TEST_14() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test test test test test test test test test test tt", "01/01/2000", "Nam", "HN", "Test1234", "Test1234", InterfaceUpdateAccountInfo.MESSAGE_MAX_NAME);
	}
	
	@Test
	public void TEST_15() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test", "", "Nam", "HN", "Test1234", "Test1234", InterfaceUpdateAccountInfo.MESSAGE_EMPTY_BIRTHDAY);
	}
	
	@Test
	public void TEST_16() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test", "01a/01b/2000c", "Nam", "HN", "Test1234", "Test1234", "");
	}
	
	@Test
	public void TEST_17() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test", "01@/01#/2000$", "Nam", "HN", "Test1234", "Test1234", "");
	}
	
	@Test
	public void TEST_18() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		LocalDateTime beforeCurrentDate = currentDateTime.minusDays(1);
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test", beforeCurrentDate.format(formatter), "Nam", "HN", "Test1234", "Test1234", "");
	}
	
	@Test
	public void TEST_19() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test", currentDateTime.format(formatter), "Nam", "HN", "Test1234", "Test1234", "");
	}
	
	@Test
	public void TEST_20() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		LocalDateTime afterCurrentDate = currentDateTime.plusDays(1);
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test", afterCurrentDate.format(formatter), "Nam", "HN", "Test1234", "Test1234", InterfaceUpdateAccountInfo.MESSAGE_INVALID_BIRTHDAY);
	}
	
	@Test
	public void TEST_21() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test", "01/01/2000", "Nam", "HN", "Test1234", "Test1234", "");
	}
	
	@Test
	public void TEST_22() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test", "01/01/2000", "Nam", "", "Test1234", "Test1234", InterfaceUpdateAccountInfo.MESSAGE_EMPTY_ADDRESS);
	}
	
	@Test
	public void TEST_22_1() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test", "01/01/2000", "Nam", "         ", "Test1234", "Test1234", InterfaceUpdateAccountInfo.MESSAGE_EMPTY_ADDRESS);
	}
	
	@Test
	public void TEST_23() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test", "01/01/2000", "Nam", "HN", "", "Test1234", InterfaceUpdateAccountInfo.MESSAGE_EMPTY_PASSWORD);
	}
	
	@Test
	public void TEST_24() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test", "01/01/2000", "Nam", "HN", "Test1234@#$", "Test1234", InterfaceUpdateAccountInfo.MESSAGE_INCORRECT_FORMAT_PASSWORD);
	}
	
	@Test
	public void TEST_25() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test", "01/01/2000", "Nam", "HN", "Test 1234", "Test1234", InterfaceUpdateAccountInfo.MESSAGE_INCORRECT_FORMAT_PASSWORD);
	}
	
	@Test
	public void TEST_26() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test", "01/01/2000", "Nam", "HN", "Test123", "Test1234", InterfaceUpdateAccountInfo.MESSAGE_MIN_PASSWORD);
	}
	
	@Test
	public void TEST_27() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test", "01/01/2000", "Nam", "HN", "Test1234", "Test1234", "");
	}
	
	@Test
	public void TEST_28() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test", "01/01/2000", "Nam", "HN", "Test1234Test1234", "Test1234Test1234", "");
	}
	
	@Test
	public void TEST_29() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test", "01/01/2000", "Nam", "HN", "Test1234Test12341", "Test1234Test1234", InterfaceUpdateAccountInfo.MESSAGE_MAX_PASSWORD);
	}
	
	@Test
	public void TEST_30() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test", "01/01/2000", "Nam", "HN", "Test1234", "", InterfaceUpdateAccountInfo.MESSAGE_EMPTY_RE_PASSWORD);
	}
	
	@Test
	public void TEST_31() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test", "01/01/2000", "Nam", "HN", "Test1234", "Test1234@#$", InterfaceUpdateAccountInfo.MESSAGE_INCORRECT_FORMAT_RE_PASSWORD);
	}
	
	@Test
	public void TEST_32() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test", "01/01/2000", "Nam", "HN", "Test1234", "Test 1234", InterfaceUpdateAccountInfo.MESSAGE_INCORRECT_FORMAT_RE_PASSWORD);
	}
	
	@Test
	public void TEST_33() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test", "01/01/2000", "Nam", "HN", "Test1234", "Test123", InterfaceUpdateAccountInfo.MESSAGE_MIN_RE_PASSWORD);
	}
	
	@Test
	public void TEST_34() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test", "01/01/2000", "Nam", "HN", "Test1234Test1234", "Test1234Test12341", InterfaceUpdateAccountInfo.MESSAGE_MAX_RE_PASSWORD);
	}
	
	@Test
	public void TEST_35() throws Exception {
		InterfaceRegister.registerAccount(driver, phoneNumber.toString(), "");
		InterfaceUpdateAccountInfo.updateAccountInfo(driver, "test", "01/01/2000", "Nam", "HN", "Test1234", "Test1234Test1234", InterfaceUpdateAccountInfo.MESSAGE_UNMATCHING_PASSWORD);
	}
}
