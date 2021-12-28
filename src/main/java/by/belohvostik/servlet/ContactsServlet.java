package by.belohvostik.servlet;

import by.belohvostik.dto.ContactDto;
import by.belohvostik.entity.ContactEntity;
import by.belohvostik.service.contactservice.ContactService;
import by.belohvostik.service.contactservice.ContactServiceImpl;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/contacts", "/contacts/*" })
public class ContactsServlet extends HttpServlet {

    private final ContactService contactService = new ContactServiceImpl();
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String json = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ContactEntity contact = mapper.readValue(json, ContactEntity.class);
        contactService.mapperCreateEntityToDto(contact);
        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().println(" Ваш контак создан и ему присвоен номер : " );
        resp.getWriter().close();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        if (req.getPathInfo() != null) {
            int id = Integer.parseInt(req.getPathInfo().replace("/", ""));
            final List<ContactDto> readId = contactService.readId(id);
            String jsonReadId = mapper.writeValueAsString(readId);
            resp.getWriter().write(jsonReadId);
        } else {
            final List<ContactDto> all = contactService.read();
            String jsonRead = mapper.writeValueAsString(all);
            resp.getWriter().write(jsonRead);
        }
        resp.setContentType("application/json");
        resp.getWriter().close();

    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        int id = Integer.parseInt(req.getPathInfo().replace("/", ""));
        String json = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ContactEntity contact = mapper.readValue(json, ContactEntity.class);
        contactService.mapperUpdateEntityToDto(contact,id);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getPathInfo().replace("/", ""));

        contactService.delete(id);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);

    }
}
