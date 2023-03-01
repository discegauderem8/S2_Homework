package TaskThree;

import com.google.gson.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONFormatter {

    public static void main(String[] args) throws FileNotFoundException { //ЗАМЕНЯЕТ TRY-CATCH

        File file = new File("C:\\Users\\Александр\\Desktop\\Geek Brains\\Java_1\\S2 + HW\\Homework\\untitled\\src\\main\\java\\TaskThree\\students_data.json");
        FileReader fileReader = new FileReader(file); //правый клик на FileReader, жмем на лампочку
        //система предлагает добавить "throws" в метод

        JsonArray jsonArray = new JsonParser().parse(fileReader).getAsJsonArray();
        System.out.println(formatJSON(jsonArray));
    }

    private static String formatJSON(JsonArray smth) {
        StringBuilder result = new StringBuilder();
        Gson gson = new Gson();


        for (JsonElement element : smth) {
            JsonObject singleObj = gson.fromJson(element, JsonObject.class);
            result.append("Студент ").append(singleObj.get("фамилия")).append(" получил оценку ").append(singleObj.get("оценка")).append(" по предмету ").append(singleObj.get("предмет")).append("\n");
            }

        String resultFormatted = result.toString();
        return resultFormatted;
    }
}
