package by.belohvostik.dao.listphonesdao;

import by.belohvostik.dto.listphonesdto.ListPhoneDto;
import by.belohvostik.dto.listphonesdto.ListPhonesReadDto;

import java.util.List;

public interface ListPhonesDao {

    List<ListPhoneDto> readId(int id);

    List<ListPhonesReadDto> read();

    void delete(int id);
}
