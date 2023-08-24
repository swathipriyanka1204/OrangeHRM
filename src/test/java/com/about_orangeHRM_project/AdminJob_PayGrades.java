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

public class AdminJob_PayGrades {
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties properties;
	@BeforeTest
	public void setUp() {
		properties = new Properties();
		String configFilePath = "E:\\priyanka\\e\\02.07.2023\\about_orangeHRM_project\\src\\test\\java\\adminJob_PayGrades.properties";
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
	public void editPayGrade() {
		String admin = properties.getProperty("admin");
		String jobDropdown = properties.getProperty("jobDropdown");
		String payGrade = properties.getProperty("payGrade");
		String edit = properties.getProperty("edit");
		String name = properties.getProperty("name");
		String grade = properties.getProperty("grade");
		String save = properties.getProperty("save");


		driver.findElement(By.xpath(admin)).click();
		driver.findElement(By.xpath(jobDropdown)).click();
		driver.findElement(By.xpath(payGrade)).click();
		driver.findElement(By.xpath(edit)).click();
		driver.findElement(By.xpath(name)).clear();
		driver.findElement(By.xpath(name)).sendKeys(grade);
		driver.findElement(By.xpath(save)).click();
	}
	@Test(priority=3)
	public void addCurrecy() {
		try {
			String addCurrency = properties.getProperty("addCurrency");
			String currency = properties.getProperty("currency");
			String currencySelect = properties.getProperty("currencySelect");
			String currencyName = properties.getProperty("currencyName");
			String minimumSalary = properties.getProperty("minimumSalary");
			String minSalary = properties.getProperty("minSalary");
			String maximumSalary = properties.getProperty("maximumSalary");
			String maxSalary = properties.getProperty("maxSalary");
			String save = properties.getProperty("save");

			Thread.sleep(3000);   
			driver.findElement(By.xpath(addCurrency)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(currency)).click();
			Thread.sleep(3000);

			java.util.List<WebElement> list = driver.findElements(By.xpath(currencySelect));
			Iterator<WebElement> iterator = list.iterator();
			while (iterator.hasNext()) {
				WebElement webElement = (WebElement) iterator.next();
				System.out.println(webElement.getText());
				if(webElement.getText().equals(currencyName)) {
					webElement.click();

					driver.findElement(By.xpath(minimumSalary)).sendKeys(minSalary);
					Thread.sleep(3000);
					driver.findElement(By.xpath(maximumSalary)).sendKeys(maxSalary);
					Thread.sleep(3000);
					driver.findElement(By.xpath(save)).click();
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

