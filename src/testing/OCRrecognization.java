package testing;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;

public class OCRrecognization 
{

	public static void main(String[] args) throws Exception 
	{
		File image=new File("D:\\kiran\\ToastMsg.png");
		File srcOCR=LoadLibs.extractTessResources("tessdata");
		Tesseract obj=new Tesseract();
		obj.setDatapath(srcOCR.getAbsolutePath());
		String result=obj.doOCR(image);
		Thread.sleep(10000);
		System.out.println(result);

	}

}
