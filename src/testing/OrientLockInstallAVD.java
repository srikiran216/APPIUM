package testing;

import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class OrientLockInstallAVD 
{
public static void main(String[] args) throws Exception 
{
	//Start appium server
			Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
			//Get URL for server
			URL u=new URL("http://0.0.0.0:4723/wd/hub");
			//Give device and app details
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME, "");
			//dc.setCapability("automationName", "uiautomator2");
			dc.setCapability("deviceName", "emulator-5554");
			dc.setCapability("platformName", "android");
			dc.setCapability("platformVersion", "7.0");
			//dc.setCapability("app", "/system/app/ExactCalculator/ExactCalculator.apk");
			dc.setCapability("appPackage", "com.android.calculator2");
			dc.setCapability("appActivity", "com.android.calculator2.Calculator");
			
			//create object to the driver
			AndroidDriver driver;
			while(1<2)
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
			Thread.sleep(2000);
			//lock the device
			driver.lockDevice();
			Thread.sleep(5000);
			if(driver.isLocked())
			{
				driver.unlockDevice();
			}
			String x=driver.getOrientation().name();
			System.out.println(x);
			if(x.equals("PORTRAIT"))
			{
				driver.rotate(ScreenOrientation.LANDSCAPE);
			}
			Duration d=Duration.of(10, ChronoUnit.SECONDS);
			driver.runAppInBackground(d);
			Thread.sleep(5000);
			
			driver.installApp("D:\\kiran\\apk_files\\WhatsApp.apk");
			
			
			

	}

}
