package by.belohvostik.service.listphonesservice;

import by.belohvostik.dto.listphonesdto.ListPhoneDto;
import by.belohvostik.dto.listphonesdto.ListPhonesReadDto;

import java.util.List;

public interface ListPhonesService {

    List<ListPhoneDto> readID(int id);

    List<ListPhonesReadDto> read();

    void delete(int id);

}
