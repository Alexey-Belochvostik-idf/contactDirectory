package by.belohvostik.servlet;

import by.belohvostik.dao.editingphonesdao.DefEditingPhonesDao;
import by.belohvostik.dao.editingphonesdao.EditingPhonesDao;
import by.belohvostik.entity.EditingPhonesEntity;
import by.belohvostik.entity.TypePhone;
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

@WebServlet(urlPatterns = {"/editingphones","/editingphones/*"})
public class EditingPhonesServlet extends HttpServlet {

    private final EditingPhonesDao editingPhonesDao = new DefEditingPhonesDao();

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getPathInfo();
        final List<EditingPhonesEntity> all = editingPhonesDao.read();
        String jsonRead = mapper.writeValueAsString(all);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(jsonRead);
        resp.getWriter().close();

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String test = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        EditingPhonesEntity editingPhones = mapper.readValue(test, EditingPhonesEntity.class);
        EditingPhonesEntity editingPhonesEntity = new EditingPhonesEntity(editingPhones.getId(), editingPhones.getCodeOfCountry(), editingPhones.getCodeOperation(),
                editingPhones.getPhoneNumber(), TypePhone.valueOf(String.valueOf(editingPhones.getTypePhone())), editingPhones.getCommit());
        editingPhonesDao.update(editingPhonesEntity);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getPathInfo().replace("/", ""));

        editingPhonesDao.delete(id);
    }
}
