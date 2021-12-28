package by.belohvostik.service.contactservice;

import by.belohvostik.dto.ContactDto;
import by.belohvostik.dto.ContactsCreateUpdateDto;

import java.util.List;


public interface ContactService {

    int createDtoToEntity(ContactsCreateUpdateDto contactsCreateUpdateDto);

    void updateDtoToEntity(ContactsCreateUpdateDto contactsCreateUpdateDto, int id);

    List<ContactDto> readId(int id);

    List<ContactDto> read();

    void delete(int id);

}
