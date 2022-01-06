package by.belohvostik.service.listphonesservice;

import by.belohvostik.dao.listphonesdao.ListPhonesDao;
import by.belohvostik.dao.listphonesdao.ListPhonesDaoImpl;
import by.belohvostik.dto.listphonesdto.ListPhoneReadIdDto;
import by.belohvostik.dto.listphonesdto.ListPhonesReadDto;


import java.util.List;

public class ListPhonesServiceImpl implements ListPhonesService {

    private final ListPhonesDao listPhonesDao = new ListPhonesDaoImpl();

    @Override
    public List<ListPhoneReadIdDto> readID(int id) {
        return listPhonesDao.readId(id);
    }


    @Override
    public List<ListPhonesReadDto> read() {

        return listPhonesDao.read();
    }

    @Override
    public void delete(int id) {

        listPhonesDao.delete(id);

    }
}
