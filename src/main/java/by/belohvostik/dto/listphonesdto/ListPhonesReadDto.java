package by.belohvostik.dto.listphonesdto;

import by.belohvostik.entity.TypePhoneEnum;

import java.util.Objects;

public class ListPhonesReadDto {

    private final String fullPhoneNumber;
    private final TypePhoneEnum typePhone;
    private final String commit;

    public ListPhonesReadDto(String fullPhoneNumber, TypePhoneEnum typePhone, String commit) {
        this.fullPhoneNumber = fullPhoneNumber;
        this.typePhone = typePhone;
        this.commit = commit;
    }

    public String getFullPhoneNumber() {
        return fullPhoneNumber;
    }

    public TypePhoneEnum getTypePhone() {
        return typePhone;
    }

    public String getCommit() {
        return commit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListPhonesReadDto that = (ListPhonesReadDto) o;
        return  Objects.equals(fullPhoneNumber, that.fullPhoneNumber) && typePhone == that.typePhone && Objects.equals(commit, that.commit);
    }

    @Override
    public int hashCode() {
        return Objects.hash( fullPhoneNumber, typePhone, commit);
    }

    @Override
    public String toString() {
        return "ListPhonesDto{" +
                ", fullPhoneNumber='" + fullPhoneNumber + '\'' +
                ", typePhone=" + typePhone +
                ", commit='" + commit + '\'' +
                '}';
    }
}
