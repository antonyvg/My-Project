package Sample;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	public static XSSFSheet sh;
	public static  FileInputStream f;
	public static XSSFWorkbook w;
	public static String readStringData(int i,int j)throws IOException
	{
		f=new FileInputStream("C:\\Users\\admin\\Desktop\\JavaExcelRead.xlsx");
		w=new XSSFWorkbook(f);
		
		sh=w.getSheet("Sheet1");
		Row r=sh.getRow(i);
		Cell c=r.getCell(j);
		return c.getStringCellValue();
	}
	
	public static String readIntegerData(int i,int j)throws IOException
	{
		f=new FileInputStream("C:\\Users\\admin\\Desktop\\JavaExcelRead.xlsx");
		w=new XSSFWorkbook(f);
		sh=w.getSheet("Sheet1");
		Row r=sh.getRow(i);
		Cell c=r.getCell(j);
		int a=(int)c.getNumericCellValue();
		return String.valueOf(a);
	}

}
