package by.belohvostik.service.attachmentsservice;

import by.belohvostik.dao.attachmentsdao.AttachmentsDao;
import by.belohvostik.dao.attachmentsdao.AttachmentsDaoImpl;
import by.belohvostik.entity.AttachmentsEntity;
import by.belohvostik.dto.AttachmentsDto;

import java.util.List;

public class AttachmentsServiceImpl implements AttachmentsService {

    private final AttachmentsDao attachmentsDao = new AttachmentsDaoImpl();

    @Override
    public void update(AttachmentsDto attachmentsDto) {

        AttachmentsEntity attachmentsEntity = new AttachmentsEntity(attachmentsDto.getFileName(), attachmentsDto.getCommit());
        attachmentsDao.update(attachmentsEntity);

    }

    @Override
    public List<AttachmentsDto> read() {

        return attachmentsDao.read();
    }

    @Override
    public void delete(int id) {

        attachmentsDao.delete(id);

    }
}
