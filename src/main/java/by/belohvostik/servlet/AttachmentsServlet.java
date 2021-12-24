package by.belohvostik.servlet;

import by.belohvostik.dao.attachmentsdao.AttachmentsDao;
import by.belohvostik.dao.attachmentsdao.DefAttachmentsDao;
import by.belohvostik.dto.AttachmentsDto;
import by.belohvostik.entity.AttachmentsEntity;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/attachments","/attachments/*"})
public class AttachmentsServlet extends HttpServlet {

    private final AttachmentsDao attachmentsDao = new DefAttachmentsDao();

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getPathInfo();
        final List<AttachmentsEntity> all = attachmentsDao.read();
        String jsonRead = mapper.writeValueAsString(all);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(jsonRead);
        resp.getWriter().close();

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String test = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        AttachmentsDto attachments = mapper.readValue(test, AttachmentsDto.class);

        AttachmentsDto attachmentsDto = new AttachmentsDto(attachments.getFileName(), attachments.getCommit());
        attachmentsDao.update(attachmentsDto);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getPathInfo().replace("/", ""));

        attachmentsDao.delete(id);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);

    }
}
