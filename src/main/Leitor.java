package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Leitor {
	static XSSFRow row;
	public static void main(String[]args) throws IOException {
		FileInputStream fileIn=new FileInputStream("planilha de pagamentos.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fileIn);
	XSSFSheet sheet=workbook.getSheetAt(0);
		Iterator < Row > rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			row = (XSSFRow) rowIterator.next();
			Iterator < Cell >  cellIterator = row.cellIterator();
			while ( cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch (cell.getCellType()) {
			case NUMERIC:
					System.out.println(cell.getNumericCellValue());
					break;
				case STRING:
					System.out.println(cell.getStringCellValue());
					break;
				}
			}
		}
		fileIn.close();
	}
}
