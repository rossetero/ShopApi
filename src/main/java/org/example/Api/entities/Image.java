package org.example.Api.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "images")
public class Image {
    private UUID id;
    private byte[] image;

    public Image(UUID id, byte[] image) {
        this.id = id;
        this.image = image;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", imageSize=" + (image != null ? image.length : 0) + " bytes" +
                '}';
    }
    
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Image otherImage = (Image) other;
        return Objects.equals(this.id, otherImage.id)
                && Arrays.equals(this.image, otherImage.image);
    }

    // Реализация метода hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id) + Arrays.hashCode(image);
    }
}
