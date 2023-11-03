import java.io.*;

public class LineNumberAdder {
    public static void main(String[] args) {
        try {
            // Open the source file for reading
            BufferedReader reader = new BufferedReader(new FileReader("purr.java"));
            String line;
            int lineNumber = 1;
            // Read each line from the source file until the end of the file is reached
            while ((line = reader.readLine()) != null) {
                // Print the current line number and the line itself
                System.out.println(lineNumber + ": " + line);
                // Increment the line number for the next iteration
                lineNumber++;
            }
            // Close the file reader
            reader.close();
        } catch (IOException e) {
            // Print the stack trace if an exception occurs during file processing
            e.printStackTrace();
        }
    }
}
