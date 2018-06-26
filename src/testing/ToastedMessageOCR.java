package testing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;

public class ToastedMessageOCR 
{

	public static void main(String[] args) throws Exception
	{
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
		Thread.sleep(10000);
		driver.pressKeyCode(AndroidKeyCode.HOME);
		Thread.sleep(3000);
		driver.pressKeyCode(AndroidKeyCode.MENU);
		driver.findElement(By.xpath("//*[@bounds='[478,1665][602,1789]']")).click();
		WebDriverWait w=new WebDriverWait(driver, 50);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Google']")));
		File scrnshot=driver.getScreenshotAs(OutputType.FILE);
		BufferedImage fullimage=ImageIO.read(scrnshot);
		//crop the image to get only toasted Message
		BufferedImage toastedmsg=fullimage.getSubimage(280, 1600, 600, 100);
		//ImageIO.write(toastedmsg, "png", scrnshot);
		Tesseract obj=new Tesseract();
		File fo=LoadLibs.extractTessResources("tessdata");
		obj.setDatapath(fo.getAbsolutePath());
		String toastMsgText=obj.doOCR(toastedmsg);
		Thread.sleep(20000);
		System.out.println(toastMsgText);
		File toastmsg=new File("D:\\kiran\\toast.png");
		FileUtils.copyFile(scrnshot, toastmsg);
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
