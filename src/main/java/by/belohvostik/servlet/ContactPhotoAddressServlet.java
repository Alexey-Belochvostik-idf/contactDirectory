package by.belohvostik.servlet;

import by.belohvostik.dao.contactsdao.ContactsDao;
import by.belohvostik.dao.contactsdao.ContactsDaoImpl;
import by.belohvostik.entity.ContactPhotoAddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;

@WebServlet("/createphoto")
@MultipartConfig(maxRequestSize = 11000000, maxFileSize = 10000000)
public class ContactPhotoAddressServlet extends HttpServlet {

    private final ContactsDao contactsDao = new ContactsDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Part photoPart = req.getPart("photoAddress");
        String fileName = photoPart.getSubmittedFileName();

        ContactPhotoAddress contactPhotoAddress = new ContactPhotoAddress();

        OutputStream out = null;
        InputStream in = null;
        File tempFile = null;
        try {

            tempFile = File.createTempFile("temp_file", null);
            out = new FileOutputStream(tempFile);
            in = photoPart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            byte[] photoBytes = Files.readAllBytes(tempFile.toPath());
            contactPhotoAddress.setPhotoAddress(photoBytes);

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
            if (tempFile != null) {
                tempFile.delete();
            }
        }
        contactsDao.addPhotoAddress(contactPhotoAddress);
    }
}
