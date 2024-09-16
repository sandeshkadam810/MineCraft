public class FileinModel {
    private String filename;
    private String fileurl;

    public FileinModel() {
        // Default constructor required for calls to DataSnapshot.getValue(FileinModel.class)
    }

    public FileinModel(String filename, String fileurl) {
        this.filename = filename;
        this.fileurl = fileurl;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }
}
