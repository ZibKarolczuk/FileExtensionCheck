package good_solution_magic_numbers_approach;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MagicNumbers implements MagicNumbersMethods {

    private String filename;
    private File file;
    private byte[] bytes;

    public MagicNumbers(String filename) {
        this.filename = filename;
        this.file = new File(filename);
        this.bytes = new byte[(int) file.length()];
    }

    @Override
    public String convertToHexadecimal() {
        String result = "";
        try {

            try (FileInputStream fileInputStream = new FileInputStream(file)) {
                fileInputStream.read(bytes);
            }

            StringBuilder hexFileBeginning = new StringBuilder();

            for (int i = 0; i < 8; i++) {
                char ch = (char)bytes[i];
                hexFileBeginning.append(Integer.toHexString((int) ch));
            }

            result = hexFileBeginning.toString();
            
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("I/O Error");
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public String getFileExtension() {
        int indexOfLastDot = filename.lastIndexOf(".");
        return filename.substring(indexOfLastDot + 1, filename.length());
    }

    @Override
    public void compareMagicNumberWithExtension(String type) {
        if (type.matches(getFileExtension())){
            System.out.println("The file is indeed " + type.toUpperCase() + " type");
        } else {
            System.out.println("File content is " + type.toUpperCase() + " but extension is " + getFileExtension().toUpperCase());
        }
    }

    @Override
    public void identifyTypeByMagicNumbers() {

        if (convertToHexadecimal().contains("ffef")){
            compareMagicNumberWithExtension("txt");
        }

        if (convertToHexadecimal().contains("ffd8ff")){
            compareMagicNumberWithExtension("jpg");
        }

        if (convertToHexadecimal().contains("47494638")){
            compareMagicNumberWithExtension("gif");
        }

        if (convertToHexadecimal().contains("25504446")){
            compareMagicNumberWithExtension("pdf");
        }

    }
}
