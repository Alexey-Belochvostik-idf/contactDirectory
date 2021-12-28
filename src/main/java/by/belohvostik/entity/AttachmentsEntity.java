package by.belohvostik.entity;

import by.belohvostik.dto.AttachmentsDto;

import java.util.Objects;

public class AttachmentsEntity {

    private final String fileName;

    private final String commit;

    public AttachmentsEntity(AttachmentsDto attachmentsDto) {
        fileName = attachmentsDto.getFileName();
        commit = attachmentsDto.getCommit();

    }

    public String getFileName() {
        return fileName;
    }

    public String getCommit() {
        return commit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttachmentsEntity that = (AttachmentsEntity) o;
        return Objects.equals(fileName, that.fileName) && Objects.equals(commit, that.commit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, commit);
    }

    @Override
    public String toString() {
        return "AttachmentsDto{" +
                "fileName='" + fileName + '\'' +
                ", commit='" + commit + '\'' +
                '}';
    }
}
