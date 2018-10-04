import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class FileExtension implements FileExtensionMethods {

    private String filename;
    private String mimeType;

    public FileExtension(String filename) {
        this.filename = filename;
        Path source = Paths.get(filename); // An object alllocating the file:
        try {
            this.mimeType = Files.probeContentType(source); //Getting MIME type of the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFilename() {
        return filename;
    }

    @Override
    public String getMimeType() {
        return mimeType;
    }

    @Override
    public String getFileExtension() {
        int indexOfLastDot = filename.lastIndexOf(".");
        return filename.substring(indexOfLastDot + 1, filename.length());
    }

    @Override
    public String getMatchPattern() {
        String matcher = "\\.*" + getFileExtension() + "\\.*"; //Use of regular expression to match
        return matcher;
    }

    @Override
    public boolean fileTypeMatchingExtension() {
        return Pattern.matches(getMatchPattern(), getFileExtension()) ? true : false;
    }

    

}
