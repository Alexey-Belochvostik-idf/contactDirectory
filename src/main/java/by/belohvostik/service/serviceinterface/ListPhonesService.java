package by.belohvostik.service.serviceinterface;

import by.belohvostik.dto.listphonesdto.ListPhoneReadIdDto;
import by.belohvostik.dto.listphonesdto.ListPhonesReadDto;

import java.util.List;

public interface ListPhonesService {

    List<ListPhoneReadIdDto> readID(int id);

    List<ListPhonesReadDto> read(int contact_id);

    void delete(int id);

}
