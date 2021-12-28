package by.belohvostik.dao.Listphonesdao;

import by.belohvostik.dto.ListPhonesDto;
import by.belohvostik.entity.ListPhonesEntity;

import java.util.List;

public interface ListPhonesDao {

    void update(ListPhonesDto listPhoneDto);

    List<ListPhonesEntity> read();

    void delete(int id);
}
