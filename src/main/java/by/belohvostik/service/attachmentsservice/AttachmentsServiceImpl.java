package by.belohvostik.service.attachmentsservice;

import by.belohvostik.dao.attachmentsdao.AttachmentsDao;
import by.belohvostik.dao.attachmentsdao.AttachmentsDaoImpl;
import by.belohvostik.dto.AttachmentsDto;
import by.belohvostik.entity.AttachmentsEntity;

import java.util.List;

public class AttachmentsServiceImpl implements AttachmentsService {

    private final AttachmentsDao attachmentsDao = new AttachmentsDaoImpl();

    @Override
    public void update(AttachmentsEntity attachmentsEntity) {

        AttachmentsDto attachmentsDto = new AttachmentsDto(attachmentsEntity.getFileName(), attachmentsEntity.getCommit());
        attachmentsDao.update(attachmentsDto);

    }

    @Override
    public List<AttachmentsEntity> read() {

        return attachmentsDao.read();
    }

    @Override
    public void delete(int id) {

        attachmentsDao.delete(id);

    }
}
