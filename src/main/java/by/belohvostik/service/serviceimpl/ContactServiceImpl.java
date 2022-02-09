package by.belohvostik.service.serviceimpl;

import by.belohvostik.dao.contactsdao.ContactsDao;
import by.belohvostik.dao.contactsdao.ContactsDaoImpl;
import by.belohvostik.dto.contactsdto.ContactsDto;
import by.belohvostik.dto.contactsdto.ContactsReadDto;
import by.belohvostik.dto.contactsdto.ContactsReadIdDto;
import by.belohvostik.entity.ContactEntity;
import by.belohvostik.service.serviceinterface.ContactService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Base64;
import java.util.List;

public class ContactServiceImpl implements ContactService {

    private final ContactsDao contactsDao = new ContactsDaoImpl();

    @Override
    public int createDtoToEntity(ContactsDto contactsDto) {

        byte[] image = Base64.getMimeDecoder().decode(contactsDto.getAttachments().getData().getBytes(StandardCharsets.UTF_8));
        String dirName = "E:\\imageProject";
        try {
            BufferedImage imag = ImageIO.read(new ByteArrayInputStream(image));
            ImageIO.write(imag, "jpg", new File(dirName, contactsDto.getAttachments().getFileName() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String absolutPath = String.valueOf(Path.of(dirName).toAbsolutePath());

        ContactEntity contactEntity = new ContactEntity(contactsDto);
        contactEntity.getAttachments().setData(absolutPath);

        return contactsDao.create(contactEntity);
    }

    @Override
    public void updateDtoToEntity(ContactsDto contactsDto, int id) {

        byte[] image = Base64.getMimeDecoder().decode(contactsDto.getAttachments().getData().getBytes(StandardCharsets.UTF_8));
        String dirName = "E:\\imageProject";
        try {
            BufferedImage imag = ImageIO.read(new ByteArrayInputStream(image));
            ImageIO.write(imag, "jpg", new File(dirName, contactsDto.getAttachments().getFileName() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String absolutPath = String.valueOf(Path.of(dirName).toAbsolutePath());

        ContactEntity contactEntity = new ContactEntity(id, contactsDto);
        contactEntity.getAttachments().setData(absolutPath);

        contactsDao.update(contactEntity);

    }

    @Override
    public List<ContactsReadIdDto> readId(int id) {

        return contactsDao.readId(id);
    }

    @Override
    public List<ContactsReadDto> read() {

        return contactsDao.read();
    }

    @Override
    public void delete(int id) {

        contactsDao.delete(id);

    }
}
