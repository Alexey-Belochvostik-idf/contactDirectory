package by.belohvostik.dao.contactsdao;

import by.belohvostik.dto.ContactDto;
import by.belohvostik.entity.ContactEntity;
import by.belohvostik.entity.ContactPhotoAddress;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactsDaoImpl implements ContactsDao {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/sys?serverTimezone=UTC";

    static final String USER = "root";
    static final String PASSWORD = "password";

    static final String CREATE = "insert into contacts (name, surname, patronymic, dateOfBirth, gender, citizenShip, maritalStatus, webSite, " +
            "email, placeOfWork, photoAddress, country, city, street, house, apartment, postcode) values ( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    static final String UPDATE = "update contacts set  name = ? ,surname = ?, patronymic = ?, dateOfBirth = ?, gender = ?, citizenShip = ?, " +
            "maritalStatus = ?, webSite = ?, email = ?, placeOfWork = ?, photoAddress = ?, country = ?, city = ?, street = ?, " +
            "house = ?, apartment = ?, postcode = ? where id = ?";

    static final String DELETE = "delete from contacts where id = ?";

    static final String READ_ID = "select * from contacts where id = ?";

    static final String READ = "select * from contacts ";

    @Override
    public void create(ContactEntity contactEntity) {

        initDriver();

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement st = con.prepareStatement(CREATE,PreparedStatement.RETURN_GENERATED_KEYS)) {

            st.setString(1, contactEntity.getName());
            st.setString(2, contactEntity.getSurname());
            st.setString(3, contactEntity.getPatronymic());
            st.setDate(4, new Date(contactEntity.getDateOfBirth().getTime()));
            st.setString(5, String.valueOf(contactEntity.getGender()));
            st.setString(6, contactEntity.getCitizenShip());
            st.setString(7, String.valueOf(contactEntity.getMaritalStatus()));
            st.setString(8, contactEntity.getWebSite());
            st.setString(9, contactEntity.getEmail());
            st.setString(10, contactEntity.getPlaceOfWork());
            st.setString(11, contactEntity.getPhotoAddress());
            st.setString(12, contactEntity.getCountry());
            st.setString(13, contactEntity.getCity());
            st.setString(14, contactEntity.getStreet());
            st.setInt(15, contactEntity.getHouse());
            st.setInt(16, contactEntity.getApartment());
            st.setString(17, contactEntity.getPostcode());
            st.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(ContactEntity contactEntity) {

       initDriver();

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement st = con.prepareStatement(UPDATE)) {

            st.setInt(18, contactEntity.getId());
            st.setString(1, contactEntity.getName());
            st.setString(2, contactEntity.getSurname());
            st.setString(3, contactEntity.getPatronymic());
            st.setDate(4, new Date(contactEntity.getDateOfBirth().getTime()));
            st.setString(5, String.valueOf(contactEntity.getGender()));
            st.setString(6, contactEntity.getCitizenShip());
            st.setString(7, String.valueOf(contactEntity.getMaritalStatus()));
            st.setString(8, contactEntity.getWebSite());
            st.setString(9, contactEntity.getEmail());
            st.setString(10, contactEntity.getPlaceOfWork());
            st.setString(11, contactEntity.getPhotoAddress());
            st.setString(12, contactEntity.getCountry());
            st.setString(13, contactEntity.getCity());
            st.setString(14, contactEntity.getStreet());
            st.setInt(15, contactEntity.getHouse());
            st.setInt(16, contactEntity.getApartment());
            st.setString(17, contactEntity.getPostcode());
            st.executeUpdate();

        } catch (
                SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<ContactDto> readId(int id) {

        initDriver();

        ArrayList<ContactDto> list = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement st = con.prepareStatement(READ_ID)) {

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ContactDto contactDto = new ContactDto(rs.getInt("id"), rs.getString("name"), rs.getString("surname"),
                        rs.getString("patronymic"), rs.getString("dateOfBirth"), rs.getString("country"),
                        rs.getString("city"), rs.getString("street"), rs.getInt("house"),
                        rs.getInt("apartment"), rs.getString("placeOfWork"));
                list.add(contactDto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<ContactDto> read() {

        initDriver();

        ArrayList<ContactDto> list = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement st = con.prepareStatement(READ)) {

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ContactDto contactDto = new ContactDto(rs.getInt("id"), rs.getString("name"), rs.getString("surname"),
                        rs.getString("patronymic"), rs.getString("dateOfBirth"), rs.getString("country"),
                        rs.getString("city"), rs.getString("street"), rs.getInt("house"),
                        rs.getInt("apartment"), rs.getString("placeOfWork"));
                list.add(contactDto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void delete(int id) {

        initDriver();

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement st = con.prepareStatement(DELETE)) {
            st.setInt(1, id);
            st.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void initDriver() {

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addPhotoAddress(ContactPhotoAddress contactPhotoAddressEntity) {

       initDriver();

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement st = con.prepareStatement("insert into contacts ( photoAddress) values (" +
                     "'" + Arrays.toString(contactPhotoAddressEntity.getPhotoAddress()) + "'," + ")")) {

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
