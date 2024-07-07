package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver chromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;

	}

//	public static WebDriver browserLaunch(String browsername) {
//		if(browsername.equalsIgnoreCase("chrome")) {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		}
//		else if(browsername.equalsIgnoreCase("edge")) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		}
//		else if(browsername.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}
//		return driver;
//	}
	public static WebDriver browserLaunch(String browsername) {
		switch (browsername) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			System.err.println("INVALID BROWSER NAME");
			throw new WebDriverException();
		}
		return driver;

	}

	public static void urlLaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void implicitlyWait(int a) {
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);

	}

	public static void sendKeys(WebElement e, String a) {
		e.sendKeys(a);

	}

	public static void click(WebElement e) {
		e.click();

	}

	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}

	public static String getTitle() {
		String title = driver.getTitle();
		return title;

	}

	public static void quit() {
		driver.quit();

	}

	public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}

	public static String getAttribute(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;

	}

	public static void moveToElement(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();

	}

	public static void draAndDrop(WebElement src, WebElement tar) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, tar).perform();

	}

	public static void selectByIndex(WebElement e, int a) {
		Select s = new Select(e);
		s.selectByIndex(a);

	}

	public static void deselectByValue(WebElement e, String value) {
		Select s = new Select(e);
		s.deselectByValue(value);
	}
	
	public static void refresh() {
		driver.navigate().refresh();

	}

	public static WebElement findElement(String locatorname, String locvalue) {
		WebElement value = null;
		if (locatorname.equals("id")) {
			value = driver.findElement(By.id(locvalue));
		} else if (locatorname.equals("name")) {
			value = driver.findElement(By.name(locvalue));
		} else if (locatorname.equals("xpath")) {
			value = driver.findElement(By.xpath(locvalue));
		}
		return value;

	}
	
//	public static String excelDataValue(String filename,String sheet,int row,int cel) throws IOException {
//		File f=new File("C:\\Users\\inama\\eclipse-workspace\\Nov2023-Ramesh\\MavenProject8PMJan24\\src\\test\\resources\\Excel Data\\"+filename+".xlsx");
//		FileInputStream st=new FileInputStream(f);
//		Workbook w=new XSSFWorkbook(st);
//		Sheet s = w.getSheet(sheet);
//		Row r = s.getRow(row);
//		Cell cell = r.getCell(cel);
//		
//		int type = cell.getCellType();
//		
//		
//		String value=null;
//		if(type==1) {
//			 value = cell.getStringCellValue();
//		}
//		else{
//			if(DateUtil.isCellDateFormatted(cell)) {
//				Date dateCellValue = cell.getDateCellValue();
//				SimpleDateFormat sd=new SimpleDateFormat("dd-MMM-yyyy");
//				 value = sd.format(dateCellValue);
//			}
//			else {
//				double numericCellValue = cell.getNumericCellValue();
//			long num=(long)numericCellValue;
//		 value = String.valueOf(num);
//			}
//			
//		}
//		return value;
//		}

}
