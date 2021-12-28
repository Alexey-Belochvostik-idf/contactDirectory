package by.belohvostik.service.listphonesservice;

import by.belohvostik.dao.Listphonesdao.ListPhonesDao;
import by.belohvostik.dao.Listphonesdao.ListPhonesDaoImpl;
import by.belohvostik.dto.ListPhonesDto;
import by.belohvostik.entity.ListPhonesEntity;


import java.util.List;

public class ListPhonesServiceImpl implements ListPhonesService {

    private final ListPhonesDao listPhonesDao = new ListPhonesDaoImpl();

    @Override
    public void update(ListPhonesEntity listPhonesEntity) {

        ListPhonesDto listPhonesDto = new ListPhonesDto(listPhonesEntity.getId(),listPhonesEntity.getCodeOfCountry(),listPhonesEntity.getCodeOperation(),
                listPhonesEntity.getPhoneNumber(),listPhonesEntity.getTypePhone(),listPhonesEntity.getCommit());
        listPhonesDao.update(listPhonesDto);

    }

    @Override
    public List<ListPhonesEntity> read() {

        return listPhonesDao.read();
    }

    @Override
    public void delete(int id) {

        listPhonesDao.delete(id);

    }
}
