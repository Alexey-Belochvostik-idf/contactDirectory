package by.belohvostik.entity;

import by.belohvostik.dto.listphonesdto.ListPhoneReadIdDto;

import java.util.Objects;

public class ListPhonesEntity {

    private  int codeOfCountry;
    private  int codeOperation;
    private  int phoneNumber;
    private TypePhoneEnum typePhone;
    private  String comment;
    private int contact_id;

    public ListPhonesEntity(ListPhoneReadIdDto listPhonesDto) {
        codeOfCountry = listPhonesDto.getCodeOfCountry();
        codeOperation = listPhonesDto.getCodeOperation();
        phoneNumber = listPhonesDto.getPhoneNumber();
        typePhone = listPhonesDto.getTypePhone();
        comment = listPhonesDto.getComment();

    }

    public ListPhonesEntity() {
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

    public int getContact_id() {
        return contact_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListPhonesEntity that = (ListPhonesEntity) o;
        return codeOfCountry == that.codeOfCountry && codeOperation == that.codeOperation && phoneNumber == that.phoneNumber && contact_id == that.contact_id && typePhone == that.typePhone && Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeOfCountry, codeOperation, phoneNumber, typePhone, comment, contact_id);
    }

    @Override
    public String toString() {
        return "ListPhonesEntity{" +
                "codeOfCountry=" + codeOfCountry +
                ", codeOperation=" + codeOperation +
                ", phoneNumber=" + phoneNumber +
                ", typePhone=" + typePhone +
                ", commit='" + comment + '\'' +
                ", contact_id=" + contact_id +
                '}';
    }
}
