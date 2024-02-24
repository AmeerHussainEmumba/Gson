package Tasks;

import Objects.BookObject;
import com.google.gson.Gson;

public class CreateLibrary {

    public BookObject[] createLibrary(String filePath) {

        JsonToString conversion = new JsonToString();
        StringBuilder convertedString = conversion.jsonToString(filePath);
        Gson gson = new Gson();
        BookObject[] books = gson.fromJson(convertedString.toString(), BookObject[].class);
        return books;
    }
}
