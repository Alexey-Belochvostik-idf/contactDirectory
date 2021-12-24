package by.belohvostik.dao.editingphonesdao;

import by.belohvostik.entity.EditingPhonesEntity;

import java.util.List;

public interface EditingPhonesDao {

    void update(EditingPhonesEntity editingPhonesEntity);

    List<EditingPhonesEntity> read();

    void delete(int id);
}
