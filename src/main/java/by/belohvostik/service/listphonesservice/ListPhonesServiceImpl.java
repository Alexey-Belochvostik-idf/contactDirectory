package by.belohvostik.service.listphonesservice;

import by.belohvostik.dao.Listphonesdao.ListPhonesDao;
import by.belohvostik.dao.Listphonesdao.ListPhonesDaoImpl;
import by.belohvostik.entity.ListPhonesEntity;
import by.belohvostik.dto.ListPhonesDto;


import java.util.List;

public class ListPhonesServiceImpl implements ListPhonesService {

    private final ListPhonesDao listPhonesDao = new ListPhonesDaoImpl();

    @Override
    public void update(ListPhonesDto listPhonesDto) {

        ListPhonesEntity listPhonesEntity = new ListPhonesEntity(listPhonesDto.getId(),listPhonesDto.getCodeOfCountry(),listPhonesDto.getCodeOperation(),
                listPhonesDto.getPhoneNumber(),listPhonesDto.getTypePhone(),listPhonesDto.getCommit());
        listPhonesDao.update(listPhonesEntity);

    }

    @Override
    public List<ListPhonesDto> read() {

        return listPhonesDao.read();
    }

    @Override
    public void delete(int id) {

        listPhonesDao.delete(id);

    }
}
