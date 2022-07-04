package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage login;
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		login=new LoginPage();
	}
	
	@Test (enabled = false)
	public void verifyTitleTest()
	{
		String value=driver.getTitle();
		Assert.assertEquals("Kite - Zerodha's fast and elegant flagship trading platform", value);
	}
	
	@Test (enabled = false)
	public void verifyKiteLogoTest()
	{
		boolean value = login.verifyKiteLogo();
		Assert.assertEquals(value, true);
	}
	
	@Test (enabled = false)
	public void verifyZerodhalogoTest()
	{
		boolean value = login.verifyZerodhaLogo();
		Assert.assertEquals(value, true);
	}
	
	@Test
	public void loginToAppTest() throws InterruptedException, IOException
	{
		String value = login.loginToApp();
		Assert.assertEquals(value, "Punit");
	}
	
	
	@AfterMethod
	public void exit()
	{
		driver.close();
	}
	

}
