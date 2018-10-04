import java.io.File;

public class Main {
    public static void main(String[] args) {

        String filename = "./file1.png"; // Filename in the main project directory:

        File f = new File(filename);

        if (f.exists()){
            FileExtension file = new FileExtension(filename);
            file.printMatching();
        } else {
            System.out.println("No such file");
        }

    }
}
