package testing;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class Otp {

	public static void main(String[] args) throws Exception 
	{
		 Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
			URL u=new URL("http://0.0.0.0:4723/wd/hub");
			
			DesiredCapabilities dc= new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME, "");
			//dc.setCapability("automationName", "uiautomator2");
			dc.setCapability("deviceName", "124bd058");
			dc.setCapability("platformName", "android");
			dc.setCapability("platformVersion", "5.0.2");
			dc.setCapability("appPackage", "com.miui.calculator");
			dc.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
			AndroidDriver driver1;
			while(2>1)
			{
				try
				{
					driver1=new AndroidDriver(u,dc);
					break;
				}
				catch(Exception e)
				{
					
				}
			}
			
			Activity jiovoice=new Activity("com.jio.join", "com.witsoftware.wmc.TabNavActivity");
			driver1.startActivity(jiovoice);
			WebDriverWait w=new WebDriverWait(driver1, 30);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.jio.join:id/rl_container'][@index='0']")));
			driver1.findElement(By.xpath("//*[@resource-id='com.jio.join:id/rl_container'][@index='0']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.jio.join:id/tv_message_text'][@index='0']")));
			String msg=driver1.findElement(By.xpath("//*[@resource-id='com.jio.join:id/tv_message_text'][@index='0']")).getAttribute("text");
			String gotp[]=msg.split(" ");
			String potp[]=gotp[0].split("-");
			String otp=potp[1];
			System.out.println(otp);
		
		

	}

}
