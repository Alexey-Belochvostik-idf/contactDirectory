package by.belohvostik.dao.contactsdao;

import by.belohvostik.dto.contactsdto.ContactsReadDto;
import by.belohvostik.dto.contactsdto.ContactsReadIdDto;
import by.belohvostik.entity.ContactEntity;
import by.belohvostik.entity.ContactPhotoAddress;

import java.util.List;

public interface ContactsDao {

    int create(ContactEntity contactEntity);

    void update(ContactEntity contactEntity);

    List<ContactsReadIdDto> readId(int id);

    List<ContactsReadDto> read();

    void delete(int id);

    void addPhotoAddress(ContactPhotoAddress contactPhotoAddressEntity);


}
