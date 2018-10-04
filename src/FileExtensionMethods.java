public interface FileExtensionMethods {

    String getMimeType();
    String getFileExtension(); // Substract file extension only
    String getMatchPattern(); // For regular expression
    boolean fileTypeMatchingExtension();

}
