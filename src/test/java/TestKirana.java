import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class TestKirana {

		ArrayList<String> getData(String testcasename) throws IOException{
			ArrayList<String>a=new ArrayList<String>();
			
			FileInputStream fis=new FileInputStream("C://Users//Aakash//Desktop//Translation.xlsx");
			XSSFWorkbook workbook=	new XSSFWorkbook(fis);
			
			int sheets=workbook.getNumberOfSheets();
			for (int i = 0; i<sheets; i++) {
				{
					if(workbook.getSheetName(i).equalsIgnoreCase("Kirana"))
					{
						
						XSSFSheet sheet=workbook.getSheetAt(i);

						Iterator<Row>rows= sheet.iterator();
						Row firstrow=rows.next();
						Iterator<Cell>ce=firstrow.cellIterator();
						int k=0;
						int coloumn=0;
						while (ce.hasNext()) {
							Cell value =ce.next();
							if(value.getStringCellValue().equalsIgnoreCase("English "))
							{
								coloumn=k;
							}
							k++;
						}
						System.out.println(coloumn);
						
						while (rows.hasNext()) {
							Row r=rows.next(); 
							if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcasename))
							{
								Iterator<Cell> cv=r.cellIterator();
								while (cv.hasNext()) {
								a.add(cv.next().getStringCellValue());
									
								}
							}
							
							
						}
						
					}
				}
				
				
			}
			return a;
		}	
			
		
		public static void main(String[] args) throws IOException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aakash\\Desktop\\Testing drivers\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.englishtohindityping.com/english-to-marathi-translation");
		
		WebElement text=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/form/textarea"));
		Kirana k=new Kirana();
		ArrayList data=k.getData("tikhat");
		//text.sendKeys((CharSequence[])data.get(0));
		text.sendKeys("tikhat");
		text.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/form/center/input")).click();
		text.getText();
		
}
}
