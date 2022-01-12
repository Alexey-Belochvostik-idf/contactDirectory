package by.belohvostik.dao.listphonesdao;

import by.belohvostik.dto.listphonesdto.ListPhoneReadIdDto;
import by.belohvostik.dto.listphonesdto.ListPhonesReadDto;

import java.util.List;

public interface ListPhonesDao {

    List<ListPhoneReadIdDto> readId(int id);

    List<ListPhonesReadDto> read(int contact_id);

    void delete(int id);
}
