package by.belohvostik.servlet;

import by.belohvostik.dto.attachmentsdto.AttachmentsReadIdDto;
import by.belohvostik.dto.attachmentsdto.AttachmentsReadDto;
import by.belohvostik.service.attachmentsservice.AttachmentsService;
import by.belohvostik.service.attachmentsservice.AttachmentsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/attachments", "/attachments/*"})
public class AttachmentsServlet extends HttpServlet {

    private final AttachmentsService attachmentsService = new AttachmentsServiceImpl();

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getPathInfo() != null) {
            int id = Integer.parseInt(req.getPathInfo().replace("/", ""));
            final List<AttachmentsReadIdDto> readId = attachmentsService.readId(id);

            String jsonReadId = mapper.writeValueAsString(readId);
            resp.getWriter().write(jsonReadId);
        } else {
            final List<AttachmentsReadDto> all = attachmentsService.read();

            String jsonRead = mapper.writeValueAsString(all);
            resp.getWriter().write(jsonRead);
        }
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().close();

    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {

        int id = Integer.parseInt(req.getPathInfo().replace("/", ""));

        attachmentsService.delete(id);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);

    }
}
