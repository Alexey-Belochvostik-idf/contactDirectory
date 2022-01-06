package by.belohvostik.service.listphonesservice;

import by.belohvostik.dto.listphonesdto.ListPhoneReadIdDto;
import by.belohvostik.dto.listphonesdto.ListPhonesReadDto;

import java.util.List;

public interface ListPhonesService {

    List<ListPhoneReadIdDto> readID(int id);

    List<ListPhonesReadDto> read();

    void delete(int id);

}
