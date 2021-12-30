package by.belohvostik.dao.Listphonesdao;

import by.belohvostik.entity.ListPhonesEntity;
import by.belohvostik.dto.ListPhonesReadDto;

import java.util.List;

public interface ListPhonesDao {

    void update(ListPhonesEntity listPhonesEntity);

    List<ListPhonesReadDto> read();

    void delete(int id);
}
