package testing;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class PhoneDailing
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
	dc.setCapability("deviceName", "emulator-5554");
	dc.setCapability("platformName", "android");
	dc.setCapability("platformVersion", "7.0");
	dc.setCapability("appPackage", "com.android.dialer");
	dc.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
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
		driver.findElement(By.xpath("//*[@content-desc='dial pad']")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//*[@content-desc='9,WXYZ']")).click();
		driver.findElement(By.xpath("//*[@content-desc='4,GHI']")).click();
		driver.findElement(By.xpath("//*[@content-desc='9,WXYZ']")).click();
		driver.findElement(By.xpath("//*[@content-desc='1,']")).click();
		driver.findElement(By.xpath("//*[@content-desc='6,MNO']")).click();
		driver.findElement(By.xpath("//*[@content-desc='4,GHI']")).click();
		driver.findElement(By.xpath("//*[@content-desc='3,DEF']")).click();
		driver.findElement(By.xpath("//*[@content-desc='2,ABC']")).click();
		driver.findElement(By.xpath("//*[@content-desc='6,MNO']")).click();
		driver.findElement(By.xpath("//*[@content-desc='4,GHI']")).click();
		
		driver.findElement(By.xpath("//*[@content-desc='dial']")).click();
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	
	
	Thread.sleep(5000);
    //driver.pressKeyCode(AndroidKeyCode.HOME);
	//stop server
    Runtime.getRuntime().exec("taskkill /F /IM node.exe");
    Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

	}

}
