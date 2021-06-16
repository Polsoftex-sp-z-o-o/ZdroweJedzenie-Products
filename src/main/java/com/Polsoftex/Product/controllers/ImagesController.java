package com.Polsoftex.Product.controllers;

import com.Polsoftex.Product.models.Image;
import com.Polsoftex.Product.models.dto.ImageDto;
import com.Polsoftex.Product.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class ImagesController {
    @Autowired
    private ImageService imageService;

    @GetMapping("/images/{id}")
    public ResponseEntity<Object> getImage(@PathVariable UUID id)
    {
        Optional<Image> imageOptional = imageService.getImage(id);
        if (imageOptional.isPresent())
            return new ResponseEntity<>(imageService.getImage(id), HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/images")
    public ResponseEntity<String> setImage(@RequestBody ImageDto imageDto)
    {
        if(imageService.setImage(imageDto))
        {
            return  new ResponseEntity<>("Successfully set image", HttpStatus.OK);
        }

        return new ResponseEntity<>("Image set failed", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/images")
    public ResponseEntity<Object> getAllImages()
    {
        return new ResponseEntity<>(imageService.getAll(), HttpStatus.OK);
    }
}
