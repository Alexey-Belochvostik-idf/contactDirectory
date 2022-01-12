package by.belohvostik.dao.listphonesdao;

import by.belohvostik.dto.listphonesdto.ListPhoneReadIdDto;
import by.belohvostik.dto.listphonesdto.ListPhonesReadDto;
import by.belohvostik.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListPhonesDaoImpl implements ListPhonesDao {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/sys?serverTimezone=UTC";

    static final String USER = "root";
    static final String PASSWORD = "root";

    static final String READ_ID = "select * from listphones where id = ? ";

    static final String READ = "select * from listphones where contact_id = ? ";

    static final String DELETE = "delete from listphones where id = ?";


    @Override
    public List<ListPhoneReadIdDto> readId(int id) {

        initDriver();

        ArrayList<ListPhoneReadIdDto> list = new ArrayList<>();
        try(Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
        PreparedStatement pst = con.prepareStatement(READ_ID)){

            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){

                ListPhoneReadIdDto listPhoneDto = new ListPhoneReadIdDto(
                        rs.getInt("codeOfCountry"),
                        rs.getInt("codeOperation"),
                        rs.getInt("phoneNumber"),
                        TypePhone.valueOf(rs.getString("typePhone")),
                        rs.getString("commit"));
                list.add(listPhoneDto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<ListPhonesReadDto> read(int contact_id) {

        initDriver();

        ArrayList<ListPhonesReadDto> list = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(READ)) {

            pst.setInt(1,contact_id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                ListPhonesReadDto editingPhonesEntity = new ListPhonesReadDto(
                        String.join("-", String.valueOf(rs.getInt("codeOfCountry")), String.valueOf(rs.getInt("codeOperation")), String.valueOf(rs.getInt("phoneNumber"))),
                        TypePhone.valueOf(rs.getString("typePhone")),
                        rs.getString("commit"));
                list.add(editingPhonesEntity);
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
}
