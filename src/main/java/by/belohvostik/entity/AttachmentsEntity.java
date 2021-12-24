package by.belohvostik.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class AttachmentsEntity {

    private  final  int id;
    private  final  String fileName;
    private  final LocalDateTime dateOfDownload;
    private  final  String commit;

    public AttachmentsEntity(int id, String fileName, LocalDateTime dateOfDownload, String commit) {
        this.id = id;
        this.fileName = fileName;
        this.dateOfDownload = dateOfDownload;
        this.commit = commit;
    }

    public int getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public LocalDateTime getDateOfDownload() {
        return dateOfDownload;
    }

    public String getCommit() {
        return commit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttachmentsEntity that = (AttachmentsEntity) o;
        return id == that.id && Objects.equals(fileName, that.fileName) && Objects.equals(dateOfDownload, that.dateOfDownload) && Objects.equals(commit, that.commit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fileName, dateOfDownload, commit);
    }

    @Override
    public String toString() {
        return "Attachments{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", dateOfDownload=" + dateOfDownload +
                ", commit='" + commit + '\'' +
                '}';
    }
}
