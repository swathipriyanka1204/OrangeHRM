package com.about_orangeHRM_project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdminUserManagement {
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties properties;
	@BeforeTest
	public void setUp() {
		properties = new Properties();
		String configFilePath = "E:\\priyanka\\e\\02.07.2023\\about_orangeHRM_project\\src\\test\\java\\com\\about_orangeHRM_project\\adminUserManagement.properties";
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
	public void userName() {

		String admin = properties.getProperty("admin");
		String systemUserName = properties.getProperty("systemUserName");
		String user = properties.getProperty("user");

		driver.findElement(By.xpath(admin)).click();
		driver.findElement(By.xpath(systemUserName)).sendKeys(user);
	}
	@Test(priority=3)
	public void userRole() {
		try {

			String role = properties.getProperty("role");
			String roleAdmin = properties.getProperty("roleAdmin");


			driver.findElement(By.xpath(role)).click();
			Thread.sleep(4000);
			java.util.List<WebElement> list = driver.findElements(By.xpath(roleAdmin));
			Iterator<WebElement> iterator = list.iterator();
			while (iterator.hasNext()) {
				WebElement webElement = (WebElement) iterator.next();
				System.out.println(webElement.getText());
				if(webElement.getText().equals("Admin")) {
					webElement.click();
				}}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	@Test(priority=4)
	public void employeeName() {

		String systemEmployeeName = properties.getProperty("systemEmployeeName");
		String employee = properties.getProperty("employee");

		driver.findElement(By.xpath(systemEmployeeName)).sendKeys(employee);
	}	
	@Test(priority=5)
	public void status() {
		try {

			String statusSelect = properties.getProperty("statusSelect");
			String statusEnabled= properties.getProperty("statusEnabled");
			String statusOption= properties.getProperty("statusOption");
			String searchButton = properties.getProperty("searchButton");

			driver.findElement(By.xpath(statusSelect)).click();
			Thread.sleep(4000);
			java.util.List<WebElement> list1 = driver.findElements(By.xpath(statusEnabled));
			driver.findElement(By.xpath(searchButton)).click();
			Iterator<WebElement> iterator1 = list1.iterator();
			while (iterator1.hasNext()) {
				WebElement webElement1 = (WebElement) iterator1.next();
				System.out.println(webElement1.getText());
				if(webElement1.getText().equals(statusOption)) {
					webElement1.click();
				}}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

	@AfterMethod
	private void closeApp() {
		driver.close();
	}
}

