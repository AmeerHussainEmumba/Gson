package library.resources;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileReader;
import java.io.IOException;
import library.bookObjects.MetaData;
import java.util.Objects;

@Getter
@Setter

public class LibraryConstructor {
    public JsonToString jsonToString=new JsonToString();
    public BookProcessor bookProcessor=new BookProcessor();
    @Getter
    @Setter
    public static class BookObject {
        private String title;
        private String author;
        private MetaData metadata;
    }
    public BookObject[] addBooksToLibrary(String filePath) {
        StringBuilder convertedString = jsonFileErrorHandler(filePath);
        Gson gson = new Gson();
        return gson.fromJson(convertedString.toString(), BookObject[].class);
    }
    public StringBuilder jsonFileErrorHandler(String filePath) {
         final String categoriesKey="categories";
         final String priceKey="price";
         final String pagesKey="pages";
         final String metaDataKey= "metadata";
        StringBuilder convertedString = jsonToString.jsonToString(filePath);
        JSONArray jsonArray = new JSONArray(convertedString.toString());
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject book = jsonArray.getJSONObject(i);
            JSONObject metadata = book.getJSONObject(metaDataKey);
            int price = metadata.getInt(priceKey);
            int pages = metadata.getInt(pagesKey);
            Object categoriesValue = metadata.opt(categoriesKey);

            JSONArray categoriesArray = new JSONArray();
            if (categoriesValue != null && !Objects.equals(categoriesValue.toString(), "[]")) {
                if (categoriesValue instanceof JSONArray) {
                    categoriesArray = (JSONArray) categoriesValue;
                } else {
                    categoriesArray.put(categoriesValue);
                }
                metadata.put(categoriesKey, categoriesArray);
            } else if (Objects.equals(categoriesValue.toString(), "[]")) {
                String[] misc = {"Misc"};
                metadata.put(categoriesKey, misc);
            }
            if (price < 0) {
                metadata.put(priceKey, price * -1);
            }
            if (pages < 0) {
                metadata.put(pagesKey, pages * -1);
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
