package com.example.tests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class MyTest {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "http://888.qq.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.cssSelector("body")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'¾º²Ê×ãÇò')])[2]")).click();
		driver.findElement(By.id("gd_sp_1_21305336")).click();
		driver.findElement(By.id("gd_sp_1_21305337")).click();
		driver.findElement(By.id("ck_gg2_1")).click();
		driver.findElement(By.linkText("Ã÷Ï¸")).click();
	}

	@After
	public void tearDown() throws Exception {
//		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
