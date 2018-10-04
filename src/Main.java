import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        String filename = "./file1.png"; // Filename in the main project directory:

        try {

            Path source = Paths.get(filename); // An object alllocating the file:
            System.out.println(Files.probeContentType(source)); // Testing if can get a type of the file form MIME (Magic numbers):

        } catch (IOException e){
            System.out.println("No such file exists"); // Exception
        }

    }
}
