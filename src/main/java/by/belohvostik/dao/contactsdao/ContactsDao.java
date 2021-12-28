package by.belohvostik.dao.contactsdao;

import by.belohvostik.dto.ContactDto;
import by.belohvostik.dto.ContactsCreateUpdateDto;
import by.belohvostik.entity.ContactPhotoAddress;

import java.util.List;

public interface ContactsDao {

    void create(ContactsCreateUpdateDto contactsCreateUpdateDto);

    void update(ContactsCreateUpdateDto contactsCreateUpdateDto);

    List<ContactDto> readId(int id);

    List<ContactDto> read();

    void delete(int id);

    void addPhotoAddress(ContactPhotoAddress contactPhotoAddressEntity);


}
