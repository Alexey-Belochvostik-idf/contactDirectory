package by.belohvostik.servlet;

import by.belohvostik.dto.listphonesdto.ListPhoneReadIdDto;
import by.belohvostik.service.listphonesservice.ListPhonesService;
import by.belohvostik.service.listphonesservice.ListPhonesServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/phone/*"})
public class ListPhonesServlet extends HttpServlet {

    private final ListPhonesService listPhonesService = new ListPhonesServiceImpl();

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        if (req.getPathInfo() != null) {
            int id = Integer.parseInt(req.getPathInfo().replace("/", ""));
            final List<ListPhoneReadIdDto> all = listPhonesService.readID(id);

            String jsonRead = mapper.writeValueAsString(all);
            resp.setContentType("application/json;charset=UTF-8");
            resp.getWriter().write(jsonRead);
        }
        resp.getWriter().close();

    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {

        int id = Integer.parseInt(req.getPathInfo().replace("/", ""));

        listPhonesService.delete(id);
    }
}
