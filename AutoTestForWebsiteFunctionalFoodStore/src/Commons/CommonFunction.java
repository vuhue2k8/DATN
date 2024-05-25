package Commons;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunction {
	private static WebDriver driver = null;

	public static WebDriver initWebDriver(String url) {
		System.setProperty(Constant.DRIVER_KEY, Constant.DRIVER_KEY_LOCATION);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--lang=vi");
		driver = new ChromeDriver(options);// khởi tạo browser cho biến driver
		driver.manage().window().maximize(); // Để tối đa hóa cửa sổ hiện tại của trình duyệt
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// đặt thời gian ngầm định
		driver.get(url);// mở url
		return driver;
	}

	public static void shutDownDriver(WebDriver driver) throws InterruptedException {
		driver.close();
		TimeUnit.SECONDS.sleep(3);
	}

	public static void clickItem(WebDriver driver, String elementXpath) throws Exception {
		WebElement element = driver.findElement(By.xpath(elementXpath));//xác định duy nhất một phần tử xpath trong trang web.
		try {
			element.click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;// tạo một tham chiếu cho giao diện và gán nó cho cá thể WebDriver
		     executor.executeScript("arguments[0].click();", element);//click vào phần tử element
		  }
		TimeUnit.SECONDS.sleep(1);
	}
	
	public static void clickItem1(WebDriver driver, String elementXpath) throws Exception {
		WebElement element = driver.findElement(By.xpath(elementXpath));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", element);
		TimeUnit.SECONDS.sleep(1);
	}

	public static WebElement getWebElementByXpath(WebDriver driver, String xPath) {
		return driver.findElement(By.xpath(xPath));
	}

	public static void clearText(WebElement element) {
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.DELETE);
	}

	public static void sendKeys(WebDriver driver, String elementXpath, String inputData) {
		WebElement element = driver.findElement(By.xpath(elementXpath));
		element.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		if (!inputData.isEmpty()) {
			element.sendKeys(inputData);
		}
	}
	
	public static void sendKeys1(WebDriver driver, String elementXpath, String inputData) throws InterruptedException {
		WebElement element = driver.findElement(By.xpath(elementXpath));
		element.clear();
		TimeUnit.SECONDS.sleep(1);
		if (!inputData.isEmpty()) {
			element.sendKeys(inputData);
		}
	}
	
	public static void pressKeys(WebDriver driver, String elementXpath, Keys inputKeys) {
		WebElement element = driver.findElement(By.xpath(elementXpath));
		element.sendKeys(inputKeys);
	}
	
	public static void selectListBox(WebDriver driver, String elementXpath, String selectedItem) throws InterruptedException {
		if (selectedItem != null) {
			WebElement listbox = driver.findElement(By.xpath(elementXpath));
			// Select item
			Select select = new Select(listbox);
			select.selectByVisibleText(selectedItem);
			TimeUnit.SECONDS.sleep(3);
		}
	}
		
	public static void assertTextValue(WebDriver driver, String elementXpath, String expectedText) {
		WebElement element = driver.findElement(By.xpath(elementXpath));
		String actualText = element.getText();
		assertEquals(expectedText, actualText);
	}
	
	public static void assertContainTextValue(WebDriver driver, String elementXpath, String expectErrMsg) {
		WebElement element = driver.findElement(By.xpath(elementXpath));
		String textValue = element.getText();
		assertTrue(textValue.contains(expectErrMsg));
	}
	
	public static void assertElementDisplayed(WebDriver driver, String elementXpath) {
		WebElement element = driver.findElement(By.xpath(elementXpath));
		assertTrue(element.isDisplayed(), element.toString() + " is not displayed");	
	}
	
	public static void assertElementNotDisplayed(WebDriver driver, String elementXpath) {
		WebElement element = driver.findElement(By.xpath(elementXpath));
		assertFalse(element.isDisplayed(), element.toString() + " is displayed");	
	}

	public static boolean isElementDisplayed(WebDriver driver, String elementXpath) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
		return element.isDisplayed();	
	}
	
	public static String getHTML5ValidationMessage(String elementXpath) {
		WebElement element = driver.findElement(By.xpath(elementXpath));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
	}
	
	public static void inputDate(WebDriver driver, String date) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("document.getElementById('birthday').value='" + date + "'");
	}
	
	public static void refreshScreen(WebDriver driver) throws InterruptedException {
		driver.get(driver.getCurrentUrl());
		TimeUnit.SECONDS.sleep(5);
	}
	
	public static void captureScreen(WebDriver driver, String folderName, String testcase) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String folderPath = "./result/" + folderName + "/";
		String filePath = folderPath + testcase + ".jpg";
		File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
		Files.copy(scrFile.toPath(), new File(filePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
	}
	
	public static void assertElementDisabled(WebDriver driver, String elementXpath) {
		WebElement element = driver.findElement(By.xpath(elementXpath));
		assertEquals(false, element.isEnabled());
	}
	
	public static int getXpathCount(WebDriver driver, String elementXpath) {
		List<WebElement> listElements = driver.findElements(By.xpath(elementXpath));
		int count = 0;
		for (WebElement element : listElements) {
			count++;
		}
		return count;
	}
	
	public static String getAlertMessage(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	public static void assertAlertMessage(WebDriver driver, String expectedText) {
		String actualText = getAlertMessage(driver);
		driver.switchTo().alert().accept();
		assertEquals(expectedText, actualText);
	}
}
