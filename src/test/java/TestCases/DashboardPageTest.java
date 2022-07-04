package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.DashboardPage;
import Pages.LoginPage;

public class DashboardPageTest extends TestBase {

	LoginPage login;
	DashboardPage dashboard;
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login = new LoginPage();
		dashboard=new DashboardPage();
		login.loginToApp();
		
	}
	
	
	@Test (enabled=false)
	public void verifyUsernameLabelTest() throws InterruptedException
	{
		String value = dashboard.verifyUsernameLabel();
		Assert.assertEquals("Punit Randhir Madankar", value);
	}
	
	@Test (enabled=false)
	public void verifyEmailIdLabelTest() throws InterruptedException
	{
		String value = dashboard.verifyEmailIdLabel();
		Assert.assertEquals("punitmadankar36@gmail.com", value);
	}
	
	@Test
	public void placeGTTOrderTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		dashboard.placeGTTOrder();
	}
	
	@AfterMethod
	public void exit()
	{
		driver.close();
	}
}
