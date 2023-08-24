package com.about_orangeHRM_project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdminQualifications_Education {
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties properties;
	@BeforeTest
	public void setUp() {
		properties = new Properties();
		String configFilePath = "E:\\priyanka\\e\\02.07.2023\\about_orangeHRM_project\\src\\test\\java\\adminQualifications_Education.properties";
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
	public void qualificationsDropdowm() {

		String admin = properties.getProperty("admin");
		String qualifications = properties.getProperty("qualifications");
		String education = properties.getProperty("education");


		driver.findElement(By.xpath(admin)).click();
		driver.findElement(By.xpath(qualifications)).click();
		driver.findElement(By.xpath(education)).click();

	}
	@Test(priority=3)
	public void addEducation() {


		String add = properties.getProperty("add");
		String level = properties.getProperty("level");
		String educationName = properties.getProperty("educationName");
		String save = properties.getProperty("save");

		driver.findElement(By.xpath(add)).click();
		driver.findElement(By.xpath(level)).sendKeys(educationName);
		driver.findElement(By.xpath(save)).click();
	}
	@Test(priority=4)
	public void deleteEducation() {

		String delete = properties.getProperty("delete");
		String deleteYes = properties.getProperty("deleteYes");

		driver.findElement(By.xpath(delete)).click();
		driver.findElement(By.xpath(deleteYes)).click();
	}	
	
}
