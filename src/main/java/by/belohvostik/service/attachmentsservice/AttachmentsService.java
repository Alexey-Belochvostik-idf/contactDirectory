package by.belohvostik.service.attachmentsservice;

import by.belohvostik.dto.attachmentsdto.AttachmentsDto;
import by.belohvostik.dto.attachmentsdto.AttachmentsReadDto;

import java.util.List;

public interface AttachmentsService {

    List<AttachmentsDto> readId(int id);

    List<AttachmentsReadDto> read();

    void delete(int id);

}
