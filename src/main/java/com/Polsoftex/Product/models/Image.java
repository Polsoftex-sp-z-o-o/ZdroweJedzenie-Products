package com.Polsoftex.Product.models;

        import org.hibernate.annotations.Type;

        import javax.persistence.*;
        import java.sql.Blob;
        import java.util.UUID;

@Entity
public class Image {

    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column
    private Blob image;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public Blob getImage() { return image; }
    public void  setImage(Blob image) { this.image = image; }

}
