import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenExtractor {
    public static void main(String[] args) {
        try {
            // Open the source file for reading
            BufferedReader reader = new BufferedReader(new FileReader("purr.java"));
            String line;
            while ((line = reader.readLine()) != null) {
                // Removing single-line comments
                line = line.replaceAll("//.*", "");
                // Removing multi-line comments
                line = line.replaceAll("/\\*.*\\*/", "");

                // Extracting tokens along with their types using regular expressions
                Pattern pattern = Pattern.compile("\\b(\\w+)\\b|([\\+\\-\\*/=])");
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    // Printing each extracted token along with its type
                    String identifier = matcher.group(1);
                    String operator = matcher.group(2);
                    if (identifier != null) {
                        System.out.println("Type: Identifier, Token: " + identifier);
                    } else if (operator != null) {
                        System.out.println("Type: Operator, Token: " + operator);
                    }
                }
            }
            // Close the file reader
            reader.close();
        } catch (IOException e) {
            // Print the stack trace if an exception occurs during file processing
            e.printStackTrace();
        }
    }
}
