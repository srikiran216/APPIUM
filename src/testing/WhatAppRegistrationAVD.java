package testing;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class WhatAppRegistrationAVD 
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
				dc.setCapability("deviceName", "0123456789ABCDEF");
				dc.setCapability("platformName", "android");
				dc.setCapability("platformVersion", "5.1");
				dc.setCapability("appPackage", "com.whatsapp");
				dc.setCapability("appActivity", "com.whatsapp.Main");
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
				try
				{
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				//driver.findElement(By.xpath("//*[@text='OK']")).click();
				driver.findElement(By.xpath("//*[@text='Agree and continue']")).click();
				WebDriverWait w=new WebDriverWait(driver,30);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='phone number']")));
				driver.findElement(By.xpath("//*[@text='phone number']")).sendKeys("8328342230");
				driver.findElement(By.xpath("//*[@text='Next']")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='OK']")));
				driver.findElement(By.xpath("//*[@text='OK']")).click();
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
