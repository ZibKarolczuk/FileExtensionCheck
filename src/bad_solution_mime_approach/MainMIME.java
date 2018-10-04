package bad_solution_mime_approach;

import java.io.*;

public class MainMIME {

    public static void main(String[] args) {

        String filename = "./files/file3.jpg"; // Filename in the main project directory:

        File f = new File(filename);

        if (f.exists()){
            FileExtension file = new FileExtension(filename);
            file.printMatching();
        } else {
            System.out.println("No such file");
        }

    }
}
