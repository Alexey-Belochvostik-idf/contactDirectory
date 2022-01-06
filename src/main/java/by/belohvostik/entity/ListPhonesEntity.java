package by.belohvostik.entity;

import by.belohvostik.dto.listphonesdto.ListPhoneDto;

import java.util.Objects;

public class ListPhonesEntity {

    private final int codeOfCountry;
    private final int codeOperation;
    private final int phoneNumber;
    private final TypePhone typePhone;
    private final String commit;

    public ListPhonesEntity(ListPhoneDto listPhonesDto) {
        codeOfCountry = listPhonesDto.getCodeOfCountry();
        codeOperation = listPhonesDto.getCodeOperation();
        phoneNumber = listPhonesDto.getPhoneNumber();
        typePhone = listPhonesDto.getTypePhone();
        commit = listPhonesDto.getCommit();

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
        ListPhonesEntity that = (ListPhonesEntity) o;
        return codeOfCountry == that.codeOfCountry && codeOperation == that.codeOperation && phoneNumber == that.phoneNumber && typePhone == that.typePhone && Objects.equals(commit, that.commit);
    }

    @Override
    public int hashCode() {
        return Objects.hash( codeOfCountry, codeOperation, phoneNumber, typePhone, commit);
    }

    @Override
    public String toString() {
        return "ListPhoneDto{" +
                ", codeOfCountry=" + codeOfCountry +
                ", codeOperation=" + codeOperation +
                ", phoneNumber=" + phoneNumber +
                ", typePhone=" + typePhone +
                ", commit='" + commit + '\'' +
                '}';
    }
}
