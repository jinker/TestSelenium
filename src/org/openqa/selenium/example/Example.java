package org.openqa.selenium.example;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;

public class Example {
    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver(true);

        Selenium selenium = new WebDriverBackedSelenium(driver, "http:");

        selenium.open("http://www.google.com");

        selenium.waitForPageToLoad("3000");
        selenium.type("name=q", "Cheers!");
        selenium.click("name=q");
        selenium.waitForPageToLoad("3000");

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Page title is: " + driver.getPageSource());

        // Close the browser
        selenium.close();

        System.exit(-1);
    }
}