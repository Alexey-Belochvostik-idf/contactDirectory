package by.belohvostik.service.contactservice;

import by.belohvostik.dto.ContactDto;
import by.belohvostik.dto.ContactsCreateUpdateDto;
import by.belohvostik.entity.ContactEntity;

import java.util.List;


public interface ContactService {

    void mapperCreateEntityToDto(ContactsCreateUpdateDto contactsCreateUpdateDto);

    void mapperUpdateEntityToDto(ContactsCreateUpdateDto contactsCreateUpdateDto, int id);

    List<ContactDto> readId(int id);

    List<ContactDto> read();

    void delete(int id);

}
