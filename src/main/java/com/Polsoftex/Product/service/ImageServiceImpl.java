package com.Polsoftex.Product.service;

import com.Polsoftex.Product.models.Image;
import com.Polsoftex.Product.models.dto.ImageDto;
import com.Polsoftex.Product.repositiories.ImageRepository;
import com.Polsoftex.Product.repositiories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Optional<Image> getImage(UUID id)
    {
        return imageRepository.findById(id);
    }


    @Override
    public Boolean setImage(ImageDto imageDto)
    {
        if(!productRepository.findById(imageDto.getId()).isPresent()) return false;

        Image image;
        Optional<Image> imageOptional = imageRepository.findById(imageDto.getId());

        if(imageOptional.isPresent()) image = imageOptional.get();
        else
        {
            image = new Image();
            image.setId(imageDto.getId());
        }

        image.setImage(imageDto.getImage());
        return true;
    }

}
