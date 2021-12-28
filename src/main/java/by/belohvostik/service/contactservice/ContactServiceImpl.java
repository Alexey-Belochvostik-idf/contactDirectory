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
    public void mapperCreateEntityToDto(ContactEntity contactEntity) {

        ContactsCreateUpdateDto contactsCreateDto = new ContactsCreateUpdateDto(contactEntity.getId(), contactEntity.getName(), contactEntity.getSurname(),
                contactEntity.getPatronymic(), contactEntity.getDateOfBirth(), contactEntity.getGender(), contactEntity.getCitizenShip(), contactEntity.getMaritalStatus(),
                contactEntity.getWebSite(), contactEntity.getEmail(), contactEntity.getPlaceOfWork(), contactEntity.getPhotoAddress(), contactEntity.getCountry(),
                contactEntity.getCity(), contactEntity.getStreet(), contactEntity.getHouse(), contactEntity.getApartment(), contactEntity.getPostcode());

        contactsDao.create(contactsCreateDto);
    }

    @Override
    public void mapperUpdateEntityToDto(ContactEntity contactEntity, int id) {

        ContactsCreateUpdateDto contactsUpdateDto = new ContactsCreateUpdateDto(id,contactEntity.getName(), contactEntity.getSurname(),
                contactEntity.getPatronymic(), contactEntity.getDateOfBirth(), contactEntity.getGender(), contactEntity.getCitizenShip(), contactEntity.getMaritalStatus(),
                contactEntity.getWebSite(), contactEntity.getEmail(), contactEntity.getPlaceOfWork(), contactEntity.getPhotoAddress(), contactEntity.getCountry(),
                contactEntity.getCity(), contactEntity.getStreet(), contactEntity.getHouse(), contactEntity.getApartment(), contactEntity.getPostcode());

        contactsDao.update(contactsUpdateDto);

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
