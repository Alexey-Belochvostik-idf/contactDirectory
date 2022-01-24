package by.belohvostik.service.serviceimpl;

import by.belohvostik.dao.listphonesdao.ListPhonesDao;
import by.belohvostik.dao.listphonesdao.ListPhonesDaoImpl;
import by.belohvostik.dto.listphonesdto.ListPhoneReadIdDto;
import by.belohvostik.dto.listphonesdto.ListPhonesReadDto;
import by.belohvostik.service.serviceinterface.ListPhonesService;

import java.util.List;

public class ListPhonesServiceImpl implements ListPhonesService {

    private final ListPhonesDao listPhonesDao = new ListPhonesDaoImpl();

    @Override
    public List<ListPhoneReadIdDto> readID(int id) {
        return listPhonesDao.readId(id);
    }


    @Override
    public List<ListPhonesReadDto> read(int contact_id) {

        return listPhonesDao.read(contact_id);
    }

    @Override
    public void delete(int id) {

        listPhonesDao.delete(id);

    }

}
