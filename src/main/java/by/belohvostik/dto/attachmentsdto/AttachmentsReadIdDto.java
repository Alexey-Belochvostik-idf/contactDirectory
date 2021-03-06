package by.belohvostik.dto.attachmentsdto;

import java.util.Objects;

public class AttachmentsReadIdDto {

    private  final  String fileName;
    private  final  String comment;

    public AttachmentsReadIdDto(String fileName, String commit) {
        this.fileName = fileName;
        this.comment = commit;
    }

    public String getFileName() {
        return fileName;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttachmentsReadIdDto that = (AttachmentsReadIdDto) o;
        return Objects.equals(fileName, that.fileName) && Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, comment);
    }

    @Override
    public String toString() {
        return "AttachmentsDto{" +
                "fileName='" + fileName + '\'' +
                ", commit='" + comment + '\'' +
                '}';
    }
}
