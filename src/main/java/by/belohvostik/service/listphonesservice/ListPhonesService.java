package by.belohvostik.service.listphonesservice;

import by.belohvostik.dto.ListPhoneDto;
import by.belohvostik.dto.ListPhonesReadDto;

import java.util.List;

public interface ListPhonesService {

    void update(ListPhoneDto listPhonesDto);

    List<ListPhonesReadDto> read();

    void delete(int id);

}
