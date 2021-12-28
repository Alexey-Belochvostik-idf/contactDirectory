package by.belohvostik.dao.Listphonesdao;

import by.belohvostik.dto.ListPhonesDto;
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

    static final String UPDATE = "update editingPhones set codeOfCountry = ?, codeOperation = ?, phoneNumber = ?, typePhone = ?, commit = ? where id = ?";

    static final String READ = "select * from editingPhones ";

    static final String DELETE = "delete from editingPhones where id = ?";


    @Override
    public void update(ListPhonesEntity listPhonesEntity) {

        initDriver();

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement st = con.prepareStatement(UPDATE)) {

            st.setInt(1, listPhonesEntity.getCodeOfCountry());
            st.setInt(2, listPhonesEntity.getCodeOperation());
            st.setInt(3, listPhonesEntity.getPhoneNumber());
            st.setString(4, String.valueOf(listPhonesEntity.getTypePhone()));
            st.setString(5, listPhonesEntity.getCommit());
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<ListPhonesDto> read() {

        initDriver();

        ArrayList<ListPhonesDto> list = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement st = con.prepareStatement(READ)) {

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ListPhonesDto editingPhonesEntity = new ListPhonesDto(rs.getInt("id"), rs.getInt("codeOfCountry"), rs.getInt("codeOperation"),
                        rs.getInt("phoneNumber"), TypePhone.valueOf(rs.getString("typePhone")), rs.getString("commit"));
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
}
