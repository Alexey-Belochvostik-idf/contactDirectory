package by.belohvostik.dto;

import java.util.Objects;

public class FullAddressDto {

    private final String country;
    private final String city ;
    private final String street;
    private final String house;
    private final String apartment;

    public FullAddressDto(String country, String city, String street, String house, String apartment) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
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

    public String getHouse() {
        return house;
    }

    public String getApartment() {
        return apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullAddressDto that = (FullAddressDto) o;
        return Objects.equals(house, that.house) && Objects.equals(apartment, that.apartment) && Objects.equals(country, that.country) && Objects.equals(city, that.city) && Objects.equals(street, that.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, street, house, apartment);
    }

    @Override
    public String toString() {
        return "FullAddressDto{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", apartment=" + apartment +
                '}';
    }
}
