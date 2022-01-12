package by.belohvostik.dao.attachmentsdao;

import by.belohvostik.dto.attachmentsdto.AttachmentsReadIdDto;
import by.belohvostik.dto.attachmentsdto.AttachmentsReadDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttachmentsDaoImpl implements AttachmentsDao {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/sys?serverTimezone=UTC";

    static final String USER = "root";
    static final String PASSWORD = "root";

    static final String READ_ID = "select * from attachments where id = ? ";

    static final String READ = "select * from attachments where contact_id = ?";

    static final String DELETE = "delete from attachments where id = ?";

    @Override
    public List<AttachmentsReadIdDto> readId(int id) {

        initDriver();

        ArrayList<AttachmentsReadIdDto> list = new ArrayList<>();
        try(Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
        PreparedStatement pst = con.prepareStatement(READ_ID)){

            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){

                AttachmentsReadIdDto attachmentsDto = new AttachmentsReadIdDto(
                        rs.getString("fileName"),
                        rs.getString("commit"));
                list.add(attachmentsDto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<AttachmentsReadDto> read( int contact_id) {

        initDriver();

        ArrayList<AttachmentsReadDto> list = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pst = con.prepareStatement(READ)) {

            pst.setInt(1,contact_id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                AttachmentsReadDto attachmentsDto = new AttachmentsReadDto( rs.getString("fileName"), rs.getString("dateOfDownload"), rs.getString("commit"));
                list.add(attachmentsDto);
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
