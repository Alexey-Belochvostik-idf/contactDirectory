package by.belohvostik.dao.Listphonesdao;

import by.belohvostik.entity.ListPhonesEntity;
import by.belohvostik.dto.ListPhonesDto;

import java.util.List;

public interface ListPhonesDao {

    void update(ListPhonesEntity listPhonesEntity);

    List<ListPhonesDto> read();

    void delete(int id);
}
