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
    public void mapperCreateEntityToDto(ContactsCreateUpdateDto contactsCreateUpdateDto) {

        ContactEntity contactEntity = new ContactEntity(contactsCreateUpdateDto.getId(), contactsCreateUpdateDto.getName(), contactsCreateUpdateDto.getSurname(),
                contactsCreateUpdateDto.getPatronymic(), contactsCreateUpdateDto.getDateOfBirth(), contactsCreateUpdateDto.getGender(), contactsCreateUpdateDto.getCitizenShip(), contactsCreateUpdateDto.getMaritalStatus(),
                contactsCreateUpdateDto.getWebSite(), contactsCreateUpdateDto.getEmail(), contactsCreateUpdateDto.getPlaceOfWork(), contactsCreateUpdateDto.getPhotoAddress(), contactsCreateUpdateDto.getCountry(),
                contactsCreateUpdateDto.getCity(), contactsCreateUpdateDto.getStreet(), contactsCreateUpdateDto.getHouse(), contactsCreateUpdateDto.getApartment(), contactsCreateUpdateDto.getPostcode());

        contactsDao.create(contactEntity);
    }

    @Override
    public void mapperUpdateEntityToDto(ContactsCreateUpdateDto contactsCreateUpdateDto, int id) {

        ContactEntity contactEntity = new ContactEntity(id,contactsCreateUpdateDto.getName(), contactsCreateUpdateDto.getSurname(),
                contactsCreateUpdateDto.getPatronymic(), contactsCreateUpdateDto.getDateOfBirth(), contactsCreateUpdateDto.getGender(), contactsCreateUpdateDto.getCitizenShip(), contactsCreateUpdateDto.getMaritalStatus(),
                contactsCreateUpdateDto.getWebSite(), contactsCreateUpdateDto.getEmail(), contactsCreateUpdateDto.getPlaceOfWork(), contactsCreateUpdateDto.getPhotoAddress(), contactsCreateUpdateDto.getCountry(),
                contactsCreateUpdateDto.getCity(), contactsCreateUpdateDto.getStreet(), contactsCreateUpdateDto.getHouse(), contactsCreateUpdateDto.getApartment(), contactsCreateUpdateDto.getPostcode());

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
