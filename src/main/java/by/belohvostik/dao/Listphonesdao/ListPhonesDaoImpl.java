package by.belohvostik.dao.Listphonesdao;

import by.belohvostik.dto.ListPhonesReadDto;
import by.belohvostik.entity.ListPhonesEntity;
import by.belohvostik.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListPhonesDaoImpl implements ListPhonesDao {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/sys?serverTimezone=UTC";

    static final String USER = "root";
    static final String PASSWORD = "password";

    static final String UPDATE = "update listPhones set codeOfCountry = ?, codeOperation = ?, phoneNumber = ?, typePhone = ?, commit = ? where id = ?";

    static final String READ = "select * from listPhones ";

    static final String DELETE = "delete from listPhones where id = ?";


    @Override
    public void update(ListPhonesEntity listPhonesEntity) {

        initDriver();

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(UPDATE)) {

            pst.setInt(1, listPhonesEntity.getCodeOfCountry());
            pst.setInt(2, listPhonesEntity.getCodeOperation());
            pst.setInt(3, listPhonesEntity.getPhoneNumber());
            pst.setString(4, String.valueOf(listPhonesEntity.getTypePhone()));
            pst.setString(5, listPhonesEntity.getCommit());
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<ListPhonesReadDto> read() {

        initDriver();

        ArrayList<ListPhonesReadDto> list = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(READ)) {

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                ListPhonesReadDto editingPhonesEntity = new ListPhonesReadDto(
                        rs.getInt("id"),
                        String.join("-", String.valueOf(rs.getInt("codeOfCountry")), String.valueOf(rs.getInt("codeOperation")),
                        String.valueOf(rs.getInt("phoneNumber"))),
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
