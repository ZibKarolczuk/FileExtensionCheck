package good_solution_magic_numbers_approach;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;

public class MagicNumbers implements MagicNumbersMethods {

    private String filename;
    private File file;
    private byte[] bytes;

    private Hashtable magictable = new Hashtable();


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
            System.out.println(type.toUpperCase() + " file is indeed " + type.toUpperCase() + " file");
        } else {
            System.out.println("Extension is " + getFileExtension().toUpperCase() + ", while actually it's a " + type.toUpperCase());
        }
    }

    @Override
    public void identifyTypeByMagicNumbers() throws Exception {

        magictable.put("ffef", "txt");
        magictable.put("ffd8ff", "jpg");
        magictable.put("47494638", "gif");
        magictable.put("25504446", "pdf");

        Enumeration e = magictable.keys();
        boolean extensionKnown = false;

        while (e.hasMoreElements()){
            String key = (String) e.nextElement();
            if (convertToHexadecimal().contains(key)){
                extensionKnown = true;
                compareMagicNumberWithExtension((String) magictable.get(key));
            }
        }

        if (extensionKnown == false){
                throw new Exception ("File format not recognized");
        }

    }
}
