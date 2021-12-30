package by.belohvostik.dto;


import java.util.Objects;

public class ContactsReadDto {

    private final String fullName;
    private final String dateOfBirth;
    private final String  fullAddress;
    private final String placeOfWork;

    public ContactsReadDto(String fullName, String dateOfBirth, String fullAddress, String placeOfWork) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.fullAddress = fullAddress;
        this.placeOfWork = placeOfWork;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactsReadDto that = (ContactsReadDto) o;
        return Objects.equals(fullName, that.fullName) && Objects.equals(dateOfBirth, that.dateOfBirth) && Objects.equals(fullAddress, that.fullAddress) && Objects.equals(placeOfWork, that.placeOfWork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, dateOfBirth, fullAddress, placeOfWork);
    }

    @Override
    public String toString() {
        return "ContactDto{" +
                ", fullName=" + fullName +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", fullAddress=" + fullAddress +
                ", placeOfWork='" + placeOfWork + '\'' +
                '}';
    }
}

