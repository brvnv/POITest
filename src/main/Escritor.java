package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Escritor {
	public static void main(String[]args) throws IOException {
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Folha de pagamento");
		FileOutputStream file=new FileOutputStream(new File("planilha de pagamentos.xlsx"));
		XSSFRow row;
		Map < String, Object[] > pagamentos= new TreeMap < String, Object[]>();
		pagamentos.put("1", new Object[] {"M�s", "Sal�rio"});
		pagamentos.put("2", new Object[] {"Janeiro", "1800,00"});
	pagamentos.put("3", new Object[] {"Fevereiro", "1800,00"});
		pagamentos.put("4", new Object[] {"Mar�o", "2111,00"});
		pagamentos.put("5", new Object[] {"Abril", "3000,00"});
		pagamentos.put("6", new Object[] {"Maio", "3800,00"});
		pagamentos.put("7", new Object[] {"Junho", "5850,00"});
		Set < String > keyid = pagamentos.keySet();
		int rowId=0;
		for(String key : keyid) {
			row=sheet.createRow(rowId++);
			Object[] objectArr = pagamentos.get(key);
			int cellId=0;
			for(Object obj : objectArr) {
				Cell cell=row.createCell(cellId++);
				cell.setCellValue((String)obj);
			}
		}
		workbook.write(file);
		file.close();
	}
}
