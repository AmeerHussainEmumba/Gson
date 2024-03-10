package LibraryActions;

import Objects.BookObject;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

@Getter
@Setter

public class Library {
    private JsonToString jsonToString;
    private BookProcessor bookProcessor;
    public BookObject[] addBooksToLibrary(String filePath) {
        StringBuilder convertedString = jsonFileErrorHandler(filePath);
        Gson gson = new Gson();
        return gson.fromJson(convertedString.toString(), BookObject[].class);
    }

    public StringBuilder jsonFileErrorHandler(String filePath) {
        StringBuilder convertedString = jsonToString.jsonToString(filePath);
        JSONArray jsonArray = new JSONArray(convertedString.toString());
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject book = jsonArray.getJSONObject(i);
            JSONObject metadata = book.getJSONObject("metadata");
            int price = metadata.getInt("price");
            int pages = metadata.getInt("pages");
            Object categoriesValue = metadata.opt("categories");
            JSONArray categoriesArray = new JSONArray();

            if (categoriesValue != null && !Objects.equals(categoriesValue.toString(), "[]")) {
                if (categoriesValue instanceof JSONArray) {
                    categoriesArray = (JSONArray) categoriesValue;
                } else {
                    categoriesArray.put(categoriesValue);
                }
                metadata.put("categories", categoriesArray);
            } else if (Objects.equals(categoriesValue.toString(), "[]")) {
                String[] Misc = {"Misc"};
                metadata.put("categories", Misc);
            }
            if (price < 0) {
                metadata.put("price", price * -1);
            }
            if (pages < 0) {
                metadata.put("pages", pages * -1);
            }
        }
        convertedString = new StringBuilder(jsonArray.toString());
        return convertedString;
    }
    public static class JsonToString {

        public StringBuilder jsonToString(String filePath) {
            StringBuilder jsonString = new StringBuilder();
            try {
                FileReader reader = new FileReader(filePath);
                int character;
                while ((character = reader.read()) != -1) {
                    jsonString.append((char) character);
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return jsonString;
        }
    }
}
