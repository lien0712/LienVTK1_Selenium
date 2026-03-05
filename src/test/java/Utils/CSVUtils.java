package Utils;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.List;

public class CSVUtils {
    public static Object[][] readCSV(String filePath) throws Exception {
        CSVReader reader = new CSVReader(new FileReader(filePath));
        List<String[]> rows = reader.readAll();
        reader.close();

        rows.remove(0);

        Object[][] data = new Object[rows.size()][];
        for (int i = 0; i < rows.size(); i++) {
            data[i] = rows.get(i);
        }
        return data;
    }
}
