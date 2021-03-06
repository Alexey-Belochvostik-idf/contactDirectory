package by.belohvostik.servlet;

import by.belohvostik.dto.attachmentsdto.AttachmentsReadIdDto;
import by.belohvostik.service.serviceinterface.AttachmentsService;
import by.belohvostik.service.serviceimpl.AttachmentsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/attachments/*"})
public class AttachmentsServlet extends HttpServlet {

    private final AttachmentsService attachmentsService = new AttachmentsServiceImpl();

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getPathInfo() != null) {
            int id = Integer.parseInt(req.getPathInfo().replace("/", ""));
            final List<AttachmentsReadIdDto> readId = attachmentsService.readId(id);

            String jsonReadId = mapper.writeValueAsString(readId);
            resp.setContentType("application/json;charset=UTF-8");
            resp.getWriter().write(jsonReadId);
        }
        resp.getWriter().close();

    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {

        int id = Integer.parseInt(req.getPathInfo().replace("/", ""));

        attachmentsService.delete(id);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);

    }
}
