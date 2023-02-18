package ultijson;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import javax.swing.text.html.HTMLDocument;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

public class ReadJson {
    public static void main(String[] args) throws FileNotFoundException {
        JsonParser parser = new JsonParser();
        Object obj = parser.parse(new FileReader("C:\\Users\\duc.vm4\\IdeaProjects\\BankGuruProjectProjectTest\\src\\test\\java\\resource\\account.json"));
        JsonObject jsonObject = (JsonObject)obj;
        String name = String.valueOf(jsonObject.get("Name"));
        String course = String.valueOf(jsonObject.get("Course"));
        JsonArray jsonArray = (JsonArray) jsonObject.get("Subject");
        System.out.println( name);
        System.out.println(course);
        Iterator iterator = jsonArray.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
