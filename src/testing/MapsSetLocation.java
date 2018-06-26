package testing;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class MapsSetLocation 
{

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
				dc.setCapability("locationServicesEnabled", true);
				dc.setCapability("locationServicesAuthorized", true);
				dc.setCapability("appPackage", "com.miui.calculator");
				dc.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
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
				try
				{
				Thread.sleep(10000);
				Activity a=new Activity("com.google.android.apps.maps","com.google.android.maps.MapsActivity");
				driver.startActivity(a);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Thread.sleep(15000);
				//set location to bangalore
				Location bang=new Location(12.9716,77.5946,2000);
				driver.setLocation(bang);
				Thread.sleep(25000);
				//set location to bhimavaram
				Location bhim=new Location(16.5449,81.5212,2000);
				driver.setLocation(bhim);
				Thread.sleep(25000);
				driver.openNotifications();
				Thread.sleep(10000);
				driver.lockDevice();
				Thread.sleep(10000);
				if(driver.isLocked()==true)
				{
					System.out.println("Device is locked");
					//driver.unlockDevice();
				}
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				//stop server
			    Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			    Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

	}

}
