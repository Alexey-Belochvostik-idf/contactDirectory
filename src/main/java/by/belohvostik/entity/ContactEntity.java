package by.belohvostik.entity;

import by.belohvostik.dto.contactsdto.ContactsDto;

import java.sql.Date;
import java.util.Objects;

public class ContactEntity {

    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private Date dateOfBirth;
    private GenderEntity gender;
    private String citizenShip;
    private MaritalStatusEntity maritalStatus;
    private String webSite;
    private String email;
    private String placeOfWork;
    private String photoAddress;
    private String country;
    private String city;
    private String street;
    private int house;
    private int apartment;
    private String postcode;

    private ListPhonesEntity listPhones;
    private AttachmentsEntity attachments;

    public ContactEntity(ContactsDto contactsDto) {
        name = contactsDto.getName();
        surname = contactsDto.getSurname();
        patronymic = contactsDto.getPatronymic();
        dateOfBirth = contactsDto.getDateOfBirth();
        gender = contactsDto.getGender();
        citizenShip = contactsDto.getCitizenShip();
        maritalStatus = contactsDto.getMaritalStatus();
        webSite = contactsDto.getWebSite();
        email = contactsDto.getEmail();
        placeOfWork = contactsDto.getPlaceOfWork();
        photoAddress = contactsDto.getPhotoAddress();
        country = contactsDto.getCountry();
        city = contactsDto.getCity();
        street = contactsDto.getStreet();
        house = contactsDto.getHouse();
        apartment = contactsDto.getApartment();
        postcode = contactsDto.getPostcode();
        listPhones = contactsDto.getListPhones();
        attachments = contactsDto.getAttachments();

    }

    public ContactEntity(int id, ContactsDto contactsDto) {
        this.id = id;
        name = contactsDto.getName();
        surname = contactsDto.getSurname();
        patronymic = contactsDto.getPatronymic();
        dateOfBirth = contactsDto.getDateOfBirth();
        gender = contactsDto.getGender();
        citizenShip = contactsDto.getCitizenShip();
        maritalStatus = contactsDto.getMaritalStatus();
        webSite = contactsDto.getWebSite();
        email = contactsDto.getEmail();
        placeOfWork = contactsDto.getPlaceOfWork();
        photoAddress = contactsDto.getPhotoAddress();
        country = contactsDto.getCountry();
        city = contactsDto.getCity();
        street = contactsDto.getStreet();
        house = contactsDto.getHouse();
        apartment = contactsDto.getApartment();
        postcode = contactsDto.getPostcode();
        listPhones = contactsDto.getListPhones();
        attachments = contactsDto.getAttachments();

    }

    public ContactEntity() {
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

    public ListPhonesEntity getListPhones() {
        return listPhones;
    }

    public AttachmentsEntity getAttachments() {
        return attachments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactEntity that = (ContactEntity) o;
        return id == that.id && house == that.house && apartment == that.apartment && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(patronymic, that.patronymic) && Objects.equals(dateOfBirth, that.dateOfBirth) && gender == that.gender && Objects.equals(citizenShip, that.citizenShip) && maritalStatus == that.maritalStatus && Objects.equals(webSite, that.webSite) && Objects.equals(email, that.email) && Objects.equals(placeOfWork, that.placeOfWork) && Objects.equals(photoAddress, that.photoAddress) && Objects.equals(country, that.country) && Objects.equals(city, that.city) && Objects.equals(street, that.street) && Objects.equals(postcode, that.postcode) && Objects.equals(listPhones, that.listPhones) && Objects.equals(attachments, that.attachments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, patronymic, dateOfBirth, gender, citizenShip, maritalStatus, webSite, email, placeOfWork, photoAddress, country, city, street, house, apartment, postcode, listPhones, attachments);
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
                ", postcode='" + postcode + '\'' +
                ", listPhones=" + listPhones +
                ", attachments=" + attachments +
                '}';
    }
}
