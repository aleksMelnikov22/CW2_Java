package core;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Repository {
    private String filename;

    public Repository(String filename) {
        this.filename = filename;
    }
    private String readFile() throws IOException {
        StringBuilder result = new StringBuilder();
        try(FileReader reader = new FileReader(this.filename))
        {
            int c;
            while((c=reader.read())!=-1){

                result.append((char) c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        return result.toString();
    }
    public Collection<String> getWords() throws IOException {
        String text = readFile();
        text = text.trim();
        Collection<String> words = new ArrayList<>(Arrays.asList(text.split(" ")));
        words.removeIf(String::isEmpty);
        return words;
    }
}