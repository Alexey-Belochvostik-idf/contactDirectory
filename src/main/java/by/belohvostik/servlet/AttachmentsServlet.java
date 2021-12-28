package by.belohvostik.servlet;

import by.belohvostik.entity.AttachmentsEntity;
import by.belohvostik.dto.AttachmentsDto;
import by.belohvostik.service.attachmentsservice.AttachmentsService;
import by.belohvostik.service.attachmentsservice.AttachmentsServiceImpl;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/attachments","/attachments/*"})
public class AttachmentsServlet extends HttpServlet {

    private final AttachmentsService attachmentsService = new AttachmentsServiceImpl();

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        req.getPathInfo();
        final List<AttachmentsDto> all = attachmentsService.read();
        String jsonRead = mapper.writeValueAsString(all);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(jsonRead);
        resp.getWriter().close();

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

        String json = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        AttachmentsDto attachments = mapper.readValue(json, AttachmentsDto.class);
        attachmentsService.update(attachments);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {

        int id = Integer.parseInt(req.getPathInfo().replace("/", ""));

        attachmentsService.delete(id);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);

    }
}
