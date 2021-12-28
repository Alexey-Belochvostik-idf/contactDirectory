package by.belohvostik.dao.attachmentsdao;

import by.belohvostik.dto.AttachmentsDto;
import by.belohvostik.entity.AttachmentsEntity;

import java.util.List;

public interface AttachmentsDao {

    void update(AttachmentsEntity attachmentsEntity);

    List<AttachmentsDto> read();

    void delete(int id);

}
