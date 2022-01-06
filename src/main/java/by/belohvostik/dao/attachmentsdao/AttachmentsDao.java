package by.belohvostik.dao.attachmentsdao;

import by.belohvostik.dto.attachmentsdto.AttachmentsReadIdDto;
import by.belohvostik.dto.attachmentsdto.AttachmentsReadDto;

import java.util.List;

public interface AttachmentsDao {

    List<AttachmentsReadIdDto> readId(int id);

    List<AttachmentsReadDto> read();

    void delete(int id);

}
