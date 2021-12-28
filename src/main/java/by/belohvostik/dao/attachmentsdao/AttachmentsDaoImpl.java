package by.belohvostik.dao.attachmentsdao;

import by.belohvostik.entity.AttachmentsEntity;
import by.belohvostik.dto.AttachmentsDto;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AttachmentsDaoImpl implements AttachmentsDao {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/sys?serverTimezone=UTC";

    static final String USER = "root";
    static final String PASSWORD = "password";

    static final String UPDATE = "update attachments set fileName = ?, commit = ? where id = ? ";

    static final String READ = "select * from attachments ";

    static final String DELETE = "delete from attachments where id = ?";

    @Override
    public void update(AttachmentsEntity attachmentsEntity) {

        initDriver();

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement st = con.prepareStatement(UPDATE)) {

            st.setString(1, attachmentsEntity.getFileName());
            st.setString(2, attachmentsEntity.getCommit());
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<AttachmentsDto> read() {

        initDriver();

        ArrayList<AttachmentsDto> list = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement st = con.prepareStatement(READ)) {

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                AttachmentsDto attachmentsEntity = new AttachmentsDto(rs.getInt("id"), rs.getString("fileName"),
                        LocalDateTime.parse(rs.getString("dateOfDownload")), rs.getString("commit"));
                list.add(attachmentsEntity);
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
