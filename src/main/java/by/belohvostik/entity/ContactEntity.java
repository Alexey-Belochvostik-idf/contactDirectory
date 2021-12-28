package by.belohvostik.entity;

import by.belohvostik.dto.ContactsCreateUpdateDto;

import java.sql.Date;
import java.util.Objects;

public class ContactEntity {

    private int id;
    private final String name;
    private final String surname;
    private final String patronymic;
    private final Date dateOfBirth;
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

    public ContactEntity(ContactsCreateUpdateDto contactsCreateUpdateDto) {
        name = contactsCreateUpdateDto.getName();
        surname = contactsCreateUpdateDto.getSurname();
        patronymic = contactsCreateUpdateDto.getPatronymic();
        dateOfBirth = contactsCreateUpdateDto.getDateOfBirth();
        gender = contactsCreateUpdateDto.getGender();
        citizenShip = contactsCreateUpdateDto.getCitizenShip();
        maritalStatus = contactsCreateUpdateDto.getMaritalStatus();
        webSite = contactsCreateUpdateDto.getWebSite();
        email = contactsCreateUpdateDto.getEmail();
        placeOfWork = contactsCreateUpdateDto.getPlaceOfWork();
        photoAddress = contactsCreateUpdateDto.getPhotoAddress();
        country = contactsCreateUpdateDto.getCountry();
        city = contactsCreateUpdateDto.getCity();
        street = contactsCreateUpdateDto.getStreet();
        house = contactsCreateUpdateDto.getHouse();
        apartment = contactsCreateUpdateDto.getApartment();
        postcode = contactsCreateUpdateDto.getPostcode();

    }

    public ContactEntity(int id, ContactsCreateUpdateDto contactsCreateUpdateDto) {
        this.id = id;
        name = contactsCreateUpdateDto.getName();
        surname = contactsCreateUpdateDto.getSurname();
        patronymic = contactsCreateUpdateDto.getPatronymic();
        dateOfBirth = contactsCreateUpdateDto.getDateOfBirth();
        gender = contactsCreateUpdateDto.getGender();
        citizenShip = contactsCreateUpdateDto.getCitizenShip();
        maritalStatus = contactsCreateUpdateDto.getMaritalStatus();
        webSite = contactsCreateUpdateDto.getWebSite();
        email = contactsCreateUpdateDto.getEmail();
        placeOfWork = contactsCreateUpdateDto.getPlaceOfWork();
        photoAddress = contactsCreateUpdateDto.getPhotoAddress();
        country = contactsCreateUpdateDto.getCountry();
        city = contactsCreateUpdateDto.getCity();
        street = contactsCreateUpdateDto.getStreet();
        house = contactsCreateUpdateDto.getHouse();
        apartment = contactsCreateUpdateDto.getApartment();
        postcode = contactsCreateUpdateDto.getPostcode();
    }


    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return id;
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

    public Date getDateOfBirth() {
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
        ContactEntity that = (ContactEntity) o;
        return id == that.id && house == that.house && apartment == that.apartment && Objects.equals(postcode, that.postcode) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(patronymic, that.patronymic) && Objects.equals(dateOfBirth, that.dateOfBirth) && gender == that.gender && Objects.equals(citizenShip, that.citizenShip) && Objects.equals(maritalStatus, that.maritalStatus) && Objects.equals(webSite, that.webSite) && Objects.equals(email, that.email) && Objects.equals(placeOfWork, that.placeOfWork) && Objects.equals(photoAddress, that.photoAddress) && Objects.equals(country, that.country) && Objects.equals(city, that.city) && Objects.equals(street, that.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, patronymic, dateOfBirth, gender, citizenShip, maritalStatus, webSite, email, placeOfWork, photoAddress, country, city, street, house, apartment, postcode);
    }

    @Override
    public String toString() {
        return "ContactEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth=" + dateOfBirth +
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
                ", postcode=" + postcode +
                '}';
    }
}
