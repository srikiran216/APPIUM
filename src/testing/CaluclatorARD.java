package testing;

import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class CaluclatorARD 
{
public static void main(String[] args) throws Exception
{
	//get the two numbers from keyboard to add
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter 1st input");
			String input1=scan.nextLine();
			System.out.println("Enter 2nd input");
			String input2=scan.nextLine();
	//start appium server
			Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
			// Get ip 
			URL u=new URL("http://0.0.0.0:4723/wd/hub");
			// give details mobile and app
			DesiredCapabilities dc= new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME, "");
			dc.setCapability("deviceName", "124bd058");
			dc.setCapability("platformName", "android");
			dc.setCapability("platformVersion", "5.0.2");
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
				Thread.sleep(1000);
				//get output of calculator and validate
				String output=driver.findElement(By.xpath("//*[@bounds='[729,618][1002,825]'][@index='1']")).getAttribute("text");
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
			Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

	}

}
