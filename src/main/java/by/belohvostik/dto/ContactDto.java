package by.belohvostik.dto;


public class ContactDto {

    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private String dateOfBirth;
    private String country;
    private String city;
    private String street;
    private int house;
    private int apartment;
    private String placeOfWork;

    public ContactDto() {
    }

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


}

