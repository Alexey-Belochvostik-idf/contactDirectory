package by.belohvostik.dao.attachmentsdao;

import by.belohvostik.dto.attachmentsdto.AttachmentsDto;
import by.belohvostik.dto.attachmentsdto.AttachmentsReadDto;
import by.belohvostik.entity.AttachmentsEntity;

import java.util.List;

public interface AttachmentsDao {

    List<AttachmentsDto> readId(int id);

    List<AttachmentsReadDto> read();

    void delete(int id);

}
