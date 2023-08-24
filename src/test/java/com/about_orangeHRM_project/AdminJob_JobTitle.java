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

public class AdminJob_JobTitle {
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties properties;
	@BeforeTest
	public void setUp() {
		properties = new Properties();
		String configFilePath = "E:\\priyanka\\e\\02.07.2023\\about_orangeHRM_project\\src\\test\\java\\adminJob_JobTitle.properties";
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
	public void jobAdd() {
		String admin = properties.getProperty("admin");
		String jobDropdown = properties.getProperty("jobDropdown");
		String jobTitleDropdown = properties.getProperty("jobTitleDropdown");
		String add = properties.getProperty("add");
		String jobTitle = properties.getProperty("jobTitle");
		String name= properties.getProperty("name");
		String jobDescription = properties.getProperty("jobDescription");
		String description = properties.getProperty("description");
		String addNote= properties.getProperty("addNote");
		String note = properties.getProperty("note");
		String save = properties.getProperty("save");

		driver.findElement(By.xpath(admin)).click();
		driver.findElement(By.xpath(jobDropdown)).click();
		driver.findElement(By.xpath(jobTitleDropdown)).click();
		driver.findElement(By.xpath(add)).click();
		driver.findElement(By.xpath(jobTitle)).sendKeys(name);
		driver.findElement(By.xpath(jobDescription)).sendKeys(description);
		driver.findElement(By.xpath(addNote)).sendKeys(note);
		driver.findElement(By.xpath(save)).click();
	} 	
	@Test(priority=3)
	public void jobTitleEdit() {
		String edit = properties.getProperty("edit");
		String editAddNote = properties.getProperty("editAddNote");
		String editNote = properties.getProperty("editNote");
		String submit = properties.getProperty("submit");

		driver.findElement(By.xpath(edit)).click();
		driver.findElement(By.xpath(editAddNote)).clear();
		driver.findElement(By.xpath(editAddNote)).sendKeys(editNote);
		driver.findElement(By.xpath(submit)).click();
	}
	@AfterMethod
	private void closeApp() {
		driver.close();
	}

}

