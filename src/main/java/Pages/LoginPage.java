package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//img[@alt='Kite']") private WebElement kiteLogo;
	@FindBy(xpath="//img[@alt='Zerodha']") private WebElement zerodhaLogo;
	@FindBy(xpath="//input[@id='userid']") private WebElement userIdTextbox;
	@FindBy(xpath="//input[@id='password']") private WebElement passwordTextbox;
	@FindBy(xpath="//button[@type='submit']") private WebElement loginButton;
	@FindBy(xpath="//input[@id='pin']") private WebElement pinTextbox;
	@FindBy(xpath="//button[@type='submit']") private WebElement continueButton;
	@FindBy(xpath="//span[@class='nickname']") private WebElement nicknameLabel;
	
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyKiteLogo()
	{
		return kiteLogo.isDisplayed();
	}
	
	public boolean verifyZerodhaLogo()
	{
		return zerodhaLogo.isDisplayed();
	}
	
	public String loginToApp() throws InterruptedException, IOException
	{
		userIdTextbox.sendKeys(readPropertyfile("userId"));
		passwordTextbox.sendKeys(readPropertyfile("password"));
		loginButton.click();
//		Thread.sleep(3000);
		
		pinTextbox.sendKeys(readPropertyfile("pin"));
		continueButton.click();
		Thread.sleep(5000);
		
		return nicknameLabel.getText();
		
		
	}

}
