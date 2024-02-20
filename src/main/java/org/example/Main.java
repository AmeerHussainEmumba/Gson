package org.example;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Read JSON file into a string
            FileReader reader = new FileReader("src/main/resources/books.json");
            StringBuilder jsonString = new StringBuilder();
            int character;
            while ((character = reader.read()) != -1) {
                jsonString.append((char) character);
            }
            System.out.println(jsonString);
            reader.close();

            // Parse JSON string to BookObject array using GSON
            Gson gson = new Gson();
            bookObject[] books = gson.fromJson(jsonString.toString(), bookObject[].class);

//            // Print each BookObject
//            for (bookObject book : books) {
//                System.out.println("Title: " + book.title);
//                System.out.println("Price: " + book.price);
//                System.out.println("Categories: ");
//                for (String category : book.categories) {
//                    System.out.println("  - " + category);
//                }
//                System.out.println("ISBN: " + book.isbn);
//                System.out.println("Pages: " + book.pages);
//                System.out.println();
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
}
}