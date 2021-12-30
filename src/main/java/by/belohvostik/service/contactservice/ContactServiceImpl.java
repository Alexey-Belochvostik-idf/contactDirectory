package by.belohvostik.service.contactservice;

import by.belohvostik.dao.contactsdao.ContactsDao;
import by.belohvostik.dao.contactsdao.ContactsDaoImpl;
import by.belohvostik.dto.ContactsReadDto;
import by.belohvostik.dto.ContactsDto;
import by.belohvostik.dto.ContactsReadIdDto;
import by.belohvostik.entity.ContactEntity;

import java.util.List;

public class ContactServiceImpl implements ContactService {

    private final ContactsDao contactsDao = new ContactsDaoImpl();

    @Override
    public int createDtoToEntity(ContactsDto contactsDto) {

        ContactEntity contactEntity = new ContactEntity(contactsDto);

        return contactsDao.create(contactEntity);
    }

    @Override
    public void updateDtoToEntity(ContactsDto contactsCreateUpdateDto, int id) {

        ContactEntity contactEntity = new ContactEntity(id, contactsCreateUpdateDto);

        contactsDao.update(contactEntity);

    }

    @Override
    public List<ContactsReadIdDto> readId(int id) {

        return contactsDao.readId(id);
    }

    @Override
    public List<ContactsReadDto> read() {

        return contactsDao.read();
    }

    @Override
    public void delete(int id) {

        contactsDao.delete(id);

    }
}
