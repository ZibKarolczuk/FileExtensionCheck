package bad_solution_mime_approach;

public interface FileExtensionMethods {

    String getMimeType();
    String getFileExtension(); // Substract file extension only
    String getMatchPattern(); // For regular expression
    boolean fileTypeMatchingExtension();
    void printMatching();

}
