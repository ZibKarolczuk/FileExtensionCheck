import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileExtension {

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

    public String getMimeType() {
        return mimeType;
    }
}
