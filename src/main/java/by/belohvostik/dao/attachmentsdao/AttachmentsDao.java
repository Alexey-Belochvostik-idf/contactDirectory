package by.belohvostik.dao.attachmentsdao;

import by.belohvostik.dto.AttachmentsDto;
import by.belohvostik.entity.AttachmentsEntity;

import java.util.List;

public interface AttachmentsDao {

    void update(AttachmentsDto attachmentsDto);

    List<AttachmentsEntity> read();

    void delete(int id);

}
