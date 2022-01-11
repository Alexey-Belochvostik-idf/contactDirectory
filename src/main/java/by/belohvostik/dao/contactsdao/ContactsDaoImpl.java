package by.belohvostik.dao.contactsdao;

import by.belohvostik.dto.contactsdto.ContactsReadDto;
import by.belohvostik.dto.contactsdto.ContactsReadIdDto;
import by.belohvostik.entity.ContactEntity;
import by.belohvostik.entity.ContactPhotoAddress;
import by.belohvostik.entity.GenderEntity;
import by.belohvostik.entity.MaritalStatusEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactsDaoImpl implements ContactsDao {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/sys?serverTimezone=UTC";

    static final String USER = "root";
    static final String PASSWORD = "root";

    static final String CREATE = "insert into contacts (name, surname, patronymic, dateOfBirth, gender, citizenShip, maritalStatus, webSite, " +
            "email, placeOfWork, photoAddress, country, city, street, house, apartment, postcode) values ( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    static final String UPDATE = "update contacts set  name = ? ,surname = ?, patronymic = ?, dateOfBirth = ?, gender = ?, citizenShip = ?, " +
            "maritalStatus = ?, webSite = ?, email = ?, placeOfWork = ?, photoAddress = ?, country = ?, city = ?, street = ?, " +
            "house = ?, apartment = ?, postcode = ? where id = ?";

    static final String DELETE = "delete from contacts where id = ?";

    static final String READ_ID = "select * from contacts where id = ?";

    static final String READ = "select * from contacts ";

    @Override
    public int create(ContactEntity contactEntity) {

        initDriver();

        int idr = 0;

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(CREATE, PreparedStatement.RETURN_GENERATED_KEYS)) {

            pst.setString(1, contactEntity.getName());
            pst.setString(2, contactEntity.getSurname());
            pst.setString(3, contactEntity.getPatronymic());
            pst.setDate(4, new Date(contactEntity.getDateOfBirth().getTime()));
            pst.setString(5, String.valueOf(contactEntity.getGender()));
            pst.setString(6, contactEntity.getCitizenShip());
            pst.setString(7, String.valueOf(contactEntity.getMaritalStatus()));
            pst.setString(8, contactEntity.getWebSite());
            pst.setString(9, contactEntity.getEmail());
            pst.setString(10, contactEntity.getPlaceOfWork());
            pst.setString(11, contactEntity.getPhotoAddress());
            pst.setString(12, contactEntity.getCountry());
            pst.setString(13, contactEntity.getCity());
            pst.setString(14, contactEntity.getStreet());
            pst.setInt(15, contactEntity.getHouse());
            pst.setInt(16, contactEntity.getApartment());
            pst.setString(17, contactEntity.getPostcode());
            pst.executeUpdate();

            try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idr = contactEntity.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idr;
    }

    @Override
    public void update(ContactEntity contactEntity) {

        initDriver();

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(UPDATE)) {

            pst.setInt(18, contactEntity.getId());
            pst.setString(1, contactEntity.getName());
            pst.setString(2, contactEntity.getSurname());
            pst.setString(3, contactEntity.getPatronymic());
            pst.setDate(4, new Date(contactEntity.getDateOfBirth().getTime()));
            pst.setString(5, String.valueOf(contactEntity.getGender()));
            pst.setString(6, contactEntity.getCitizenShip());
            pst.setString(7, String.valueOf(contactEntity.getMaritalStatus()));
            pst.setString(8, contactEntity.getWebSite());
            pst.setString(9, contactEntity.getEmail());
            pst.setString(10, contactEntity.getPlaceOfWork());
            pst.setString(11, contactEntity.getPhotoAddress());
            pst.setString(12, contactEntity.getCountry());
            pst.setString(13, contactEntity.getCity());
            pst.setString(14, contactEntity.getStreet());
            pst.setInt(15, contactEntity.getHouse());
            pst.setInt(16, contactEntity.getApartment());
            pst.setString(17, contactEntity.getPostcode());
            pst.executeUpdate();

        } catch (
                SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<ContactsReadIdDto> readId(int id) {

        initDriver();

        ArrayList<ContactsReadIdDto> list = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(READ_ID)) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ContactsReadIdDto contactDto = new ContactsReadIdDto(rs.getString("name"),rs.getString("surname"),rs.getString("patronymic"),
                        String.valueOf(rs.getDate("dateOfBirth")), GenderEntity.valueOf(rs.getString("gender")),rs.getString("citizenShip"),
                        MaritalStatusEntity.valueOf(rs.getString("maritalStatus")),rs.getString("webSite"),rs.getString("email"),
                        rs.getString("placeOfWork"),
                        rs.getString("photoAddress"),rs.getString("country"),rs.getString("city"),rs.getString("street"),
                        rs.getInt("house"),rs.getInt("apartment"),rs.getString("postcode"));
                list.add(contactDto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<ContactsReadDto> read() {

        initDriver();

        ArrayList<ContactsReadDto> list = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(READ)) {

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                ContactsReadDto contactsReadDto = new ContactsReadDto(
                        String.join(" ", rs.getString("surname"), rs.getString("name"), rs.getString("patronymic")),
                        rs.getString("dateOfBirth"),
                        String.join(" ", rs.getString("country"), rs.getString("city"), rs.getString("street"), String.valueOf(rs.getInt("house")),
                                String.valueOf(rs.getInt("apartment"))),
                        rs.getString("placeOfWork"));
                list.add(contactsReadDto);
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
             PreparedStatement pst = con.prepareStatement(DELETE)) {
            pst.setInt(1, id);
            pst.execute();

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
             PreparedStatement pst = con.prepareStatement("insert into contacts ( photoAddress) values (" +
                     "'" + Arrays.toString(contactPhotoAddressEntity.getPhotoAddress()) + "'," + ")")) {

            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
