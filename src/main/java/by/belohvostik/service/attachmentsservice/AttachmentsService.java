package by.belohvostik.service.attachmentsservice;

import by.belohvostik.dto.attachmentsdto.AttachmentsReadIdDto;
import by.belohvostik.dto.attachmentsdto.AttachmentsReadDto;

import java.util.List;

public interface AttachmentsService {

    List<AttachmentsReadIdDto> readId(int id);

    List<AttachmentsReadDto> read(int contact_id);

    void delete(int id);

}
