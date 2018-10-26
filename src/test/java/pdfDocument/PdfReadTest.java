package pdfDocument;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PdfReadTest 
{

	@Test
	public void ReadPDFDocument() throws Exception
	{
		//Run chromedriver.exe to get chrome browser
		System.setProperty("webdriver.chrome.driver","/home/rajput/Downloads/Selenium WebDriver Library Jar/chromedriver/chromedriver");
						
		//create object to access chrome browser
		ChromeDriver driver=new ChromeDriver();
				
		driver.get("https://www.betterteam.com/downloads/job-application-form-template-download-standard-20170814.pdf");
		String urlPDF=driver.getCurrentUrl();
		
		URL url = new URL(urlPDF);

		InputStream is = url.openStream();
		BufferedInputStream fileParse = new BufferedInputStream(is);
		PDDocument document = null;
		document = PDDocument.load(fileParse);
		String pdfContent = new PDFTextStripper().getText(document);
		System.out.println(pdfContent);
		Assert.assertTrue(pdfContent.contains("Application For Employment"));
		driver.quit();
	}
	
}