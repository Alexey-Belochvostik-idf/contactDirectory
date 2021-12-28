package by.belohvostik.service.contactservice;

import by.belohvostik.dto.ContactDto;
import by.belohvostik.entity.ContactEntity;

import java.util.List;


public interface ContactService {

    void mapperCreateEntityToDto(ContactEntity contactEntity);

    void mapperUpdateEntityToDto(ContactEntity contactEntity, int id);

    List<ContactDto> readId(int id);

    List<ContactDto> read();

    void delete(int id);

}
