package by.belohvostik.dto;


import java.util.Objects;

public class ContactDto {

    private final int id;
    private final String name;
    private final String surname;
    private final String patronymic;
    private final String dateOfBirth;
    private final String country;
    private final String city;
    private final String street;
    private final int house;
    private final int apartment;
    private final String placeOfWork;

    public ContactDto(int id, String name, String surname, String patronymic, String dateOfBirth, String country, String city, String street, int house, int apartment, String placeOfWork) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.placeOfWork = placeOfWork;
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


    public String getDateOfBirth() {
        return dateOfBirth;
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


    public String getPlaceOfWork() {
        return placeOfWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactDto that = (ContactDto) o;
        return id == that.id && house == that.house && apartment == that.apartment && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(patronymic, that.patronymic) && Objects.equals(dateOfBirth, that.dateOfBirth) && Objects.equals(country, that.country) && Objects.equals(city, that.city) && Objects.equals(street, that.street) && Objects.equals(placeOfWork, that.placeOfWork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, patronymic, dateOfBirth, country, city, street, house, apartment, placeOfWork);
    }

    @Override
    public String toString() {
        return "ContactDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", apartment=" + apartment +
                ", placeOfWork='" + placeOfWork + '\'' +
                '}';
    }
}

