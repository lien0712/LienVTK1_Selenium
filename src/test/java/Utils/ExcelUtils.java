package Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtils {
    public static Object[][] readExcel(String filePath, String sheetName) throws Exception {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook   = new XSSFWorkbook(fis);
        Sheet sheet         = workbook.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum();       // số dòng (bỏ header)
        int colCount = sheet.getRow(0).getLastCellNum(); // số cột

        Object[][] data = new Object[rowCount][colCount];

        for (int i = 1; i <= rowCount; i++) {        // i=1 để bỏ header
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                data[i - 1][j] = getCellValue(cell);
            }
        }

        workbook.close();
        fis.close();
        return data;
    }

    private static Object getCellValue(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING:  return cell.getStringCellValue();
            case BOOLEAN: return cell.getBooleanCellValue();
            case NUMERIC: return cell.getNumericCellValue();
            default:      return "";
        }
    }
}
