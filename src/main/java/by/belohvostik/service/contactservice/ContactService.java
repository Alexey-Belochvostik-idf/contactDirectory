package by.belohvostik.service.contactservice;

import by.belohvostik.dto.ContactsReadDto;
import by.belohvostik.dto.ContactsDto;
import by.belohvostik.dto.ContactsReadIdDto;

import java.util.List;


public interface ContactService {

    int createDtoToEntity(ContactsDto contactsDto);

    void updateDtoToEntity(ContactsDto contactsDto, int id);

    List<ContactsReadIdDto> readId(int id);

    List<ContactsReadDto> read();

    void delete(int id);

}
