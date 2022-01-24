package by.belohvostik.servlet;

import by.belohvostik.dto.contactsdto.ContactsDto;
import by.belohvostik.dto.contactsdto.ContactsReadDto;
import by.belohvostik.dto.contactsdto.ContactsReadIdDto;
import by.belohvostik.service.serviceimpl.ContactServiceImpl;
import by.belohvostik.service.serviceinterface.ContactService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/contacts", "/contacts/*"})
public class ContactsServlet extends HttpServlet {

    private final ContactService contactService = new ContactServiceImpl();

    private final ObjectMapper mapper = new ObjectMapper();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        String json = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ContactsDto contactsDto = mapper.readValue(json, ContactsDto.class);
        int idr = contactService.createDtoToEntity(contactsDto);

        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().println(idr);
        resp.getWriter().close();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        if (req.getPathInfo() != null) {
            int id = Integer.parseInt(req.getPathInfo().replace("/", ""));
             List<ContactsReadIdDto> readId = contactService.readId(id);

            String jsonReadId = mapper.writeValueAsString(readId);
            resp.setContentType("application/json;charset=UTF-8");
            resp.getWriter().write(jsonReadId);
        } else {
             List<ContactsReadDto> all = contactService.read();

            String jsonRead = mapper.writeValueAsString(all);
            resp.setContentType("application/json;charset=UTF-8");
            resp.getWriter().write(jsonRead);
        }
        resp.getWriter().close();

    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        int id = Integer.parseInt(req.getPathInfo().replace("/", ""));
        req.setCharacterEncoding("UTF-8");
        String json = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        ContactsDto contact = mapper.readValue(json, ContactsDto.class);
        contactService.updateDtoToEntity(contact, id);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getPathInfo().replace("/", ""));

        contactService.delete(id);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);

    }
}
