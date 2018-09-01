package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.utils.TestUtil;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DropDownNDataProviderTest {
	
	 static WebDriver driver;
	
 
 @Test(dataProvider="")
 
 public void compareCountryDropdown(){ 
		
 	Select countryDropdown = new Select(driver.findElement(By.cssSelector("select#country-list")));
 	
 	List<String> actCountries = new ArrayList<String>();
 	
	  for(int i=1; i<countryDropdown.getOptions().size(); i++){
			  actCountries.add(countryDropdown.getOptions().get(i).getText());
		  }
	  System.out.println("Actual list");
	 for(String oneCountry : actCountries){
		  System.out.println(oneCountry);
	  }
	
	  
	  List<String> expCountries = TestUtil.getTestData("Country");
	  System.out.println("Expected list");
	  for(String oneCountry : expCountries){
		  System.out.println(oneCountry);
	  }
	
			
	 
	 Assert.assertEquals(actCountries, expCountries);
	  
}  
 
  @BeforeTest
  public void beforeTest() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().deleteAllCookies();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("https://phppot.com/demo/country-state-city-example-cascading-jquery-dependent-dropdown/");
  }

  @AfterTest
  public void afterTest() {
	  
	 driver.close();
  }

  }
