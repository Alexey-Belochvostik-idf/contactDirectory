package by.belohvostik.dao.contactsdao;

import by.belohvostik.dto.ContactDto;
import by.belohvostik.entity.ContactEntity;
import by.belohvostik.entity.ContactPhotoAddress;

import java.util.List;

public interface ContactsDao {

    void create(ContactEntity contactEntity);

    void update(ContactEntity contactEntity);

    List<ContactDto> readId(int id);

    List<ContactDto> read();

    void delete(int id);

    void addPhotoAddress(ContactPhotoAddress contactPhotoAddressEntity);


}
