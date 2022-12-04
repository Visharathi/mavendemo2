package baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//https://github.com/naveenanimation20/PageObjectModel

public class baseclass {
	public static WebDriver driver;
	public static Properties prop;
	public baseclass(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Visha\\eclipse-workspace\\mavendemo\\src\\main\\java\\data\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
					}}
	public static void initialization(){
			String browserName = prop.getProperty("browser");
			
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");	
				driver = new ChromeDriver(); 
			}
			else if(browserName.equals("FF")){
				System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
				driver = new FirefoxDriver(); 
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
					
			driver.get(prop.getProperty("url"));

}
	

}
