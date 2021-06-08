package com.Polsoftex.Product.models.dto;

import java.sql.Blob;
import java.util.UUID;

public class ImageDto {

    private UUID id;
    private byte[] image;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public byte[] getImage() { return image; }
    public void  setImage(byte[] image) { this.image = image; }

}
