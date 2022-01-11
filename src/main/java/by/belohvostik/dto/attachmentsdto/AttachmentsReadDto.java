package by.belohvostik.dto.attachmentsdto;

import java.util.Objects;

public class AttachmentsReadDto {

    private  final  String fileName;
    private  final String dateOfDownload;
    private  final  String commit;

    public AttachmentsReadDto( String fileName, String dateOfDownload, String commit) {
        this.fileName = fileName;
        this.dateOfDownload = dateOfDownload;
        this.commit = commit;
    }


    public String getFileName() {
        return fileName;
    }

    public String getDateOfDownload() {
        return dateOfDownload;
    }

    public String getCommit() {
        return commit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttachmentsReadDto that = (AttachmentsReadDto) o;
        return Objects.equals(fileName, that.fileName) && Objects.equals(dateOfDownload, that.dateOfDownload) && Objects.equals(commit, that.commit);
    }

    @Override
    public int hashCode() {
        return Objects.hash( fileName, dateOfDownload, commit);
    }

    @Override
    public String toString() {
        return "Attachments{" +
                ", fileName='" + fileName + '\'' +
                ", dateOfDownload=" + dateOfDownload +
                ", commit='" + commit + '\'' +
                '}';
    }
}
