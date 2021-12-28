package by.belohvostik.service.contactservice;

import by.belohvostik.dao.contactsdao.ContactsDao;
import by.belohvostik.dao.contactsdao.ContactsDaoImpl;
import by.belohvostik.dto.ContactDto;
import by.belohvostik.dto.ContactsCreateUpdateDto;
import by.belohvostik.entity.ContactEntity;

import java.util.List;

public class ContactServiceImpl implements ContactService {

    private final ContactsDao contactsDao = new ContactsDaoImpl();

    @Override
    public int createDtoToEntity(ContactsCreateUpdateDto contactsCreateUpdateDto) {

        ContactEntity contactEntity = new ContactEntity(contactsCreateUpdateDto);

        return contactsDao.create(contactEntity);
    }

    @Override
    public void updateDtoToEntity(ContactsCreateUpdateDto contactsCreateUpdateDto, int id) {

        ContactEntity contactEntity = new ContactEntity(id, contactsCreateUpdateDto);

        contactsDao.update(contactEntity);

    }

    @Override
    public List<ContactDto> readId(int id) {

        contactsDao.readId(id);

        return contactsDao.readId(id);
    }

    @Override
    public List<ContactDto> read() {

        return contactsDao.read();
    }

    @Override
    public void delete(int id) {

        contactsDao.delete(id);

    }
}
