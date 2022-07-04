package Pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class DashboardPage extends TestBase {
	
	@FindBy(xpath="//div[@id='avatar-84']") private WebElement idIcon;
	@FindBy(xpath="//h4[@class='username']") private WebElement usernameLabel;
	@FindBy(xpath="//div[@class='email']") private WebElement emailIdLabel;
	
	@FindBy(xpath="//button[text()='Start investing ']") private WebElement startInvestingButton;
	@FindBy(xpath="(//input[@icon='search'])[2]") private WebElement searchBar;
	@FindBy(xpath="//span[@class='tradingsymbol']") private WebElement selectShare;
	@FindBy(xpath="//button[text()='Create GTT ']") private WebElement createGTTButton;
	@FindBy(xpath="//input[@label='Trigger price']") private WebElement triggerpriceTextbox;
	@FindBy(xpath="//input[@label='Qty.']") private WebElement qtyTextbox;
	@FindBy(xpath="//input[@label='Price']") private WebElement priceTextbox;
	@FindBy(xpath="//button[normalize-space(text())='Cancel']") private WebElement cancelButton;
 	
	public DashboardPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyUsernameLabel() throws InterruptedException
	{
		idIcon.click();
		Thread.sleep(2000);
		return usernameLabel.getText();
	}
	
	public String verifyEmailIdLabel() throws InterruptedException
	{
		idIcon.click();
		Thread.sleep(2000);
		return emailIdLabel.getText();
	}
	
	public void placeGTTOrder() throws InterruptedException, EncryptedDocumentException, IOException
	{
		startInvestingButton.click();
		Thread.sleep(2000);
//		searchBar.sendKeys("INFY");
		searchBar.sendKeys(excelSheet(1, 0));
		Thread.sleep(2000);
		selectShare.click();
		Thread.sleep(2000);
		createGTTButton.click();
		Thread.sleep(2000);
		triggerpriceTextbox.clear();
		Thread.sleep(2000);
		triggerpriceTextbox.sendKeys(excelSheet(1, 1));
		Thread.sleep(2000);
		qtyTextbox.clear();
		Thread.sleep(2000);
		qtyTextbox.sendKeys(excelSheet(1, 2));
		Thread.sleep(2000);
		priceTextbox.clear();
		Thread.sleep(2000);
		priceTextbox.sendKeys(excelSheet(1, 3));
		Thread.sleep(2000);
		cancelButton.click();
		Thread.sleep(2000);
	}
	

}
