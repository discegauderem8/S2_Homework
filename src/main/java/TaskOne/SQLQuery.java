package TaskOne;

import com.google.gson.*;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class SQLQuery {

    public static void main(String[] args) throws FileNotFoundException { //ЗАМЕНЯЕТ TRY-CATCH

        File file = new File("C:\\Users\\Александр\\Desktop\\Geek Brains\\Java_1\\S2 + HW\\Homework\\untitled\\src\\main\\java\\TaskOne\\students_data.json");
        FileReader fileReader = new FileReader(file); //правый клик на FileReader, жмем на лампочку
                                                      //система предлагает добавить "throws" в метод

        JsonObject jsonObject = new JsonParser().parse(fileReader).getAsJsonObject();
        System.out.println(makeQuery(jsonObject));
    }
    private static String makeQuery (JsonObject jsonObject){
        StringBuilder result = new StringBuilder();
        result.append("SELECT * FROM People WHERE ");

        int count = 0;
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {   //Ключ в JSON - это String, значение - что угодно
            if (!entry.getValue().isJsonNull()) { // Если значение - не null
                if (count != jsonObject.keySet().size() - 2) {
                    result.append(entry);
                    result.append(" AND ");
                    count++;
                } else {
                    result.append(entry);
                }
            }
        }
        String resultFormatted = result.toString();
        return resultFormatted;
}


}
