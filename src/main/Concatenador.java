package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Concatenador {
	static XSSFRow row;

public static void main(String[]args) throws IOException {
	int rowIndex=0;
	int cellIndex=0;
	FileInputStream fileIn=new FileInputStream("Planilha de pagamentos - primeiro semestre.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(fileIn);
	XSSFWorkbook wb2=new XSSFWorkbook ();
	XSSFSheet sheet=wb.getSheetAt(0);
	XSSFSheet sheet2=wb2.createSheet(sheet.getSheetName());
	Iterator < Row > rowIterator = sheet.iterator();
	while (rowIterator.hasNext()) {
	row = (XSSFRow) rowIterator.next();
		Iterator < Cell >  cellIterator = row.cellIterator();
		while ( cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			row=sheet2.createRow(rowIndex++);
			switch(cell.getCellType()) {
			case NUMERIC:
				row.createCell(cellIndex++).setCellValue(cell.getNumericCellValue());
				break;
			case STRING:
				row.createCell(cellIndex++).setCellValue(cell.getStringCellValue());
				break;
			}
		}
	}
	FileOutputStream fileOut=new FileOutputStream(new File("Planilha de pagamentos - final.xlsx"));
	wb2.write(fileOut);
	fileOut.close();
	fileIn.close();
}
}
