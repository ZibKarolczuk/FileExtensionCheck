package good_solution_magic_numbers_approach;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String filename = "./files/file1.txt";
        File file = new File(filename);

        byte[] b = new byte[(int) file.length()];

        try {
            try (FileInputStream fileInputStream = new FileInputStream(file)) {
                fileInputStream.read(b);
            }

            StringBuilder hex = new StringBuilder();

            for (int i = 0; i < 8; i++) {
                char ch = (char)b[i];
                hex.append(Integer.toHexString((int) ch));
            }

            System.out.println(hex.toString()); // TEST READING MAGIC NUMBERS

            //pdf 25504446
            //gif 47494638
            //jpg ffd8ff


        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("I/O Error");
            e.printStackTrace();
        }

    }
}
