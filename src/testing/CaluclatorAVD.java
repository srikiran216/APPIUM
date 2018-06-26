package testing;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class CaluclatorAVD 
{
	public static void main(String[] args) throws Exception 
	{
		//get the two numbers from keyboard to add
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter 1st input");
		String input1=scan.nextLine();
		System.out.println("Enter 2nd input");
		String input2=scan.nextLine();
		
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		//Get URL for server
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Give device and app details
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("automationName", "uiautomator2");
		dc.setCapability("deviceName", "emulator-5554");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "7.0");
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
		try
		{

			//automate app screens
			for(int i=0; i<input1.length(); i++)
			{
				char ip1=input1.charAt(i);
				driver.findElement(By.xpath("//*[@text='"+ip1+"']")).click();
			}
			driver.findElement(By.xpath("//*[@content-desc='plus']")).click();
			for(int i=0; i<input2.length(); i++)
			{
				char ip2=input2.charAt(i);
				driver.findElement(By.xpath("//*[@text='"+ip2+"']")).click();
			}
			driver.findElement(By.xpath("//*[@content-desc='equals']")).click();
			//get output of calculator and validate
			String output=driver.findElement(By.xpath("//*[@class='android.widget.TextView'][@index='2']")).getAttribute("text");
			System.out.println(output);
			int ip1=Integer.parseInt(input1);
			int ip2=Integer.parseInt(input2);
			int outp=Integer.parseInt(output);
			if(outp==ip1+ip2)
			{
				System.out.println("calculator test passed");
			}
			else
			{
				System.out.println("calculator test failed");
			}

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		//Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}
