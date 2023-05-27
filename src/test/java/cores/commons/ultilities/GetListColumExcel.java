package cores.commons.ultilities;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetListColumExcel {

    public static List<String> handleExcelDocHetMotCot(String pathExcel, String nameFileExcel, String nameSheet, int firstColum)throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        int count = 0;
        String value = "";
        FileInputStream fileInputStream = new FileInputStream(pathExcel+ nameFileExcel);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet(nameSheet);
        Row row;
        Iterator<Row> listRow = sheet.iterator();
        while (listRow.hasNext() && !value.equals("null")){
            row = listRow.next();
            value = String.valueOf(row.getCell(firstColum-1));
            if(!value.equals("null")){
            arrayList.add(value);
            }

        }

        return arrayList;
    }


    public static void main(String[] args) throws IOException {
       List<String> arrayList = handleExcelDocHetMotCot("C:\\Users\\Admin\\IdeaProjects\\excel-spreadsheets\\fileExcel\\","testExcel.xlsx"
        ,"Trang tính1",1);
        System.out.println(arrayList);
//        handleExcel("C:\\Users\\Admin\\IdeaProjects\\excel-spreadsheets\\fileExcel\\","testbangtinh.xlsx"
//        ,"Trang tính1",1);
    }
}
