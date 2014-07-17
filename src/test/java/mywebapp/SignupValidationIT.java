package mywebapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mysql.jdbc.Statement;

public class SignupValidationIT {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSignupValidation() throws Exception {
	String testUserName = "test9";
    driver.get(baseUrl + "/mywebapp/home.action");
    driver.findElement(By.linkText("Sign up")).click();
    driver.findElement(By.id("signup_submit")).click();
    driver.findElement(By.id("name")).clear();
    assertEquals(false, doesUserExist(testUserName));
    driver.findElement(By.id("name")).sendKeys("Test9");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("test9@gmail.com");
    driver.findElement(By.id("signup_submit")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys(testUserName);
    driver.findElement(By.id("signup_submit")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("test");
    driver.findElement(By.id("signup_submit")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("test");
    assertEquals("Please confirm your password by re-entering it in the Confirm Password field.", driver.findElement(By.cssSelector("span")).getText());
    driver.findElement(By.id("confirmPassword")).clear();
    driver.findElement(By.id("confirmPassword")).sendKeys("test");
    driver.findElement(By.id("signup_submit")).click();
    assertEquals(true, doesUserExist(testUserName));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
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

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
  
  private boolean doesUserExist(String userName) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	  Connection conn = null;
	  try {
	  String url ="jdbc:mysql://localhost:3306";
      // Load Microsoft SQL Server JDBC driver
      String dbClass = "com.mysql.jdbc.Driver";
      Class.forName(dbClass).newInstance();
      //Get connection to DB
      conn = DriverManager.getConnection(url, "root", "Sneha$12");
	 
      //Create Statement
      Statement stmt = (Statement) conn.createStatement();
      // method which returns the requested information as rows of data
      ResultSet result = (ResultSet) stmt.executeQuery("SELECT * FROM test.user WHERE USERNAME = '" + userName + "'");
      
      if(result.next())
      {
           return true;
      } else {
    	  return false;
      }
  }  catch (SQLException e) {
		throw new RuntimeException(e);
	} finally {
		if (conn != null) {
			try {
			conn.close();
			} catch (SQLException e) {}
		}
	}
}
}
