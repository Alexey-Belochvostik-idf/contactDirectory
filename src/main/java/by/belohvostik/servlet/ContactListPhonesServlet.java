package by.belohvostik.servlet;

import by.belohvostik.dto.listphonesdto.ListPhonesReadDto;
import by.belohvostik.service.serviceinterface.ListPhonesService;
import by.belohvostik.service.serviceimpl.ListPhonesServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/contacts/list-phones/*"})
public class ContactListPhonesServlet extends HttpServlet {

    private final ListPhonesService listPhonesService = new ListPhonesServiceImpl();

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        if (req.getPathInfo() != null) {
            int contact_id = Integer.parseInt(req.getPathInfo().replace("/", ""));
            final List<ListPhonesReadDto> readId = listPhonesService.read(contact_id);

            String jsonReadId = mapper.writeValueAsString(readId);
            resp.setContentType("application/json;charset=UTF-8");
            resp.getWriter().write(jsonReadId);
        }
        resp.getWriter().close();

    }

}
