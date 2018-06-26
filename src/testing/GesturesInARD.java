package testing;

import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class GesturesInARD {

	public static void main(String[] args) throws Exception
	{
		//start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		// Get ip 
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		// give details mobile and app
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("automationName", "uiautomator2");
		dc.setCapability("deviceName", "124bd058");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "5.0.2");
		dc.setCapability("appPackage", "com.android.settings");
		dc.setCapability("appActivity", "com.android.settings.MainSettings");
		//creat object driver
		AndroidDriver driver;
		while(2>1)
		{
			try
			{
				driver=new AndroidDriver(u,dc);
				break;
			}
			catch(Exception e)
			{
				
			}
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TouchAction ta=new TouchAction(driver);
	    int w=driver.manage().window().getSize().getWidth();
	    int h=driver.manage().window().getSize().getHeight();
	    System.out.println(w+" "+h);
	    
	    int x1=(int) (w/2);
	    int x2=(int) (w/2);
	    int y1=(int) (h*0.8);
	    int y2=(int) (h*0.3);
	    //swipe untill printing element is visible and click on it
	    while(2>1)
	    {
	    	try
	    	{
	    	driver.findElement(By.xpath("//*[@text='Additional settings']")).click();
	    	break;
	    	}
	    	catch(Exception e)
	    	{
	    Duration d=Duration.of(0, ChronoUnit.SECONDS); 
	    ta.press(x1, y1).moveTo(x2-50, y2).waitAction(d).release().perform();
	    Thread.sleep(3000);
	    	}
	    }
	    WebDriverWait wt=new WebDriverWait(driver, 15);
	    wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Date & time']")));
	    driver.pressKeyCode(AndroidKeyCode.HOME);
	    wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Gallery']")));
	    
	    //driver.pressKeyCode(AndroidKeyCode.HOME);
	    driver.findElement(By.xpath("//*[@text='Gallery']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@bounds='[0,310][267,577]']")).click();
	    
	    Thread.sleep(2000);
	    
	    Duration d=Duration.of(5, ChronoUnit.SECONDS);
	    
	    TouchAction ta1=new TouchAction(driver).press(w/2+20, h/2-20).moveTo(w/2+250, h/2-250).waitAction(d).release();
	    TouchAction ta2=new TouchAction(driver).press(w/2-20, h/2+20).moveTo(w/2-250, h/2+250).waitAction(d).release();
	    MultiTouchAction ma=new MultiTouchAction(driver);
	    ma.add(ta1).add(ta2).perform();
	}

}
