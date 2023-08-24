package com.about_orangeHRM_project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class AdminAddSystemUser {
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties properties;
	@BeforeTest
	public void setUp() {
		properties = new Properties();
		String configFilePath = "E:\\priyanka\\e\\02.07.2023\\about_orangeHRM_project\\src\\test\\java\\adminAddSystemUser.properties";
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
	public void addUser() {

		String admin = properties.getProperty("admin");
		String add = properties.getProperty("add");


		driver.findElement(By.xpath(admin)).click();
		driver.findElement(By.xpath(add)).click();
	} 

	@Test(priority=3)
	public void userRole() {

		String userRoleAdd = properties.getProperty("userRoleAdd");
		String userRoleSelect = properties.getProperty("userRoleSelect");
		String role = properties.getProperty("role");



		driver.findElement(By.xpath(userRoleAdd)).click();
		java.util.List<WebElement> list = driver.findElements(By.xpath(userRoleSelect));
		Iterator<WebElement> iterator = list.iterator();
		while (iterator.hasNext()) {
			WebElement webElement = (WebElement) iterator.next();
			System.out.println(webElement.getText());
			if(webElement.getText().equals(role)) {
				webElement.click();
			}	
		}
	}	


	@Test(priority=5)
	public void employeeName() {
		String name = properties.getProperty("name");
		String nameOfEmployee = properties.getProperty("nameOfEmployee");

		driver.findElement(By.xpath(name)).sendKeys(nameOfEmployee); 
	}
	@Test(priority=4)
	public void statusOption() {

		String status = properties.getProperty("status");
		String statusSelect = properties.getProperty("statusSelect");
		String statusOption = properties.getProperty("statusOption");
		String loginButton = properties.getProperty("loginButton");

		driver.findElement(By.xpath(status)).click();
		java.util.List<WebElement> list1 = driver.findElements(By.xpath(statusSelect));
		Iterator<WebElement> iterator1 = list1.iterator();
		while (iterator1.hasNext()) {
			WebElement webElement1 = (WebElement) iterator1.next();
			System.out.println(webElement1.getText());
			if(webElement1.getText().equals(statusOption)) {
				webElement1.click();
			}
		}	
	}
	@Test(priority=6)
	public void userNameBox() {

		String userName = properties.getProperty("userName");
		String nameOfUser = properties.getProperty("nameOfUser");
		String userPassword= properties.getProperty("userPassword");
		String passwordValue = properties.getProperty("passwordValue");
		String passwordConfirm = properties.getProperty("passwordConfirm");
		String save = properties.getProperty("save");
		String passwordField = properties.getProperty("passwordField");
		String loginButton = properties.getProperty("loginButton");


		driver.findElement(By.xpath(userName)).sendKeys(nameOfUser);
		driver.findElement(By.xpath(userPassword)).sendKeys(passwordValue);
		driver.findElement(By.xpath(passwordConfirm)).sendKeys(passwordValue);
		driver.findElement(By.xpath(save)).click();
	}
	@AfterMethod
	private void closeApp() {
		driver.close();
	}

}


