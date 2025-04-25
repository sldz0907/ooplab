package soict.hedspi.garbage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "test.txt";
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            String outputString = "";
            for (byte b : inputBytes) {
                outputString += (char) b;
            }
            endTime = System.currentTimeMillis();
            System.out.println("GarbageCreator Time: " + (endTime - startTime) + " ms");
            // System.out.println("Output length: " + outputString.length()); // Bỏ comment nếu muốn xem độ dài
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.err.println("Make sure '" + filename + "' exists and is accessible.");
        } catch (OutOfMemoryError e) {
            System.err.println("OutOfMemoryError! Too much garbage created.");
            System.err.println("Try with a smaller file or use NoGarbage version.");
        }
    }
}
// Khi chạy với file lớn, chương trình này có thể chạy rất chậm hoặc gây OutOfMemoryError.