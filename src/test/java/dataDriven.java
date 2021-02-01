import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
public ArrayList<String> getData(String testcasename) throws IOException{
	ArrayList<String>a=new ArrayList<String>();
	
	FileInputStream fis=new FileInputStream("C://Users//Aakash//Documents//Akaash.xlsx");
	XSSFWorkbook workbook=	new XSSFWorkbook(fis);
	
	int sheets=workbook.getNumberOfSheets();
	for (int i = 0; i<sheets; i++) {
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("TestData"))
			{
				
				XSSFSheet sheet=workbook.getSheetAt(i);

				Iterator<Row>rows= sheet.iterator();
				Row firstrow=rows.next();
				Iterator<Cell>ce=firstrow.cellIterator();
				int k=0;
				int coloumn=0;
				while (ce.hasNext()) {
					Cell value =ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("Test Cases	"))
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

}
