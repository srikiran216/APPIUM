package testing;

import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class ARDphoneDailing {

	public static void main(String[] args) throws Exception
	{
		//give mobile number to dail
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter mobile number to Dail");
		String x=scan.nextLine();
		//start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		// Get ip 
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		// give details mobile and app
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName", "192.168.43.2:5555");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "5.0.2");
		dc.setCapability("appPackage", "com.android.contacts");
		dc.setCapability("appActivity", "com.android.contacts.activities.TwelveKeyDialer");
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
		Thread.sleep(2000);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		for(int i=0; i<x.length(); i++)
		{
			char y=x.charAt(i);
			String z="";
			switch(y)
			{
			case '0':
			{
				z="zero";
				break;
			}
			case '1':
			{
				z="one";
				break;
			}
			case '2':
			{
				z="two";
				break;
			}
			case '3':
			{
				z="three";
				break;
			}
			case '4':
			{
				z="four";
				break;
			}
			case '5':
			{
				z="five";
				break;
			}
			case '6':
			{
				z="six";
				break;
			}
			case '7':
			{
				z="seven";
				break;
			}
			case '8':
			{
				z="eight";
				break;
			}
			case '9':
			{
				z="nine";
				break;
			}
			default :
			{
				System.out.println("Enter a valid number");
			}
			}
			driver.findElement(By.xpath("//*[@content-desc='"+z+"']")).click();
		}
		
		
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		//stop server
	    Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	    Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

	}

}
