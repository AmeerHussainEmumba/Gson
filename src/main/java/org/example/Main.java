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
            BookObject[] books = gson.fromJson(jsonString.toString(), BookObject[].class);

            // Print each BookObject
            for (BookObject book : books) {
                System.out.println("Title: " + book.title);
                System.out.println("Author: "+ book.Author);
                System.out.println("Price: " + book.metadata.price);
                System.out.println("Categories: ");
                for (String category : book.metadata.categories) {
                    System.out.println("  - " + category);
                }
                System.out.println("ISBN: " + book.metadata.isbn);
                System.out.println("Pages: " + book.metadata.pages);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
}
}