package by.belohvostik.service.contactservice;

import by.belohvostik.dto.ContactsReadDto;
import by.belohvostik.dto.ContactsDto;

import java.util.List;


public interface ContactService {

    int createDtoToEntity(ContactsDto contactsCreateUpdateDto);

    void updateDtoToEntity(ContactsDto contactsCreateUpdateDto, int id);

    List<ContactsReadDto> readId(int id);

    List<ContactsReadDto> read();

    void delete(int id);

}
