package by.belohvostik.dto;

import by.belohvostik.entity.TypePhone;

import java.util.Objects;

public class ListPhonesReadDto {

    private final int id;
    private final String fullPhoneNumber;
    private final TypePhone typePhone;
    private final String commit;

    public ListPhonesReadDto(int id, String fullPhoneNumber, TypePhone typePhone, String commit) {
        this.id = id;
        this.fullPhoneNumber = fullPhoneNumber;
        this.typePhone = typePhone;
        this.commit = commit;
    }

    public int getId() {
        return id;
    }

    public String getFullPhoneNumber() {
        return fullPhoneNumber;
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
        ListPhonesReadDto that = (ListPhonesReadDto) o;
        return id == that.id && Objects.equals(fullPhoneNumber, that.fullPhoneNumber) && typePhone == that.typePhone && Objects.equals(commit, that.commit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullPhoneNumber, typePhone, commit);
    }

    @Override
    public String toString() {
        return "ListPhonesDto{" +
                "id=" + id +
                ", fullPhoneNumber='" + fullPhoneNumber + '\'' +
                ", typePhone=" + typePhone +
                ", commit='" + commit + '\'' +
                '}';
    }
}
