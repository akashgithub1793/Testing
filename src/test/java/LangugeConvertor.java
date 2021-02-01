import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LangugeConvertor {
	
		public static void main(String[] args) throws IOException, InterruptedException {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aakash\\Desktop\\Testing drivers\\drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://www.englishtohindityping.com/english-to-marathi-translation");
			driver.manage().window().maximize();
			
			FileInputStream fis = new FileInputStream("C:\\Users\\Aakash\\Desktop\\Translation.xlsx");
	        XSSFWorkbook wb=new XSSFWorkbook(fis);
	        XSSFSheet Sheet1=wb.getSheetAt(0);

	        int rowcount=Sheet1.getLastRowNum();
	        int colcount=Sheet1.getRow(0).getLastCellNum();
	        System.out.println("Total Number of Rows is ::"+rowcount);
	        System.out.println("Total number of Col is ::"+colcount);

	        for(int i=0;i<rowcount+1;i++){
	            for(int j=0;j<colcount;j++){
	                String testdata1=Sheet1.getRow(i).getCell(j).getStringCellValue();
	                System.out.println("Test data from excel cell  :"+testdata1);
	              	                
					WebElement element= driver.findElement(By.xpath("//textarea[contains(@class,'textarea1')]")); //textarea[@class='content source-textarea textarea-for-translation']
					element.sendKeys(testdata1);
					driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/form/center/input")).click();
	                
					WebElement getelement = driver.findElement(By.xpath("//*[@id='myInput']"));
					String getstring = getelement.getText();
					
					Sheet1.getRow(i).createCell(j+2).setCellValue(getstring);					
					FileOutputStream fos = new FileOutputStream("C:\\Users\\Aakash\\Desktop\\Translation.xlsx");
					wb.write(fos);
					driver.findElement(By.xpath("//textarea[contains(@class,\"textarea1)]")).clear();
	            }

	        }
			}
		}
			


