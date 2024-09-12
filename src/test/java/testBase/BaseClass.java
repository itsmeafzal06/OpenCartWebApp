package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public Logger logger;
	public static WebDriver driver;
	public Properties p;
	@BeforeClass(groups={"Master","Sanity","Regression"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//confi.properties");
		p=new Properties();
		p.load(file);
		logger=LogManager.getLogger(this.getClass());
		
		if(p.getProperty("environment").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities dc = new DesiredCapabilities();
		
		//os selection	
			if(os.equalsIgnoreCase("Windows")) {
				dc.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("linux")) {
				dc.setPlatform(Platform.LINUX);
			}
			else if(os.equalsIgnoreCase("Mac")) {
				dc.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("invalid operation system!!");
				return;
			}
	
		//browser selection
			if(br.equalsIgnoreCase("chrome")) {
				dc.setBrowserName("chrome");
			}
			else if(br.equalsIgnoreCase("edge")) {
				dc.setBrowserName("MicrosoftEdge");
			}
			else if(br.equalsIgnoreCase("firefox")) {
				dc.setBrowserName("firefox");
			}
			else  {
				System.out.println("invalid browser");
				return;
			}
			driver= new RemoteWebDriver(new URL("http://192.168.1.49:4444/wd/hub"),dc);
		}
		
		if(p.getProperty("environment").equalsIgnoreCase("local")) {
			
			switch (br.toLowerCase()) {
			case "chrome":driver=new ChromeDriver();break;
			case "edge": driver=new EdgeDriver();break;
			case "firefox": driver=new FirefoxDriver();break;
			default:System.out.println("invalid browser");return;
			
			}
		
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("url"));
	}
	
	@AfterClass(groups={"Master","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	
	public String randomString() {
		String	generateString= RandomStringUtils.randomAlphabetic(5); 
		return generateString;
	}
	
	public String randomNumber() {
		String Numeric=RandomStringUtils.randomNumeric(10);
		return Numeric;
	}
	
	public String randomAlphaNumber() {
		String AlphaNum=RandomStringUtils.randomAlphanumeric(10);
		return AlphaNum;
	}
	
	public String captureScreen(String tname) throws IOException {
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+ tname + "_" + timeStamp + ".png";
		File targetFile= new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}
	
}
