package by.belohvostik.service.attachmentsservice;

import by.belohvostik.entity.AttachmentsEntity;

import java.util.List;

public interface AttachmentsService {

    void update(AttachmentsEntity attachmentsEntity);

    List<AttachmentsEntity> read();

    void delete(int id);

}
