package by.belohvostik.servlet;

import by.belohvostik.dao.contactsdao.ContactsDao;
import by.belohvostik.dao.contactsdao.DefContactsDao;
import by.belohvostik.dto.ContactDto;
import by.belohvostik.entity.ContactEntity;
import by.belohvostik.entity.GenderEntity;
import by.belohvostik.entity.MaritalStatusEntity;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/contacts", "/contacts/*" })
public class ContactsServlet extends HttpServlet {

    private final ContactsDao contactsDao = new DefContactsDao();
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String test = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ContactEntity contact = mapper.readValue(test, ContactEntity.class);
        ContactEntity contactEntity = new ContactEntity(contact.getId(), contact.getName(), contact.getSurname(), contact.getPatronymic(),
                contact.getDateOfBirth(), GenderEntity.valueOf(String.valueOf(contact.getGender())), String.valueOf(contact.getCitizenShip()),
                MaritalStatusEntity.valueOf(String.valueOf(contact.getMaritalStatus())),
                contact.getWebSite(), contact.getEmail(), contact.getPlaceOfWork(), contact.getPhotoAddress(), contact.getCountry(), contact.getCity(),
                contact.getStreet(), contact.getHouse(), contact.getApartment(), contact.getPostcode());
        contactsDao.create(contactEntity);
        resp.setStatus(HttpServletResponse.SC_CREATED);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getPathInfo() != null){
            int id = Integer.parseInt(req.getPathInfo().replace("/",""));
            final List<ContactDto> readId = contactsDao.readId(id);
            String jsonReadId = mapper.writeValueAsString(readId);
            resp.getWriter().write(jsonReadId);
        }else{
            final List<ContactDto> all = contactsDao.read();
            String jsonRead = mapper.writeValueAsString(all);
            resp.getWriter().write(jsonRead);
        }
        resp.setContentType("application/json");
        resp.getWriter().close();

    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getPathInfo().replace("/",""));
        String test = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ContactEntity contact = mapper.readValue(test, ContactEntity.class);
        ContactEntity contactEntity = new ContactEntity(id, contact.getName(), contact.getSurname(), contact.getPatronymic(),
                contact.getDateOfBirth(), GenderEntity.valueOf(String.valueOf(contact.getGender())), String.valueOf(contact.getCitizenShip()),
                MaritalStatusEntity.valueOf(String.valueOf(contact.getMaritalStatus())),
                contact.getWebSite(), contact.getEmail(), contact.getPlaceOfWork(), contact.getPhotoAddress(), contact.getCountry(), contact.getCity(),
                contact.getStreet(), contact.getHouse(), contact.getApartment(), contact.getPostcode());
        contactsDao.update(contactEntity);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getPathInfo().replace("/",""));

        contactsDao.delete(id);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);

    }
}
