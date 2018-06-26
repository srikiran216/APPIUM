package testing;

import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class MultiARDcallRecive 
{

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
				// give details ARD1 mobile and app
				DesiredCapabilities dc1= new DesiredCapabilities();
				dc1.setCapability(CapabilityType.BROWSER_NAME, "");
				dc1.setCapability("automationName", "uiautomator2");
				dc1.setCapability("deviceName", "124bd058");
				dc1.setCapability("platformName", "android");
				dc1.setCapability("platformVersion", "5.0.2");
				dc1.setCapability("appPackage", "com.miui.calculator");
				dc1.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
				
				//give details ARD2 mobile and app
				DesiredCapabilities dc2= new DesiredCapabilities();
				dc2.setCapability(CapabilityType.BROWSER_NAME, "");
				dc2.setCapability("automationName", "uiautomator2");
				dc2.setCapability("deviceName", "0123456789ABCDEF");
				dc2.setCapability("platformName", "android");
				dc2.setCapability("platformVersion", "5.1");
				dc2.setCapability("appPackage", "com.android.calculator2");
				dc2.setCapability("appActivity", "com.android.calculator2.Calculator");
				
				//creat object driver1 To automate ARD1
				AndroidDriver driver1;
				while(2>1)
				{
					try
					{
						driver1=new AndroidDriver(u,dc1);
						break;
					}
					catch(Exception e)
					{
						
					}
				}
				driver1.pressKeyCode(AndroidKeyCode.HOME);
				
				//creat object driver2 To automate ARD1
				AndroidDriver driver2;
				while(2>1)
				{
					try
					{
						driver2=new AndroidDriver(u,dc2);
						break;
					}
					catch(Exception e)
					{
						
					}
				}
				driver2.pressKeyCode(AndroidKeyCode.HOME);
				
				
				try
				{
				Activity jiovoice=new Activity("com.jio.join", "com.witsoftware.wmc.TabNavActivity");
				driver1.startActivity(jiovoice);
				driver1.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver1.findElement(By.xpath("//*[@class='android.widget.ImageButton']")).click();
				WebDriverWait w1=new WebDriverWait(driver1, 30);
				w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Most used']")));
				//dail phone number
				for(int i=0; i<x.length(); i++)
				{
					char z=x.charAt(i);
					driver1.findElement(By.xpath("//*[@text='"+z+"']")).click();
					Thread.sleep(1000);
				}
				//click on call button
				driver1.findElement(By.xpath("//*[@class='android.widget.ImageButton']")).click();
				Thread.sleep(7000);
				//accept phone call in ARD 2
				//WebDriverWait w2=new WebDriverWait(driver2, 30);
				//w2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@]")));
				driver2.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				TouchAction ta2=new TouchAction(driver2);
				ta2.tap(240, 55).perform();
				Thread.sleep(2000);
				Duration d=Duration.of(2, ChronoUnit.SECONDS);
				ta2.press(245, 670).moveTo(376, 670).release().perform();
				Thread.sleep(15000);
				//End call
				driver2.findElement(By.xpath("//*[@class='android.widget.ImageButton']")).click();
				
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}
				//stop server
			    Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			    //Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}
