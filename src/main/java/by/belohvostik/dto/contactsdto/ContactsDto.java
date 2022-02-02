package by.belohvostik.dto.contactsdto;

import by.belohvostik.entity.AttachmentsEntity;
import by.belohvostik.entity.GenderEnum;
import by.belohvostik.entity.ListPhonesEntity;
import by.belohvostik.entity.MaritalStatusEnum;

import java.sql.Date;
import java.util.Arrays;
import java.util.Objects;

public class ContactsDto {

    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private Date dateOfBirth;
    private GenderEnum gender;
    private String citizenShip;
    private MaritalStatusEnum maritalStatus;
    private String webSite;
    private String email;
    private String placeOfWork;
    private String country;
    private String city;
    private String street;
    private int house;
    private int apartment;
    private String postcode;

    private ListPhonesEntity[] listPhones;
    private AttachmentsEntity attachments;

    public ContactsDto(int id, String name, String surname, String patronymic, Date dateOfBirth, GenderEnum gender,
                       String citizenShip, MaritalStatusEnum maritalStatus, String webSite, String email,
                       String placeOfWork, String country, String city, String street, int house, int apartment,
                       String postcode, ListPhonesEntity[] listPhones, AttachmentsEntity attachments) {
        this.id = id;
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
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.postcode = postcode;
        this.listPhones = listPhones;
        this.attachments = attachments;
    }

    public ContactsDto() {
    }

    public int getId() {
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

    public GenderEnum getGender() {
        return gender;
    }

    public String getCitizenShip() {
        return citizenShip;
    }

    public MaritalStatusEnum getMaritalStatus() {
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

    public ListPhonesEntity[] getListPhones() {
        return listPhones;
    }

    public AttachmentsEntity getAttachments() {
        return attachments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactsDto that = (ContactsDto) o;
        return id == that.id && house == that.house && apartment == that.apartment && Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) && Objects.equals(patronymic, that.patronymic) &&
                Objects.equals(dateOfBirth, that.dateOfBirth) && gender == that.gender &&
                Objects.equals(citizenShip, that.citizenShip) && maritalStatus == that.maritalStatus &&
                Objects.equals(webSite, that.webSite) && Objects.equals(email, that.email) &&
                Objects.equals(placeOfWork, that.placeOfWork) && Objects.equals(country, that.country) &&
                Objects.equals(city, that.city) && Objects.equals(street, that.street) &&
                Objects.equals(postcode, that.postcode) && Arrays.equals(listPhones, that.listPhones) &&
                Objects.equals(attachments, that.attachments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, patronymic, dateOfBirth, gender, citizenShip, maritalStatus, webSite,
                email, placeOfWork, country, city, street, house, apartment, postcode, Arrays.hashCode(listPhones),
                attachments);
    }

    @Override
    public String toString() {
        return "ContactsDto{" +
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
