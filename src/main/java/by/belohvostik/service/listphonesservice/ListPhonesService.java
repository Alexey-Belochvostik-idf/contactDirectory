package by.belohvostik.service.listphonesservice;

import by.belohvostik.entity.ListPhonesEntity;

import java.util.List;

public interface ListPhonesService {

    void update(ListPhonesEntity listPhonesEntity);

    List<ListPhonesEntity> read();

    void delete(int id);

}
