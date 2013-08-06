package com.example.tests;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.join;

public class TestJczq {
    private Selenium selenium;

    @Before
    public void setUp() throws Exception {
        WebDriver driver = new ChromeDriver();
        String baseUrl = "http://888.qq.com/";
        selenium = new WebDriverBackedSelenium(driver, baseUrl);
    }

    @Test
    public void testJczq() throws Exception {
        selenium.open("/");
        selenium.waitForPageToLoad("5000");
        selenium.click("//li[4]/a/h2");

        selenium.selectWindow("Ê¤Æ½¸º - ¾º²Ê×ãÇò - QQ²ÊÆ±");
        selenium.windowMaximize();

        isElementPresentAndWait("//table[@id='game-list']/tbody[3]/tr/td[8]");
        selenium.click("//table[@id='game-list']/tbody[3]/tr[1]/td[8]");

        isElementPresentAndWait("//table[@id='game-list']/tbody[3]/tr[2]/td[9]");
        selenium.click("//table[@id='game-list']/tbody[3]/tr[2]/td[9]");

        isElementPresentAndWait("//ul[@id='ul_pass_type']/li[2]/label");
        selenium.click("//ul[@id='ul_pass_type']/li[2]/label");

        selenium.click("id=a_buy_now");

        this.isElementPresentAndWait("id=box_iframe");
        selenium.selectFrame("box_iframe");
        this.isElementPresentAndWait("id=login_frame");
        selenium.selectFrame("login_frame");
        this.isElementPresentAndWait("id=xui");
        selenium.selectFrame("xui");
        this.isElementPresentAndWait("id=loginbtn");
        selenium.click("id=loginbtn");

        selenium.waitForPageToLoad("3000");
        selenium.click("id=back_change_zg");
    }

    private void isElementPresentAndWait(String locator) throws InterruptedException {
        for (int second = 0; ; second++) {
            if (second >= 60) break;
            try {
                if (selenium.isElementPresent(locator)) break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
    }

    @After
    public void tearDown() throws Exception {
//        selenium.stop();
    }
}
