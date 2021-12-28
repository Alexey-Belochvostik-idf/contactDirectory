package by.belohvostik.service.listphonesservice;

import by.belohvostik.dto.ListPhonesDto;

import java.util.List;

public interface ListPhonesService {

    void update(ListPhonesDto listPhonesDto);

    List<ListPhonesDto> read();

    void delete(int id);

}
