package by.belohvostik.servlet;

import by.belohvostik.dto.attachmentsdto.AttachmentsReadDto;
import by.belohvostik.service.serviceinterface.AttachmentsService;
import by.belohvostik.service.serviceimpl.AttachmentsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/contacts/attachments/*"})
public class ContactAttachmentsServlet extends HttpServlet {

    private final AttachmentsService attachmentsService = new AttachmentsServiceImpl();

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        if (req.getPathInfo() != null) {
            int contact_id = Integer.parseInt(req.getPathInfo().replace("/", ""));
            final List<AttachmentsReadDto> read = attachmentsService.read(contact_id);

            String jsonReadId = mapper.writeValueAsString(read);
            resp.setContentType("application/json;charset=UTF-8");
            resp.getWriter().write(jsonReadId);
        }
        resp.getWriter().close();

    }
}
