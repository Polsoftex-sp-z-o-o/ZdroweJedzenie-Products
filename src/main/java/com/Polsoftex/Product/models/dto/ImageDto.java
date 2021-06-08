package com.Polsoftex.Product.models.dto;

import java.sql.Blob;
import java.util.UUID;

public class ImageDto {

    private UUID id;
    private Blob image;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public Blob getImage() { return image; }
    public void  setImage(Blob image) { this.image = image; }

}
