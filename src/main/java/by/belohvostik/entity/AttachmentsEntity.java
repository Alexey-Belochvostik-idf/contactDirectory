package by.belohvostik.entity;

import by.belohvostik.dto.attachmentsdto.AttachmentsReadDto;

import java.util.Objects;

public class AttachmentsEntity {

    private String fileName;
    private String data;
    private String comment;
    private int contact_id;

    public AttachmentsEntity(AttachmentsReadDto attachmentsDto, int contact_id) {
        fileName = attachmentsDto.getFileName();
        comment = attachmentsDto.getComment();
    }

    public AttachmentsEntity() {
    }

    public String getFileName() {
        return fileName;
    }

    public String getData() {
        return data;
    }

    public String getComment() {
        return comment;
    }

    public int getContact_id() {
        return contact_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttachmentsEntity that = (AttachmentsEntity) o;
        return contact_id == that.contact_id && Objects.equals(fileName, that.fileName) && Objects.equals(data, that.data) && Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, data, comment, contact_id);
    }

    @Override
    public String toString() {
        return "AttachmentsEntity{" +
                "fileName='" + fileName + '\'' +
                ", data='" + data + '\'' +
                ", comment='" + comment + '\'' +
                ", contact_id=" + contact_id +
                '}';
    }
}
