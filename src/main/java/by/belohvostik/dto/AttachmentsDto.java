package by.belohvostik.dto;

public class AttachmentsDto {

    private String fileName;

    private String commit;

    public AttachmentsDto() {
    }

    public AttachmentsDto(String fileName, String commit) {
        this.fileName = fileName;
        this.commit = commit;
    }

    public String getFileName() {
        return fileName;
    }

    public String getCommit() {
        return commit;
    }
}
