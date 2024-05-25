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
import Interfaces.InterfaceProductDetail;
import Interfaces.InterfaceSearch;

public class Search {
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
		CommonFunction.clickItem(driver, InterfaceHome.XPATH_SEARCH_LINK);
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
		InterfaceSearch.searchProduct(driver, "", true);
	}

	@Test
	public void TEST_02() throws Exception {
		InterfaceSearch.searchProduct(driver, "Viên sủi bổ sung vitamin C tăng đề kháng Swiss Energy (Tuýp 20 viên)", true);
	}
	
	@Test
	public void TEST_03() throws Exception {
		InterfaceSearch.searchProduct(driver, "test", false);
	}
	
	@Test
	public void TEST_04() throws Exception {
		InterfaceSearch.searchProduct(driver, "Viên Sủi Bổ Sung vitamin C tăng đề kháng Swiss Energy (Tuýp 20 viên)".toUpperCase(), true);
	}
	
	@Test
	public void TEST_05() throws Exception {
		InterfaceSearch.searchProduct(driver, "          ", true);
	}
	
	@Test
	public void TEST_06() throws Exception {
		InterfaceHome.openHomePage(driver);
		InterfaceProductDetail.openProductDetailPage(driver, "1");
	}
}
