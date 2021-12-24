package by.belohvostik.entity;

import java.util.Arrays;

public class ContactPhotoAddress {

    private byte[] photoAddress;

    public ContactPhotoAddress(byte[] photoAddress) {
        this.photoAddress = photoAddress;
    }

    public ContactPhotoAddress() {
    }

    public void setPhotoAddress(byte[] photoAddress) {
        this.photoAddress = photoAddress;
    }

    public byte[] getPhotoAddress() {
        return photoAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactPhotoAddress that = (ContactPhotoAddress) o;
        return Arrays.equals(photoAddress, that.photoAddress);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(photoAddress);
    }

    @Override
    public String toString() {
        return "ContactPhotoAddressEntity{" +
                "photoAddress=" + Arrays.toString(photoAddress) +
                '}';
    }
}
