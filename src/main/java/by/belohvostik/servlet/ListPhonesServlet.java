package by.belohvostik.servlet;

import by.belohvostik.dto.listphonesdto.ListPhoneDto;
import by.belohvostik.dto.listphonesdto.ListPhonesReadDto;
import by.belohvostik.service.listphonesservice.ListPhonesService;
import by.belohvostik.service.listphonesservice.ListPhonesServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/phones","/phones/*"})
public class ListPhonesServlet extends HttpServlet {

    private final ListPhonesService listPhonesService = new ListPhonesServiceImpl();

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

       if (req.getPathInfo() != null){
           int id = Integer.parseInt(req.getPathInfo().replace("/", ""));
           final List<ListPhoneDto> readId = listPhonesService.readID(id);

           String jsonReadId = mapper.writeValueAsString(readId);
           resp.getWriter().write(jsonReadId);
       }else {
           final List<ListPhonesReadDto> all = listPhonesService.read();

           String jsonRead = mapper.writeValueAsString(all);
           resp.getWriter().write(jsonRead);
       }
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().close();

    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp){

        int id = Integer.parseInt(req.getPathInfo().replace("/", ""));

        listPhonesService.delete(id);
    }
}
