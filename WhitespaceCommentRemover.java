import java.io.*;
import java.util.regex.*;

public class WhitespaceCommentRemover {
    public static void main(String[] args) {
        try {
            // Open the source file for reading
            BufferedReader reader = new BufferedReader(new FileReader("purr.java"));
            String line;
            // Read each line from the source file until the end of the file is reached
            while ((line = reader.readLine()) != null) {
                // Remove all white spaces from the current line
                String modifiedLine = line.replaceAll("\\s+", "");
                // Remove both single-line and multi-line comments from the current line
                modifiedLine = modifiedLine.replaceAll("//.*|/\\*(.|\\n)*?\\*/", "");
                // Print the modified line without white spaces and comments
                System.out.println(modifiedLine);
            }
            // Close the file reader
            reader.close();
        } catch (IOException e) {
            // Print the stack trace if an exception occurs during file processing
            e.printStackTrace();
        }
    }
}
