package com.about_orangeHRM_project;

import java.io.FileInputStream;
import org.openqa.selenium.Alert;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdminOrganization {
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties properties;
	@BeforeTest
	public void setUp() {
		properties = new Properties();
		String configFilePath = "E:\\priyanka\\e\\02.07.2023\\about_orangeHRM_project\\src\\test\\java\\adminOrganization.properties";
		FileInputStream fis;
		try {
			fis = new FileInputStream(configFilePath);
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String chromeDriverPath = properties.getProperty("webdriver.chrome.driver");
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority=1)
	public void testLogin() {

		String orangeHRMUrl = properties.getProperty("orangeHRMUrl");
		String usernameField = properties.getProperty("usernameField");
		String passwordField = properties.getProperty("passwordField");
		String loginButton = properties.getProperty("loginButton");
		String username= properties.getProperty("username");
		String password = properties.getProperty("password");

		driver.get(properties.getProperty("orangeHRMUrl"));
		driver.findElement(By.xpath(usernameField)).sendKeys(username);
		driver.findElement(By.xpath(passwordField)).sendKeys(password);
		driver.findElement(By.xpath(loginButton)).click();

	}
	@Test(priority=2)
	public void generalInformation() throws Exception {

		String admin = properties.getProperty("admin");
		String organizationDropdown = properties.getProperty("organizationDropdown");
		String generalInformation = properties.getProperty("generalInformation");
		String edit= properties.getProperty("edit");
		String notes = properties.getProperty("notes");
		String note = properties.getProperty("note");
		String save = properties.getProperty("save");


		driver.findElement(By.xpath(admin)).click();
		driver.findElement(By.xpath(organizationDropdown)).click();
		driver.findElement(By.xpath(generalInformation)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(edit)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(notes)).sendKeys(note);
		Thread.sleep(1000);
		driver.findElement(By.xpath(save)).click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();

		alert.dismiss();
		Thread.sleep(1000);

	}
	@Test(priority=3)
	public void locations() throws Exception {
		try {

			String organizationDropdown = properties.getProperty("organizationDropdown");
			String locations = properties.getProperty("locations");
			String name= properties.getProperty("name");
			String locationName = properties.getProperty("locationName");
			String city = properties.getProperty("city");
			String cityName = properties.getProperty("cityName");
			String country = properties.getProperty("country");
			String countrySelect = properties.getProperty("countrySelect");
			String countryName = properties.getProperty("countryName");
			String search = properties.getProperty("search");

			driver.findElement(By.xpath(organizationDropdown)).click();
			driver.findElement(By.xpath(locations)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(name)).sendKeys(locationName);
			Thread.sleep(1000);
			driver.findElement(By.xpath(city)).sendKeys(cityName);
			Thread.sleep(1000);
			driver.findElement(By.xpath(country)).click();
			Thread.sleep(1000);
			java.util.List<WebElement> list = driver.findElements(By.xpath(countrySelect));
			Thread.sleep(1000);
			WebElement button =driver.findElement(By.xpath(search));
			String jsClickScript = "arguments[0].click();";
			((JavascriptExecutor) driver).executeScript(jsClickScript, button);
			Iterator<WebElement> iterator = list.iterator();
			while (iterator.hasNext()) {
				WebElement webElement = (WebElement) iterator.next();
				System.out.println(webElement.getText());
				if(webElement.getText().equals(countryName)) {
					webElement.click();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@AfterMethod
	private void closeApp() {
		driver.close();
	}
}	

