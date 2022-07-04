package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
	
	public static WebDriver driver;
	
	public String readPropertyfile(String value) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("C:\\Users\\LENOVO\\eclipse-new\\Project1\\src\\main\\java\\Config\\Config.properties");
		prop.load(file);
		
		return prop.getProperty(value);
		
	}
	
	public void initialization() throws IOException
	{
		ChromeOptions o = new ChromeOptions();
		o.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chromedriver", "chromedriver");
		driver=new ChromeDriver(o);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("https://kite.zerodha.com/");
		driver.get(readPropertyfile("url"));
		
	}
	
	public String excelSheet(int rowNum, int colNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file= new FileInputStream("C:\\Users\\LENOVO\\eclipse-new\\Project1\\TestData\\GTT Order.xlsx");
		Sheet data = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = data.getRow(rowNum).getCell(colNum).getStringCellValue();
		return value;
	}

}
