package by.belohvostik.service.attachmentsservice;

import by.belohvostik.dao.attachmentsdao.AttachmentsDao;
import by.belohvostik.dao.attachmentsdao.AttachmentsDaoImpl;
import by.belohvostik.dto.attachmentsdto.AttachmentsReadIdDto;
import by.belohvostik.dto.attachmentsdto.AttachmentsReadDto;

import java.util.List;

public class AttachmentsServiceImpl implements AttachmentsService {

    private final AttachmentsDao attachmentsDao = new AttachmentsDaoImpl();

    @Override
    public List<AttachmentsReadIdDto> readId(int id) {
        return attachmentsDao.readId(id);
    }

    @Override
    public List<AttachmentsReadDto> read() {

        return attachmentsDao.read();
    }

    @Override
    public void delete(int id) {

        attachmentsDao.delete(id);

    }
}
