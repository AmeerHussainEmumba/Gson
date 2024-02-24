package Tasks;
import java.io.FileReader;
import java.io.IOException;

public class JsonToString {

    public StringBuilder jsonToString(String filePath)
    { StringBuilder jsonString = new StringBuilder();
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
