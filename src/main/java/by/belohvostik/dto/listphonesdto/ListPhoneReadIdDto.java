package by.belohvostik.dto.listphonesdto;

import by.belohvostik.entity.TypePhoneEnum;

import java.util.Objects;

public class ListPhoneReadIdDto {

    private final int codeOfCountry;
    private final int codeOperation;
    private final int phoneNumber;
    private final TypePhoneEnum typePhone;
    private final String comment;

    public ListPhoneReadIdDto(int codeOfCountry, int codeOperation, int phoneNumber, TypePhoneEnum typePhone, String commit) {
        this.codeOfCountry = codeOfCountry;
        this.codeOperation = codeOperation;
        this.phoneNumber = phoneNumber;
        this.typePhone = typePhone;
        this.comment = commit;
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

    public TypePhoneEnum getTypePhone() {
        return typePhone;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListPhoneReadIdDto that = (ListPhoneReadIdDto) o;
        return codeOfCountry == that.codeOfCountry && codeOperation == that.codeOperation && phoneNumber == that.phoneNumber && typePhone == that.typePhone && Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash( codeOfCountry, codeOperation, phoneNumber, typePhone, comment);
    }

    @Override
    public String toString() {
        return "ListPhoneDto{" +
                ", codeOfCountry=" + codeOfCountry +
                ", codeOperation=" + codeOperation +
                ", phoneNumber=" + phoneNumber +
                ", typePhone=" + typePhone +
                ", commit='" + comment + '\'' +
                '}';
    }
}
