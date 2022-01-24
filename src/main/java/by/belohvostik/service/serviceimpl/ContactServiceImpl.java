package by.belohvostik.service.serviceimpl;

import by.belohvostik.dao.contactsdao.ContactsDao;
import by.belohvostik.dao.contactsdao.ContactsDaoImpl;
import by.belohvostik.dto.contactsdto.ContactsDto;
import by.belohvostik.dto.contactsdto.ContactsReadDto;
import by.belohvostik.dto.contactsdto.ContactsReadIdDto;
import by.belohvostik.entity.ContactEntity;
import by.belohvostik.service.serviceinterface.ContactService;

import java.util.List;

public class ContactServiceImpl implements ContactService {

    private final ContactsDao contactsDao = new ContactsDaoImpl();

    @Override
    public int createDtoToEntity(ContactsDto contactsDto) {

        ContactEntity contactEntity = new ContactEntity(contactsDto);

        return contactsDao.create(contactEntity);
    }

    @Override
    public void updateDtoToEntity(ContactsDto contactsDto, int id) {

        ContactEntity contactEntity = new ContactEntity(id, contactsDto);

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
