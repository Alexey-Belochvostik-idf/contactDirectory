package by.belohvostik.dto.contactsdto;

import by.belohvostik.entity.GenderEntity;
import by.belohvostik.entity.MaritalStatusEntity;

import java.util.Objects;

public class ContactsReadIdDto {

    private final String name;
    private final String surname;
    private final String patronymic;
    private final String dateOfBirth;
    private final GenderEntity gender;
    private final String citizenShip;
    private final MaritalStatusEntity maritalStatus;
    private final String webSite;
    private final String email;
    private final String placeOfWork;
    private final String photoAddress;
    private final String country;
    private final String city;
    private final String street;
    private final int house;
    private final int apartment;
    private final String postcode;

    public ContactsReadIdDto(String name, String surname, String patronymic, String dateOfBirth, GenderEntity gender, String citizenShip, MaritalStatusEntity maritalStatus, String webSite, String email, String placeOfWork, String photoAddress, String country, String city, String street, int house, int apartment, String postcode) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.citizenShip = citizenShip;
        this.maritalStatus = maritalStatus;
        this.webSite = webSite;
        this.email = email;
        this.placeOfWork = placeOfWork;
        this.photoAddress = photoAddress;
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.postcode = postcode;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public GenderEntity getGender() {
        return gender;
    }

    public String getCitizenShip() {
        return citizenShip;
    }

    public MaritalStatusEntity getMaritalStatus() {
        return maritalStatus;
    }

    public String getWebSite() {
        return webSite;
    }

    public String getEmail() {
        return email;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public String getPhotoAddress() {
        return photoAddress;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHouse() {
        return house;
    }

    public int getApartment() {
        return apartment;
    }

    public String getPostcode() {
        return postcode;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactsReadIdDto that = (ContactsReadIdDto) o;
        return house == that.house && apartment == that.apartment && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(patronymic, that.patronymic) && Objects.equals(dateOfBirth, that.dateOfBirth) && gender == that.gender && Objects.equals(citizenShip, that.citizenShip) && maritalStatus == that.maritalStatus && Objects.equals(webSite, that.webSite) && Objects.equals(email, that.email) && Objects.equals(placeOfWork, that.placeOfWork) && Objects.equals(photoAddress, that.photoAddress) && Objects.equals(country, that.country) && Objects.equals(city, that.city) && Objects.equals(street, that.street) && Objects.equals(postcode, that.postcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, patronymic, dateOfBirth, gender, citizenShip, maritalStatus, webSite, email, placeOfWork, photoAddress, country, city, street, house, apartment, postcode);
    }

    @Override
    public String toString() {
        return "ContactsReadIdDto{" +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender=" + gender +
                ", citizenShip='" + citizenShip + '\'' +
                ", maritalStatus=" + maritalStatus +
                ", webSite='" + webSite + '\'' +
                ", email='" + email + '\'' +
                ", placeOfWork='" + placeOfWork + '\'' +
                ", photoAddress='" + photoAddress + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", apartment=" + apartment +
                ", postcode='" + postcode + '\'' +
                '}';
    }
}
