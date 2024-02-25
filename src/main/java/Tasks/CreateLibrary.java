package Tasks;

import Objects.BookObject;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Objects;

public class CreateLibrary {

    public BookObject[] createLibrary(String filePath) {
        StringBuilder convertedString = jsonFiltering(filePath);
        Gson gson = new Gson();
        BookObject[] books = gson.fromJson(convertedString.toString(), BookObject[].class);
        return books;
    }

    public StringBuilder jsonFiltering(String filePath) {
        JsonToString conversion = new JsonToString();
        StringBuilder convertedString = conversion.jsonToString(filePath);
        JSONArray jsonArray = new JSONArray(convertedString.toString());
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject book = jsonArray.getJSONObject(i);
            JSONObject metadata = book.getJSONObject("metadata");
            int price = metadata.getInt("price");
            int pages =metadata.getInt("pages");
            Object categoriesValue = metadata.opt("categories");
            JSONArray categoriesArray = new JSONArray();

            if (categoriesValue != null && !Objects.equals(categoriesValue.toString(), "[]")) {
                if (categoriesValue instanceof JSONArray) {
                    categoriesArray = (JSONArray) categoriesValue;
                } else {
                    categoriesArray.put(categoriesValue);
                }
                metadata.put("categories", categoriesArray);
            }
                else if (Objects.equals(categoriesValue.toString(), "[]"))
                {   System.out.println(book.getString("title")+ " key koi category nai hay");
                String[] Misc={"Misc"};
                metadata.put("categories",Misc);
                }
            if (price <0) {
                metadata.put("price", price*-1);
            }
            if (pages<0)
            {
                metadata.put("pages", pages*-1);
            }

        }
        convertedString= new StringBuilder(jsonArray.toString());
        return convertedString;
    }
}

