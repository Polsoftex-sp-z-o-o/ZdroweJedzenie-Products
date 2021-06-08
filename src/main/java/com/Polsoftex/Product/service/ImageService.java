package com.Polsoftex.Product.service;

import com.Polsoftex.Product.models.Image;
import com.Polsoftex.Product.models.dto.ImageDto;

import java.sql.Blob;
import java.util.Optional;
import java.util.UUID;

public interface ImageService {
    Optional<Image> getImage(UUID id);
    Boolean setImage(ImageDto imageDto);
}
