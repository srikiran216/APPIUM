package testing;

import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class MobileGestures 
{

	public static void main(String[] args) throws Exception 
	{
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"'");
		//Get url of appium server
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//give device and app details 
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("automationName", "uiautomator2");
		dc.setCapability("deviceName", "emulator-5554");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "7.0");
		dc.setCapability("appPackage", "com.android.settings");
		dc.setCapability("appActivity", "com.android.settings.Settings");
		//create driver object to run app in device
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
	    int y1=(int) (h*0.9);
	    int y2=(int) (h*0.8);
	    //swipe untill printing element is visible and click on it
	    while(2>1)
	    {
	    	try
	    	{
	    	driver.findElement(By.xpath("//*[@text='Printing']")).click();
	    	break;
	    	}
	    	catch(Exception e)
	    	{
	    Duration d=Duration.of(5, ChronoUnit.SECONDS); 
	    ta.press(x1,y1).moveTo(x2,y2).waitAction(d).release().perform();
	    	}
	    }
	    //open calender app
	    Activity calendar=new Activity("com.android.calendar", "com.android.calendar.AllInOneActivity");
	    driver.startActivity(calendar);
	    //swipe right to left for 5 times
	    x1=(int) (w*0.9);
	    y1=(int) (h/2);
	    x2=(int) (w*0.7);
	    y2=(int) (h/2);
	 
	    for(int i=1; i<=5; i++)
	    {
	    	Duration d=Duration.of(5, ChronoUnit.SECONDS); 
		    ta.press(x1,y1).moveTo(x2,y2).waitAction(d).release().perform();
	    }
	    //swipe left to right for 5 times
	    x1=(int) (w*0.1);
	    x2=(int) (w*0.3);
	    for(int i=1; i<=5; i++)
	    {
	    	Duration d=Duration.of(5, ChronoUnit.SECONDS); 
		    ta.press(x1,y1).moveTo(x2,y2).waitAction(d).release().perform();
	    }
	    
	    driver.pressKeyCode(AndroidKeyCode.HOME);
	    driver.findElement(By.xpath("//*[@text='Gallery']")).click();
	    Duration d=Duration.of(5, ChronoUnit.SECONDS);
	    ta.longPress(w/2, h/2).waitAction(d).release().perform();
	    
	    
 	  //stop server
	    Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	    //Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	    
		

	}

}
