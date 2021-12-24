package by.belohvostik.entity;

import java.util.Objects;

public class EditingPhonesEntity {

    private int id;
    private int codeOfCountry;
    private int codeOperation;
    private int phoneNumber;
    private TypePhone typePhone;
    private String commit;

    public EditingPhonesEntity() {
    }

    public EditingPhonesEntity(int id, int codeOfCountry, int codeOperation, int phoneNumber, TypePhone typePhone, String commit) {
        this.id = id;
        this.codeOfCountry = codeOfCountry;
        this.codeOperation = codeOperation;
        this.phoneNumber = phoneNumber;
        this.typePhone = typePhone;
        this.commit = commit;
    }

    public int getId() {
        return id;
    }

    public int getCodeOfCountry() {
        return codeOfCountry;
    }

    public int getCodeOperation() {
        return codeOperation;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public TypePhone getTypePhone() {
        return typePhone;
    }

    public String getCommit() {
        return commit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditingPhonesEntity that = (EditingPhonesEntity) o;
        return id == that.id && codeOfCountry == that.codeOfCountry && codeOperation == that.codeOperation && phoneNumber == that.phoneNumber && typePhone == that.typePhone && Objects.equals(commit, that.commit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codeOfCountry, codeOperation, phoneNumber, typePhone, commit);
    }

    @Override
    public String toString() {
        return "EditingPhones{" +
                "id=" + id +
                ", codeOfCountry=" + codeOfCountry +
                ", codeOperation=" + codeOperation +
                ", phoneNumber=" + phoneNumber +
                ", typePhone=" + typePhone +
                ", commit='" + commit + '\'' +
                '}';
    }
}
