package by.belohvostik.dto;

import by.belohvostik.entity.TypePhone;

import java.util.Objects;

public class ListPhonesDto {

    private int id;
    private int codeOfCountry;
    private int codeOperation;
    private int phoneNumber;
    private TypePhone typePhone;
    private String commit;

    public ListPhonesDto() {
    }

    public ListPhonesDto(int id, int codeOfCountry, int codeOperation, int phoneNumber, TypePhone typePhone, String commit) {
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

    public void setId(int id) {
        this.id = id;
    }

    public int getCodeOfCountry() {
        return codeOfCountry;
    }

    public void setCodeOfCountry(int codeOfCountry) {
        this.codeOfCountry = codeOfCountry;
    }

    public int getCodeOperation() {
        return codeOperation;
    }

    public void setCodeOperation(int codeOperation) {
        this.codeOperation = codeOperation;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public TypePhone getTypePhone() {
        return typePhone;
    }

    public void setTypePhone(TypePhone typePhone) {
        this.typePhone = typePhone;
    }

    public String getCommit() {
        return commit;
    }

    public void setCommit(String commit) {
        this.commit = commit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListPhonesDto that = (ListPhonesDto) o;
        return id == that.id && codeOfCountry == that.codeOfCountry && codeOperation == that.codeOperation && phoneNumber == that.phoneNumber && typePhone == that.typePhone && Objects.equals(commit, that.commit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codeOfCountry, codeOperation, phoneNumber, typePhone, commit);
    }

    @Override
    public String toString() {
        return "ListPhoneDto{" +
                "id=" + id +
                ", codeOfCountry=" + codeOfCountry +
                ", codeOperation=" + codeOperation +
                ", phoneNumber=" + phoneNumber +
                ", typePhone=" + typePhone +
                ", commit='" + commit + '\'' +
                '}';
    }
}
