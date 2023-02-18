package cores.commons.ultilities;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetListColumExcel {

    public static List<String> handleExcel(String pathExcel, String nameFileExcel, String nameSheet, int firstColum, int secondColum)throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        int count = 1;
        String value;
        FileInputStream fileInputStream = new FileInputStream(pathExcel+ nameFileExcel);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet(nameSheet);
        Row row,row1;

        try {
            do {
                row = sheet.getRow(count);
                row1 = sheet.getRow(count);
                count++;
                value = String.valueOf(row.getCell(firstColum -1)) + " " + row1.getCell(secondColum  -1);
                arrayList.add(value);
            }while (!value.equals("null"));
        }catch (NullPointerException e){

        }
        return arrayList;
    }
}
