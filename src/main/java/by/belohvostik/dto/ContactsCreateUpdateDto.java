package by.belohvostik.dto;

import by.belohvostik.entity.GenderEntity;
import by.belohvostik.entity.MaritalStatusEntity;

import java.sql.Date;
import java.util.Objects;

public class ContactsCreateUpdateDto {

    private  int id;
    private  String name;
    private  String surname;
    private  String patronymic;
    private Date dateOfBirth;
    private GenderEntity gender;
    private  String citizenShip;
    private MaritalStatusEntity maritalStatus;
    private  String webSite;
    private  String email;
    private  String placeOfWork;
    private  String photoAddress;
    private  String country;
    private  String city;
    private  String street;
    private  int house;
    private  int apartment;
    private  String postcode;

    public ContactsCreateUpdateDto(String name, String surname, String patronymic, Date dateOfBirth, GenderEntity gender, String citizenShip, MaritalStatusEntity maritalStatus, String webSite, String email, String placeOfWork, String photoAddress, String country, String city, String street, int house, int apartment, String postcode) {
    }

    public ContactsCreateUpdateDto(int id, String name, String surname, String patronymic, Date dateOfBirth, GenderEntity gender, String citizenShip,
                                   MaritalStatusEntity maritalStatus, String webSite, String email, String placeOfWork, String photoAddress,
                                   String country, String city, String street, int house, int apartment, String postcode) {
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
        this.photoAddress = photoAddress;
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.postcode = postcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public GenderEntity getGender() {
        return gender;
    }

    public void setGender(GenderEntity gender) {
        this.gender = gender;
    }

    public String getCitizenShip() {
        return citizenShip;
    }

    public void setCitizenShip(String citizenShip) {
        this.citizenShip = citizenShip;
    }

    public MaritalStatusEntity getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatusEntity maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public String getPhotoAddress() {
        return photoAddress;
    }

    public void setPhotoAddress(String photoAddress) {
        this.photoAddress = photoAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactsCreateUpdateDto that = (ContactsCreateUpdateDto) o;
        return id == that.id && house == that.house && apartment == that.apartment && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(patronymic, that.patronymic) && Objects.equals(dateOfBirth, that.dateOfBirth) && gender == that.gender && Objects.equals(citizenShip, that.citizenShip) && maritalStatus == that.maritalStatus && Objects.equals(webSite, that.webSite) && Objects.equals(email, that.email) && Objects.equals(placeOfWork, that.placeOfWork) && Objects.equals(photoAddress, that.photoAddress) && Objects.equals(country, that.country) && Objects.equals(city, that.city) && Objects.equals(street, that.street) && Objects.equals(postcode, that.postcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, patronymic, dateOfBirth, gender, citizenShip, maritalStatus, webSite, email, placeOfWork, photoAddress, country, city, street, house, apartment, postcode);
    }

    @Override
    public String toString() {
        return "ContactsCreateDto{" +
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
                '}';
    }
}
