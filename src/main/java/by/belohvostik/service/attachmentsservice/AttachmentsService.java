package by.belohvostik.service.attachmentsservice;

import by.belohvostik.dto.AttachmentsDto;

import java.util.List;

public interface AttachmentsService {

    void update(AttachmentsDto attachmentsDto);

    List<AttachmentsDto> read();

    void delete(int id);

}
