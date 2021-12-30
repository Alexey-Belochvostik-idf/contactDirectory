package by.belohvostik.servlet;

import by.belohvostik.dto.ListPhoneDto;
import by.belohvostik.dto.ListPhonesReadDto;
import by.belohvostik.service.listphonesservice.ListPhonesService;
import by.belohvostik.service.listphonesservice.ListPhonesServiceImpl;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/listphones","/listphones/*"})
public class ListPhonesServlet extends HttpServlet {

    private final ListPhonesService listPhonesService = new ListPhonesServiceImpl();

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.getPathInfo();
        final List<ListPhonesReadDto> all = listPhonesService.read();
        String jsonRead = mapper.writeValueAsString(all);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(jsonRead);
        resp.getWriter().close();

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String json = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ListPhoneDto listPhonesDto = mapper.readValue(json, ListPhoneDto.class);
        listPhonesService.update(listPhonesDto);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp){

        int id = Integer.parseInt(req.getPathInfo().replace("/", ""));

        listPhonesService.delete(id);
    }
}
